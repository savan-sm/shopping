package com.example.shoping

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UPIactivity : AppCompatActivity() {
    var data2 = ""
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upiactivity)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""

        val editupi = findViewById<EditText>(R.id.editupi)
        val pay = findViewById<TextView>(R.id.pay)

        data2 = intent.getStringExtra("upi").toString()
        val add = intent.getStringExtra("add2")

        Log.d("upi", data2)

        val placeo = findViewById<TextView>(R.id.placeorderpayment)
        placeo.setOnClickListener(View.OnClickListener {
            val c = "1"
            val intent = Intent(this, FinalCheckOut::class.java)
            intent.putExtra("hide",c)
            intent.putExtra("add2",add.toString())
            intent.putExtra("upi",data2)
            startActivity(intent)
        })
        editupi.visibility = View.GONE
        pay.visibility = View.GONE

        val bhim = findViewById<TextView>(R.id.bhim)
        bhim.setOnClickListener(View.OnClickListener {
            editupi.visibility = View.VISIBLE
            pay.visibility = View.VISIBLE
//            Toast.makeText(this, "BHIM UPI", Toast.LENGTH_SHORT).show()
        })
        val gpay = findViewById<TextView>(R.id.gpay)
        gpay.setOnClickListener(View.OnClickListener {
            openGooglePay()
//            Toast.makeText(this, "Google Pay", Toast.LENGTH_SHORT).show()
        })
        val ppay = findViewById<TextView>(R.id.ppay)
        ppay.setOnClickListener(View.OnClickListener {
            openPhonePe()
//            Toast.makeText(this, "Phone Pay", Toast.LENGTH_SHORT).show()
        })
        val ptm = findViewById<TextView>(R.id.ptm)
        ptm.setOnClickListener(View.OnClickListener {
            openPaytm()
//            Toast.makeText(this, "Paytm", Toast.LENGTH_SHORT).show()
        })

        pay.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Payout...", Toast.LENGTH_SHORT).show()
            pay.visibility = View.GONE
            editupi.visibility = View.GONE

        })
    }
    private fun openGooglePay() {
        val intent = packageManager.getLaunchIntentForPackage("com.google.android.apps.nbu.paisa.user")
        if (intent != null) {
            startActivity(intent)
        } else {
            // Google Pay app is not installed, show a message or redirect to Play Store
            val playStoreIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.nbu.paisa.user"))
            startActivity(playStoreIntent)
        }
    }
    private fun openPhonePe() {
        val intent = packageManager.getLaunchIntentForPackage("com.phonepe.app")
        if (intent != null) {
            startActivity(intent)
        } else {
            // PhonePe app is not installed, show a message or redirect to Play Store
            val playStoreIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.phonepe.app"))
            startActivity(playStoreIntent)
        }
    }
    private fun openPaytm() {
        val intent = packageManager.getLaunchIntentForPackage("net.one97.paytm")
        if (intent != null) {
            startActivity(intent)
        } else {
            // Paytm app is not installed, show a message or redirect to Play Store
            val playStoreIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=net.one97.paytm"))
            startActivity(playStoreIntent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.actionbar1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return true
    }
}