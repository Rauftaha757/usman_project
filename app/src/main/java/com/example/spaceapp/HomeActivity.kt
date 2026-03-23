package com.example.spaceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * Home (Dashboard) Screen Activity
 * Main screen after successful login - Space Exploration App
 */
class HomeActivity : AppCompatActivity() {

    private lateinit var etSearch: EditText
    private lateinit var ivHomeIcon: ImageView
    private lateinit var ivNotification: ImageView
    private lateinit var tvViewAll: TextView
    private lateinit var cardMars: LinearLayout
    private lateinit var cardJupiter: LinearLayout
    private lateinit var cardSaturn: LinearLayout
    private lateinit var mainContent: View

    // Bottom Nav
    private lateinit var navHome: LinearLayout
    private lateinit var navProfile: LinearLayout
    private lateinit var navSettings: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

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
            // Bottom navigation already handles its own insets
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
        etSearch = findViewById(R.id.etSearch)
        ivHomeIcon = findViewById(R.id.ivHomeIcon)
        ivNotification = findViewById(R.id.ivNotification)
        tvViewAll = findViewById(R.id.tvViewAll)
        cardMars = findViewById(R.id.cardMars)
        cardJupiter = findViewById(R.id.cardJupiter)
        cardSaturn = findViewById(R.id.cardSaturn)

        // Bottom Nav
        navHome = findViewById(R.id.navHome)
        navProfile = findViewById(R.id.navProfile)
        navSettings = findViewById(R.id.navSettings)
    }

    private fun setupClickListeners() {
        ivHomeIcon.setOnClickListener {
            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
        }

        ivNotification.setOnClickListener {
            Toast.makeText(this, "Notifications", Toast.LENGTH_SHORT).show()
        }

        etSearch.setOnEditorActionListener { _, _, _ ->
            val query = etSearch.text.toString()
            Toast.makeText(this, "Searching: $query", Toast.LENGTH_SHORT).show()
            true
        }

        tvViewAll.setOnClickListener {
            Toast.makeText(this, "View All Discoveries", Toast.LENGTH_SHORT).show()
        }

        cardMars.setOnClickListener {
            Toast.makeText(this, "Mars - The Red Planet", Toast.LENGTH_SHORT).show()
        }

        cardJupiter.setOnClickListener {
            Toast.makeText(this, "Jupiter - Gas Giant", Toast.LENGTH_SHORT).show()
        }

        cardSaturn.setOnClickListener {
            Toast.makeText(this, "Saturn - Ringed Planet", Toast.LENGTH_SHORT).show()
        }

        navHome.setOnClickListener {
            Toast.makeText(this, "Already on Home", Toast.LENGTH_SHORT).show()
        }

        navProfile.setOnClickListener {
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
        }

        navSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}
