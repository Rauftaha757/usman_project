package com.example.spaceapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * Login Screen Activity - Space Explorer
 * Handles user authentication and navigation to Home screen
 */
class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var ivTogglePassword: ImageView
    private lateinit var btnSignIn: AppCompatButton
    private lateinit var tvSignUp: TextView
    private lateinit var signUpContainer: LinearLayout
    private lateinit var mainContent: View

    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

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
            val navigationBars = insets.getInsets(WindowInsetsCompat.Type.navigationBars())

            // Apply padding for status bar and navigation bar
            view.setPadding(
                view.paddingLeft,
                systemBars.top + 16,
                view.paddingRight,
                navigationBars.bottom + 16
            )

            insets
        }
    }

    private fun initViews() {
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        ivTogglePassword = findViewById(R.id.ivTogglePassword)
        btnSignIn = findViewById(R.id.btnSignIn)
        tvSignUp = findViewById(R.id.tvSignUp)
        signUpContainer = findViewById(R.id.signUpContainer)
    }

    private fun setupClickListeners() {
        // Toggle password visibility
        ivTogglePassword.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                etPassword.inputType = android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                ivTogglePassword.setImageResource(R.drawable.ic_eye_off_dark)
            } else {
                etPassword.inputType = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
                ivTogglePassword.setImageResource(R.drawable.ic_eye_dark)
            }
            etPassword.setSelection(etPassword.text.length)
        }

        // Launch Mission button - Navigate to Home screen
        btnSignIn.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty()) {
                etEmail.error = "Please enter your email"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                etPassword.error = "Please enter your password"
                return@setOnClickListener
            }

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        tvSignUp.setOnClickListener {
            Toast.makeText(this, "Create Account clicked", Toast.LENGTH_SHORT).show()
        }

        signUpContainer.setOnClickListener {
            Toast.makeText(this, "Create Account clicked", Toast.LENGTH_SHORT).show()
        }
    }
}
