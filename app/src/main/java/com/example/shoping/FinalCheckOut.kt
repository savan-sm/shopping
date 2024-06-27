package com.example.shoping

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.imageview.ShapeableImageView

class FinalCheckOut : AppCompatActivity() {
    private lateinit var paymentSuccessDialog: Dialog
    private lateinit var sharedPreferences: SharedPreferences
    private val PREF_NAME = "CardPref"
    private lateinit var linearLayoutCards: LinearLayout
    private lateinit var cardItemList: List<CardItem>
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_check_out)

        val selectedAddres1 = intent.getStringExtra("add1")
        val selectedAddres2 = intent.getStringExtra("add2")
        val selectedAddres3 = intent.getStringExtra("add3")
        val data1 = intent.getStringExtra("data1")
        val data2 = intent.getStringExtra("upi")
        val data3 = intent.getStringExtra("cod")
        Log.d("addd",selectedAddres1.toString())

        val addressTextView = findViewById<TextView>(R.id.selected_address)
        if(data1.toString() == "1") {
            addressTextView.text = selectedAddres1
        }else if(data2.toString() == "2"){
            addressTextView.text = selectedAddres2
        }else if(data3.toString() == "3") {
            addressTextView.text = selectedAddres3
        }

        val plus = findViewById<ShapeableImageView>(R.id.plus)
        val minus = findViewById<ShapeableImageView>(R.id.minus)
        val textcount = findViewById<TextView>(R.id.count)
        val total = findViewById<TextView>(R.id.total)
        val price = findViewById<TextView>(R.id.price)

        linearLayoutCards = findViewById(R.id.linearLayoutCards)
        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        val hide = intent.getStringExtra("hide")
        if (hide.equals("1")) {
            linearLayoutCards.visibility = View.GONE
            Log.d("hidee","hidetru")
        } else {
            Log.d("hide","$hide")
            linearLayoutCards.visibility = View.VISIBLE
        }

        val order1 = intent.getStringExtra("order1")
        Log.d("order1","$order1")
        if (order1.equals("1")) {
            linearLayoutCards.visibility = View.GONE
        } else {
            linearLayoutCards.visibility = View.VISIBLE
        }

        cardItemList = loadData()
        populateCardItems()

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
                price.text = "$"+(c * 120).toString()
                total.text = price.text
            }
        })
    }
    private fun loadData(): List<CardItem> {
        val items: MutableList<CardItem> = ArrayList()
        val addressCount = sharedPreferences.getInt("address_count", 0)

        for (i in 0 until addressCount) {
            val name = sharedPreferences.getString("name_$i", "N/A")
            val cardnum = sharedPreferences.getString("cardnum_$i", "N/A")

            items.add(CardItem(name!!, cardnum!!))
        }

        return items
    }

    private fun populateCardItems() {
        val inflater = LayoutInflater.from(this)

        for (item in cardItemList) {
            val cardView = inflater.inflate(R.layout.card_item, linearLayoutCards, false)
            val cardName = cardView.findViewById<TextView>(R.id.cardName)
            val cardNumber = cardView.findViewById<TextView>(R.id.cardNumber)

            cardName.text = item.name
            cardNumber.text = item.getMaskedCardNumber()

            linearLayoutCards.addView(cardView)
        }
    }

    private fun showPaymentSuccessDialog() {
        paymentSuccessDialog = Dialog(this)
        paymentSuccessDialog.setContentView(R.layout.dialog_payment_success)

        val ratingBar: RatingBar = paymentSuccessDialog.findViewById(R.id.ratingBar)
        val buttonClose: ImageView = paymentSuccessDialog.findViewById(R.id.close1)
        buttonClose.setOnClickListener {
            paymentSuccessDialog.dismiss()
        }
        val buttonClose1: ImageView = paymentSuccessDialog.findViewById(R.id.close)
        buttonClose1.setOnClickListener {
            paymentSuccessDialog.dismiss()
        }
        val home: ImageView = paymentSuccessDialog.findViewById(R.id.home)
        home.setOnClickListener {
            val Intent= Intent(this,MainActivity::class.java)
            startActivity(Intent)
        }


        paymentSuccessDialog.show()
    }

    fun payment(view: View) {
        showPaymentSuccessDialog()
    }


}