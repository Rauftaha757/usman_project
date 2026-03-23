package com.example.spaceapp

import android.content.Intent
import android.os.Bundle
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

/**
 * Settings Screen Activity
 * App settings and preferences with profile section
 */
class SettingsActivity : AppCompatActivity() {

    // Profile Views
    private lateinit var ivProfilePic: ImageView
    private lateinit var tvProfileName: TextView
    private lateinit var tvLevel: TextView

    // Settings Items
    private lateinit var itemMissions: LinearLayout
    private lateinit var itemAchievements: LinearLayout
    private lateinit var itemNotifications: LinearLayout
    private lateinit var itemLogout: LinearLayout

    // Bottom Nav
    private lateinit var navHome: LinearLayout
    private lateinit var navProfile: LinearLayout
    private lateinit var navSettings: LinearLayout
    private lateinit var tvNavHome: TextView
    private lateinit var tvNavProfile: TextView
    private lateinit var tvNavSettings: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Set current nav index to Settings (2)
        HomeActivity.currentNavIndex = 2

        // Set up the Toolbar as ActionBar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Initialize views
        initViews()

        // Set profile data
        setupProfileData()

        // Set active state
        updateNavState(2)

        // Set up click listeners
        setupClickListeners()
    }

    override fun onResume() {
        super.onResume()
        updateNavState(2)
    }

    private fun initViews() {
        // Profile views
        ivProfilePic = findViewById(R.id.ivProfilePic)
        tvProfileName = findViewById(R.id.tvProfileName)
        tvLevel = findViewById(R.id.tvLevel)

        // Settings items
        itemMissions = findViewById(R.id.itemMissions)
        itemAchievements = findViewById(R.id.itemAchievements)
        itemNotifications = findViewById(R.id.itemNotifications)
        itemLogout = findViewById(R.id.itemLogout)

        // Bottom Nav
        navHome = findViewById(R.id.navHome)
        navProfile = findViewById(R.id.navProfile)
        navSettings = findViewById(R.id.navSettings)
        tvNavHome = findViewById(R.id.tvNavHome)
        tvNavProfile = findViewById(R.id.tvNavProfile)
        tvNavSettings = findViewById(R.id.tvNavSettings)
    }

    private fun setupProfileData() {
        // Set profile name and level
        // In a real app, this would come from user data
        tvProfileName.text = "Space Explorer"
        tvLevel.text = "Level 5"
    }

    private fun updateNavState(index: Int) {
        // Reset all to inactive
        tvNavHome.setTextColor(Color.parseColor("#AAAAAA"))
        tvNavProfile.setTextColor(Color.parseColor("#AAAAAA"))
        tvNavSettings.setTextColor(Color.parseColor("#AAAAAA"))

        // Set active
        when (index) {
            0 -> tvNavHome.setTextColor(Color.parseColor("#6C5CE7"))
            1 -> tvNavProfile.setTextColor(Color.parseColor("#6C5CE7"))
            2 -> tvNavSettings.setTextColor(Color.parseColor("#6C5CE7"))
        }
        HomeActivity.currentNavIndex = index
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun setupClickListeners() {
        itemMissions.setOnClickListener {
            Toast.makeText(this, "My Missions", Toast.LENGTH_SHORT).show()
        }

        itemAchievements.setOnClickListener {
            Toast.makeText(this, "Achievements", Toast.LENGTH_SHORT).show()
        }

        itemNotifications.setOnClickListener {
            Toast.makeText(this, "Notifications", Toast.LENGTH_SHORT).show()
        }

        itemLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        navHome.setOnClickListener {
            updateNavState(0)
            finish()
        }

        navProfile.setOnClickListener {
            updateNavState(1)
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
        }

        navSettings.setOnClickListener {
            // Already on Settings
            Toast.makeText(this, "Already on Settings", Toast.LENGTH_SHORT).show()
        }
    }
}
