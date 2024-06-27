package com.example.shoping

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class categoryView : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_category_view)
        val collection: ImageView =findViewById(R.id.firstImage1)
        collection.setOnClickListener(View.OnClickListener {

            val Intent= Intent(applicationContext,CollectionDetails::class.java)
            startActivity(Intent)
        })
        }
    }
