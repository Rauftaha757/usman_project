package com.example.spaceapp

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

/**
 * Home (Dashboard) Screen Activity
 * Main screen after successful login - Space Exploration App
 */
class HomeActivity : AppCompatActivity() {

    private lateinit var etSearch: EditText
    private lateinit var toolbar: Toolbar
    private lateinit var tvTitle: TextView
    private lateinit var ivNotification: ImageView
    private lateinit var tvViewAll: TextView
    private lateinit var cardMars: LinearLayout
    private lateinit var cardJupiter: LinearLayout
    private lateinit var cardOrion: LinearLayout

    // Bottom Nav
    private lateinit var navHome: LinearLayout
    private lateinit var navProfile: LinearLayout
    private lateinit var navSettings: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Set up the Toolbar as ActionBar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Initialize views
        initViews()

        // Set up click listeners
        setupClickListeners()
    }

    private fun initViews() {
        etSearch = findViewById(R.id.etSearch)
        tvTitle = findViewById(R.id.tvTitle)
        ivNotification = findViewById(R.id.ivNotification)
        tvViewAll = findViewById(R.id.tvViewAll)
        cardMars = findViewById(R.id.cardMars)
        cardJupiter = findViewById(R.id.cardJupiter)
        cardOrion = findViewById(R.id.cardOrion)

        // Bottom Nav
        navHome = findViewById(R.id.navHome)
        navProfile = findViewById(R.id.navProfile)
        navSettings = findViewById(R.id.navSettings)
    }

    private fun setupClickListeners() {
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
            Toast.makeText(this, "Jupiter - The largest planet in our solar system", Toast.LENGTH_SHORT).show()
        }

        cardOrion.setOnClickListener {
            Toast.makeText(this, "Orion Nebula - A diffuse nebula in the Milky Way", Toast.LENGTH_SHORT).show()
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
