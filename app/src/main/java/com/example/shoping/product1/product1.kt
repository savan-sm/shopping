package com.example.shoping

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class product1: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_product1)

                val red:ImageView =findViewById(R.id.red)
                val black:ImageView =findViewById(R.id.black)
                val pink:ImageView =findViewById(R.id.pink)
                val img:ImageView=findViewById(R.id.firstImage)


        red.setOnClickListener(View.OnClickListener {
                img.setImageResource(R.drawable.img_46)

        })
        black.setOnClickListener(View.OnClickListener {
            img.setImageResource(R.drawable.img_42)

        })
        pink.setOnClickListener(View.OnClickListener {
            img.setImageResource(R.drawable.img_45)

        })

        }

    fun addbasket(view: View) {

        Toast.makeText(applicationContext,"item Add",Toast.LENGTH_SHORT).show()
    }
}
