package com.example.spaceapp

import android.content.Intent
import android.os.Bundle
import android.graphics.Color
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

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
    private lateinit var navSettings: LinearLayout
    private lateinit var tvNavHome: TextView
    private lateinit var tvNavSettings: TextView
    private lateinit var ivNavHome: ImageView
    private lateinit var ivNavSettings: ImageView

    companion object {
        var currentNavIndex: Int = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Set current nav index to Home (0)
        currentNavIndex = 0

        // Set up the Toolbar as ActionBar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Initialize views
        initViews()

        // Set active state
        updateNavState(0)

        // Set up click listeners
        setupClickListeners()
    }

    override fun onResume() {
        super.onResume()
        updateNavState(currentNavIndex)
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
        navSettings = findViewById(R.id.navSettings)
        tvNavHome = findViewById(R.id.tvNavHome)
        tvNavSettings = findViewById(R.id.tvNavSettings)
        ivNavHome = findViewById(R.id.ivNavHome)
        ivNavSettings = findViewById(R.id.ivNavSettings)
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
        currentNavIndex = index
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
            if (currentNavIndex != 0) {
                updateNavState(0)
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
            }
        }

        navSettings.setOnClickListener {
            updateNavState(1)
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}
