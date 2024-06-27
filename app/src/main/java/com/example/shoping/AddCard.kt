package com.example.shoping

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddCard : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private val PREF_NAME = "CardPref"
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        val name = findViewById<TextView>(R.id.nofc)
        val cardnum = findViewById<TextView>(R.id.cardnum)
        val expmonth = findViewById<TextView>(R.id.expmonth)
        val expyear = findViewById<TextView>(R.id.expyear)
        val cvv = findViewById<TextView>(R.id.cvv)

        val selected = intent.getStringExtra("add1")
        val data = intent.getStringExtra("data")
        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        loadAddresses()
        val btn = findViewById<TextView>(R.id.addnow)
        btn.setOnClickListener(View.OnClickListener {
            if(name.text.isEmpty() && cardnum.text.isEmpty() && expmonth.text.isEmpty() && expyear.text.isEmpty() && cvv.text.isEmpty())
            {
                Toast.makeText(this, "Card Not Add!!!", Toast.LENGTH_SHORT).show()
            }else{
                saveAddress(name.text.toString(), cardnum.text.toString(), expmonth.text.toString(), expyear.text.toString(), cvv.text.toString())
            }
            val intent = Intent(this,FinalCheckOut::class.java)
            intent.putExtra("add1",selected.toString())
            intent.putExtra("data1",data.toString())
            startActivity(intent)
        })
    }
    private fun saveAddress(name: String, cardnum: String, expmonth: String, expyear: String, cvv: String) {
        val editor = sharedPreferences.edit()
        val addressCount = sharedPreferences.getInt("address_count", 0)
        editor.putString("name_$addressCount", name)
        editor.putString("cardnum_$addressCount", cardnum)
        editor.putString("expmonth_$addressCount", expmonth)
        editor.putString("expyear_$addressCount", expyear)
        editor.putString("cvv_$addressCount", cvv)
        editor.putInt("address_count", addressCount + 1)
        editor.apply()
    }
    @SuppressLint("SetTextI18n")
    private fun loadAddresses() {
        val addressCount = sharedPreferences.getInt("address_count", 0)
        for (i in 0 until addressCount) {
            val fname = sharedPreferences.getString("name_$i", "N/A") ?: "N/A"
            val cardnumm = sharedPreferences.getString("cardnum_$i", "N/A") ?: "N/A"
            val address = sharedPreferences.getString("expmonth_$i", "N/A") ?: "N/A"
            val state = sharedPreferences.getString("expyear_$i", "N/A") ?: "N/A"

            val name = findViewById<TextView>(R.id.cardnm)
            val cardnm = findViewById<TextView>(R.id.cardnumber)
            val date = findViewById<TextView>(R.id.exp)

            name.text = fname
            cardnm.text = cardnumm
            date.text = "$address/$state"
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.actionbar1, menu)
        return true }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return true
    }
}