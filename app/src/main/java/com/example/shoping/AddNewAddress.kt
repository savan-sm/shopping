package com.example.shoping

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddNewAddress : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private val PREF_NAME = "AddressPref"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_address)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""

        val intentt = intent
        val price = intentt.getStringExtra("price")

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        val fname = findViewById<EditText>(R.id.fname)
        val lname = findViewById<EditText>(R.id.lname)
        val add = findViewById<EditText>(R.id.address)
        val city = findViewById<EditText>(R.id.city)
        val state = findViewById<EditText>(R.id.state)
        val zipcode = findViewById<EditText>(R.id.zcode)
        val phonenum = findViewById<EditText>(R.id.phn)

        val addnow = findViewById<TextView>(R.id.addnow)
        addnow.setOnClickListener(View.OnClickListener {
            saveAddress(fname.text.toString(), lname.text.toString(), add.text.toString(),city.text.toString(), state.text.toString(), zipcode.text.toString(), phonenum.text.toString())

            val i = Intent(this, Checkoutaddress::class.java)
            val bundle = Bundle()
            bundle.putString("price", price.toString())
            i.putExtras(bundle)
            startActivity(i)
            finish()
        })

    }

    private fun saveAddress(fname: String, lname: String, address: String, city : String, state: String, zipcode: String, phonenum: String) {
        val editor = sharedPreferences.edit()
        val addressCount = sharedPreferences.getInt("address_count", 0)
        editor.putString("fname_$addressCount", fname)
        editor.putString("lname_$addressCount", lname)
        editor.putString("address_$addressCount", address)
        editor.putString("city_$addressCount", city)
        editor.putString("state_$addressCount", state)
        editor.putString("zipcode_$addressCount", zipcode)
        editor.putString("phonenum_$addressCount", phonenum)
        editor.putInt("address_count", addressCount + 1)
        editor.apply()
    }

    private fun loadData() {
        val fname = findViewById<EditText>(R.id.fname)
        val lname = findViewById<EditText>(R.id.lname)
        val add = findViewById<EditText>(R.id.address)
        val state = findViewById<EditText>(R.id.state)
        val zipcode = findViewById<EditText>(R.id.zcode)
        val phonenum = findViewById<EditText>(R.id.phn)

        fname.setText(sharedPreferences.getString("fname", ""))
        lname.setText(sharedPreferences.getString("lname", ""))
        add.setText(sharedPreferences.getString("address", ""))
        state.setText(sharedPreferences.getString("state", ""))
        zipcode.setText(sharedPreferences.getString("zipcode", ""))
        phonenum.setText(sharedPreferences.getString("phonenum", ""))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.actionbar1, menu)
        return true }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return true
    }
}