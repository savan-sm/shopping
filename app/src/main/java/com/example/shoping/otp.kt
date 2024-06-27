package com.example.shoping

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class otp : AppCompatActivity() {
    private lateinit var textViewCountdown: TextView
    private lateinit var countDownTimer: CountDownTimer
    private var timeLeftInMillis: Long = 15000 // 15 seconds in milliseconds
    private lateinit var otpnum: EditText
    private val handler = Handler()
    private val otpCheckInterval: Long = 5000 // 1 second

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        textViewCountdown = findViewById(R.id.textViewCountdown)
        otpnum = findViewById(R.id.otpnumber)
        val emailOrMobile = intent.getStringExtra("emailOrMobile")
        Toast.makeText(this, "OTP sent to: $emailOrMobile", Toast.LENGTH_SHORT).show()


        // Start the timer automatically when the activity is created
        startTimer()
        startOtpCheck()
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateCountdownText()
            }

            override fun onFinish() {
                textViewCountdown.text = "00:00"
                // Check OTP one last time when the timer finishes
                checkOtpOnFinish()
            }
        }.start()
    }

    private fun updateCountdownText() {
        val minutes = (timeLeftInMillis / 1000) / 60
        val seconds = (timeLeftInMillis / 1000) % 60
        val timeFormatted = String.format("%02d:%02d", minutes, seconds)
        textViewCountdown.text = timeFormatted
    }

    private fun startOtpCheck() {
        handler.postDelayed(object : Runnable {
            override fun run() {
                checkOtp()
                handler.postDelayed(this, otpCheckInterval)
            }
        }, otpCheckInterval)
    }

    private fun checkOtp() {
        if (otpnum.text.toString() == "123") {
            handler.removeCallbacksAndMessages(null)
            countDownTimer.cancel()  // Stop the timer
            val intent = Intent(this@otp, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }

    private fun checkOtpOnFinish() {
        if (otpnum.text.toString() != "123") {
            val intent = Intent(this@otp, Login::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}
