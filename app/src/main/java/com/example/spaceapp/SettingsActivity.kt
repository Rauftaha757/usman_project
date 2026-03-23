package com.example.spaceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar

/**
 * Settings Screen Activity
 * App settings and preferences
 */
class SettingsActivity : AppCompatActivity() {

    private lateinit var itemDarkMode: LinearLayout
    private lateinit var itemLanguage: LinearLayout
    private lateinit var itemAbout: LinearLayout
    private lateinit var toggleDarkMode: View
    private lateinit var btnLogout: AppCompatButton

    // Bottom Nav
    private lateinit var navHome: LinearLayout
    private lateinit var navProfile: LinearLayout
    private lateinit var navSettings: LinearLayout

    private var isDarkModeOn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Set up the Toolbar as ActionBar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Initialize views
        initViews()

        // Set up click listeners
        setupClickListeners()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun initViews() {
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
