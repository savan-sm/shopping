package com.example.shoping

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class addtocart : AppCompatActivity() {

    private lateinit var first: TextView
    private lateinit var money: TextView
    private lateinit var minus: ImageView
    private lateinit var plus: ImageView
    private lateinit var data1: TextView
    private lateinit var data2: TextView
    private lateinit var minus1: ImageView
    private lateinit var plus1: ImageView
    private lateinit var total: TextView
    private var quantity = 1
    private var quantity1 = 1

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_addtocart)

        val close: ImageView = findViewById(R.id.imageProfile)
        close.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        first = findViewById(R.id.textView)
        money = findViewById(R.id.textView2)
        minus = findViewById(R.id.minus)
        plus = findViewById(R.id.pluse)
        data1 = findViewById(R.id.data1)
        data2 = findViewById(R.id.data2)
        minus1 = findViewById(R.id.minus1)
        plus1 = findViewById(R.id.plus1)
        total = findViewById(R.id.total)

        updateQuantity(quantity)
        updateQuantity1(quantity1)

        minus.setOnClickListener(View.OnClickListener {
            decrementQuantity()
        })

        plus.setOnClickListener(View.OnClickListener {
            incrementQuantity()
        })

        minus1.setOnClickListener(View.OnClickListener {
            decrementQuantity1()
        })

        plus1.setOnClickListener(View.OnClickListener {
            incrementQuantity1()
        })
    }

    private fun incrementQuantity() {
        quantity++
        updateQuantity(quantity)
    }

    private fun decrementQuantity() {
        if (quantity > 1) {
            quantity--
            updateQuantity(quantity)
        }
    }

    private fun incrementQuantity1() {
        quantity1++
        updateQuantity1(quantity1)
    }

    private fun decrementQuantity1() {
        if (quantity1 > 1) {
            quantity1--
            updateQuantity1(quantity1)
        }
    }

    private fun updateQuantity(quantity: Int) {
        first.text = quantity.toString()
        val price = quantity * 125
        money.text = "$$price"
        updateTotal()
    }

    @SuppressLint("SetTextI18n")
    private fun updateQuantity1(quantity1: Int) {
        data1.text = quantity1.toString()
        val price = quantity1 * 125
        data2.text = "$$price"
        updateTotal()
    }

    private fun updateTotal() {
        val price1 = quantity * 125
        val price2 = quantity1 * 125
        val totalPrice = price1 + price2
        total.text = "$$totalPrice"
    }
}
