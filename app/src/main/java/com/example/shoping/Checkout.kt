package com.example.shoping

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.imageview.ShapeableImageView

class Checkout : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""

        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

        val plus = findViewById<ShapeableImageView>(R.id.plus1)
        val minus = findViewById<ShapeableImageView>(R.id.minus1)
        val textcount = findViewById<TextView>(R.id.count1)
        val total = findViewById<TextView>(R.id.total1)
        val price = findViewById<TextView>(R.id.price111)

        val promo = findViewById<TextView>(R.id.codetxt)
        val promocode = findViewById<EditText>(R.id.promocode)
        val apply = findViewById<TextView>(R.id.apply)
        promocode.visibility = View.GONE
        promo.visibility = View.VISIBLE
        promo.setOnClickListener(View.OnClickListener {
            promocode.visibility = View.VISIBLE
        })
        promocode.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
        apply.setOnClickListener(View.OnClickListener {
            imm.hideSoftInputFromWindow(window.decorView.windowToken, 0)
            if (promocode.text.toString().isEmpty()) {
                Toast.makeText(this, "Write Code!!", Toast.LENGTH_SHORT).show()
            } else {
                promo.text = promocode.text
                promocode.visibility = View.GONE
                promo.isAllCaps = true
            }
        })
        var c = 1;
        plus.setOnClickListener(View.OnClickListener {
            c++;
            textcount.text = c.toString()
            price.text = "$"+(c * 120).toString()
            total.text = price.text
        })
        minus.setOnClickListener(View.OnClickListener {
            if(c > 1)
            {
                c--;
                textcount.text = c.toString()
                price.setText("$"+(c * 120).toString())
                total.setText(price.text)
            }
        })

        val check = findViewById<TextView>(R.id.check)
        check.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Checkoutaddress::class.java)
            intent.putExtra("count",c)
            intent.putExtra("price",total.text)
            startActivity(intent)
        })
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.actionbar1, menu)
        return true }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return true
    }
}
