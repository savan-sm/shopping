package com.example.shoping

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Checkoutaddress : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private val PREF_NAME = "AddressPref"
    var price = ""
    var select = 0
    private var selectedAddress: String? = null

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkoutaddress)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""

        val intentt = intent
        val total = findViewById<TextView>(R.id.total)
        price = intentt.getStringExtra("price").toString()
        total.text = price

        val count = intent.getIntExtra("count",0)

        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        loadAddresses()

        val addAddressButton = findViewById<Button>(R.id.add_address_button)
        addAddressButton.setOnClickListener {
            val intent = Intent(this, AddNewAddress::class.java)
            intent.putExtra("price", price)
            startActivity(intent)
        }

        val spin4 = findViewById<Spinner>(R.id.spinner)
        val adapter3: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            this, R.array.address, android.R.layout.simple_spinner_dropdown_item
        )
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin4.adapter = adapter3

        spin4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Get selected item
                val selectedItem = parent.getItemAtPosition(position).toString()
//                when (position) { 1 -> {} }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        val spin5 = findViewById<Spinner>(R.id.spinner1)
        val adapter4: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            this, R.array.payment, android.R.layout.simple_spinner_dropdown_item
        )
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin5.adapter = adapter4

        val spin6 = findViewById<Spinner>(R.id.spinner2)
        val adapter5: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            this, R.array.dropat, android.R.layout.simple_spinner_dropdown_item
        )
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin6.adapter = adapter5

        var selectedItem = ""
        spin5.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Get selected item
                selectedItem = parent.getItemAtPosition(position).toString()

            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        val btn = findViewById<TextView>(R.id.placeorder)
        btn.setOnClickListener(View.OnClickListener {
            if(selectedItem == "Debit/Credit Card") {
                if(select == 1){
                    val intent = Intent(this, AddCard::class.java)
                    Log.d("add",selectedAddress.toString())
                    intent.putExtra("add1", selectedAddress.toString())
                    intent.putExtra("data","1")
                    startActivity(intent)
                }else {
                    Toast.makeText(this,"Please Select Address!!!", Toast.LENGTH_SHORT).show()
                }
            }else if(selectedItem == "Upi"){
                if(select == 1){
                    val intent = Intent(this, UPIactivity::class.java)
                    intent.putExtra("add2", selectedAddress.toString())
                    intent.putExtra("upi","2")
                    startActivity(intent)
                }else {
                    Toast.makeText(this,"Please Select Address!!!", Toast.LENGTH_SHORT).show()
                }
            }else{
                if(select == 1){
                    val c = 1
                    val intent = Intent(this, FinalCheckOut::class.java)
                    intent.putExtra("order1",c.toString())
                    intent.putExtra("add3", selectedAddress.toString())
                    intent.putExtra("count",count)
                    intent.putExtra("price",price)
                    intent.putExtra("cod","3")
                    startActivity(intent)
                }else {
                    Toast.makeText(this,"Please Select Address!!!", Toast.LENGTH_SHORT).show()
                }
            }
        })

    }
    @SuppressLint("SetTextI18n")
    private fun loadAddresses() {
        val addressCount = sharedPreferences.getInt("address_count", 0)
        for (i in 0 until addressCount) {
            val fname = sharedPreferences.getString("fname_$i", "N/A") ?: "N/A"
            val lname = sharedPreferences.getString("lname_$i", "N/A") ?: "N/A"
            val address = sharedPreferences.getString("address_$i", "N/A") ?: "N/A"
            val city = sharedPreferences.getString("city_$i", "N/A") ?: "N/A"
            val state = sharedPreferences.getString("state_$i", "N/A") ?: "N/A"
            val zipcode = sharedPreferences.getString("zipcode_$i", "N/A") ?: "N/A"
            val phonenum = sharedPreferences.getString("phonenum_$i", "N/A") ?: "N/A"

            val name = "$fname $lname"
            val addressDetails = "$address $city\n$state $zipcode\n$phonenum"

            addAddressView(name, addressDetails)
        }
    }
    @SuppressLint("MissingInflatedId")
    private fun addAddressView(name: String, addressDetails: String) {
        val inflater = LayoutInflater.from(this)
        val addressView = inflater.inflate(R.layout.address_item, null)

        val addressName = addressView.findViewById<TextView>(R.id.address_name)
        val addressDetailsView = addressView.findViewById<TextView>(R.id.address_details)

        addressName.text = name
        addressDetailsView.text = addressDetails

        val addressContainer = findViewById<LinearLayout>(R.id.address_container)
        addressContainer.addView(addressView)

        addressView.setOnClickListener {
            for (i in 0 until addressContainer.childCount) {
                val child = addressContainer.getChildAt(i)
                child.isSelected = false
            }
            addressView.isSelected = true
            select = 1
            selectedAddress = "$name\n$addressDetails"
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