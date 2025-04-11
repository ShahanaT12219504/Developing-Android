package com.example.entrenet

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val ivTogglePassword: ImageView = findViewById(R.id.ivTogglePassword)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val tvForgotPassword: TextView = findViewById(R.id.tvForgotPassword)
        val tvRegister: TextView = findViewById(R.id.tvRegister)

        val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        var isPasswordVisible = false

        // Toggle Password Visibility
        ivTogglePassword.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                ivTogglePassword.setImageResource(R.drawable.visibility_on) // Eye open icon
            } else {
                etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                ivTogglePassword.setImageResource(R.drawable.visibility_off) // Eye closed icon
            }
            etPassword.setSelection(etPassword.text.length) // Maintain cursor position
        }

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Enter email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val registeredEmail = sharedPreferences.getString("email", null)
            val registeredPassword = sharedPreferences.getString("password", null)

            if (registeredEmail == null || registeredPassword == null) {
                Toast.makeText(this, "No account found. Please register first.", Toast.LENGTH_SHORT).show()
            } else if (email == registeredEmail && password == registeredPassword) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SplashActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid Credentials!", Toast.LENGTH_SHORT).show()
            }
        }

        tvForgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}