package com.example.spaceapp

import android.content.Intent
import android.os.Bundle
import android.graphics.Color
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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
    private lateinit var navSettings: LinearLayout
    private lateinit var tvNavHome: TextView
    private lateinit var tvNavSettings: TextView
    private lateinit var ivNavHome: ImageView
    private lateinit var ivNavSettings: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Set current nav index to Settings (1)
        HomeActivity.currentNavIndex = 1

        // Initialize views
        initViews()

        // Set profile data
        setupProfileData()

        // Set active state
        updateNavState(1)

        // Set up click listeners
        setupClickListeners()
    }

    override fun onResume() {
        super.onResume()
        updateNavState(1)
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
        navSettings = findViewById(R.id.navSettings)
        tvNavHome = findViewById(R.id.tvNavHome)
        tvNavSettings = findViewById(R.id.tvNavSettings)
        ivNavHome = findViewById(R.id.ivNavHome)
        ivNavSettings = findViewById(R.id.ivNavSettings)
    }

    private fun setupProfileData() {
        // Set profile name and level
        // In a real app, this would come from user data
        tvProfileName.text = "Space Explorer"
        tvLevel.text = "Level 5 Explorer"
    }

    private fun updateNavState(index: Int) {
        // Reset all to inactive
        tvNavHome.setTextColor(Color.parseColor("#AAAAAA"))
        tvNavSettings.setTextColor(Color.parseColor("#AAAAAA"))
        ivNavHome.setColorFilter(Color.parseColor("#AAAAAA"))
        ivNavSettings.setColorFilter(Color.parseColor("#AAAAAA"))

        // Set active
        when (index) {
            0 -> {
                tvNavHome.setTextColor(Color.parseColor("#6C5CE7"))
                ivNavHome.setColorFilter(Color.parseColor("#6C5CE7"))
            }
            1 -> {
                tvNavSettings.setTextColor(Color.parseColor("#6C5CE7"))
                ivNavSettings.setColorFilter(Color.parseColor("#6C5CE7"))
            }
        }
        HomeActivity.currentNavIndex = index
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

        navSettings.setOnClickListener {
            // Already on Settings
            Toast.makeText(this, "Already on Settings", Toast.LENGTH_SHORT).show()
        }
    }
}
