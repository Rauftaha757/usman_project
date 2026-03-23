package com.example.spaceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * Settings Screen Activity
 * App settings and preferences
 */
class SettingsActivity : AppCompatActivity() {

    private lateinit var ivBackIcon: ImageView
    private lateinit var itemDarkMode: LinearLayout
    private lateinit var itemLanguage: LinearLayout
    private lateinit var itemAbout: LinearLayout
    private lateinit var toggleDarkMode: View
    private lateinit var btnLogout: AppCompatButton
    private lateinit var mainContent: View

    // Bottom Nav
    private lateinit var navHome: LinearLayout
    private lateinit var navProfile: LinearLayout
    private lateinit var navSettings: LinearLayout

    private var isDarkModeOn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Handle edge-to-edge display with safe areas
        setupWindowInsets()

        // Initialize views
        initViews()

        // Set up click listeners
        setupClickListeners()
    }

    private fun setupWindowInsets() {
        mainContent = findViewById(R.id.mainContent)

        ViewCompat.setOnApplyWindowInsetsListener(mainContent) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            // Apply padding for status bar at top
            val scrollView = findViewById<View>(R.id.scrollView)
            scrollView.setPadding(
                scrollView.paddingLeft,
                systemBars.top + 16,
                scrollView.paddingRight,
                scrollView.paddingBottom
            )

            insets
        }
    }

    private fun initViews() {
        ivBackIcon = findViewById(R.id.ivBackIcon)
        itemDarkMode = findViewById(R.id.itemDarkMode)
        itemLanguage = findViewById(R.id.itemLanguage)
        itemAbout = findViewById(R.id.itemAbout)
        toggleDarkMode = findViewById(R.id.toggleDarkMode)
        btnLogout = findViewById(R.id.btnLogout)

        // Bottom Nav
        navHome = findViewById(R.id.navHome)
        navProfile = findViewById(R.id.navProfile)
        navSettings = findViewById(R.id.navSettings)
    }

    private fun setupClickListeners() {
        ivBackIcon.setOnClickListener {
            finish()
        }

        itemDarkMode.setOnClickListener {
            isDarkModeOn = !isDarkModeOn
            toggleDarkMode.setBackgroundResource(
                if (isDarkModeOn) R.drawable.ic_toggle_on else R.drawable.ic_toggle_off
            )
            Toast.makeText(this, "Dark Mode: ${if (isDarkModeOn) "On" else "Off"}", Toast.LENGTH_SHORT).show()
        }

        itemLanguage.setOnClickListener {
            Toast.makeText(this, "Language Settings", Toast.LENGTH_SHORT).show()
        }

        itemAbout.setOnClickListener {
            Toast.makeText(this, "Space App v1.0", Toast.LENGTH_SHORT).show()
        }

        btnLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        navHome.setOnClickListener {
            finish()
        }

        navProfile.setOnClickListener {
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
        }

        navSettings.setOnClickListener {
            Toast.makeText(this, "Already on Settings", Toast.LENGTH_SHORT).show()
        }
    }
}
