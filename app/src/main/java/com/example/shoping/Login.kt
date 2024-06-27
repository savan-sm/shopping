package com.example.shoping

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class Login : AppCompatActivity() {
    private lateinit var emailOrMobile: EditText
    private lateinit var password: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailOrMobile = findViewById(R.id.emailOrMobileAddress)
        password = findViewById(R.id.password)

        val loginButton: ImageView = findViewById(R.id.login)
        loginButton.setOnClickListener { login() }

        val signupButton: ImageView = findViewById(R.id.signup)
        signupButton.setOnClickListener { signup1() }
    }

    private fun login() {
        val emailOrMobileInput = emailOrMobile.text.toString()
        val passwordInput = password.text.toString()

        if (emailOrMobileInput.isEmpty() || passwordInput.isEmpty()) {
            Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
            return
        }

        // Validate email or mobile number
        if (isValidEmail(emailOrMobileInput) || isValidMobile(emailOrMobileInput)) {
            // Assuming validation is successful
            // Redirect to OTP activity
            val intent = Intent(this, otp::class.java)
            intent.putExtra("emailOrMobile", emailOrMobileInput)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Invalid email or mobile number", Toast.LENGTH_SHORT).show()
        }
    }

    private fun signup1() {
            val i=Intent(this,signup::class.java)
            startActivity(i)
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidMobile(mobile: String): Boolean {
        return android.util.Patterns.PHONE.matcher(mobile).matches() && mobile.length == 10
    }
}
