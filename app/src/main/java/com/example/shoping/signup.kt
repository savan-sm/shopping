package com.example.shoping

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class signup : AppCompatActivity() {

    private lateinit var fname: EditText
    private lateinit var lname: EditText
    private lateinit var email: EditText
    private lateinit var pass: EditText
    private lateinit var confopass: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        fname = findViewById(R.id.fname)
        lname = findViewById(R.id.lname)
        email = findViewById(R.id.email)
        pass = findViewById(R.id.pass)
        confopass = findViewById(R.id.confopass)
    }

    fun signup(view: View) {
        if (fname.text.toString().isEmpty() || lname.text.toString().isEmpty() || email.text.toString().isEmpty() || pass.text.toString().isEmpty() || confopass.text.toString().isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
        } else if (pass.text.toString() != confopass.text.toString()) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
        } else {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            Toast.makeText(this, "User registered", Toast.LENGTH_SHORT).show()
        }
    }
}
