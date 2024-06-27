package com.example.shoping

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class CollectionDetails : AppCompatActivity() {

    private lateinit var viewPager: ViewPager


    @SuppressLint("MissingInflatedId", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_collection_details)

        val firstImage1: ImageView = findViewById(R.id.firstImage1)

        val images = listOf(
            R.drawable.img_69,
            R.drawable.img_70
        )

        viewPager = findViewById(R.id.viewPager)
        val adapter = ImagePagerAdapter(this, images) { imageResId ->
            if(imageResId==R.drawable.img_69){
                firstImage1.setImageResource(R.drawable.img_69)
            }

            if(imageResId==R.drawable.img_70) {
            firstImage1.setImageResource(R.drawable.img_70)}

            val scroll: ScrollView = findViewById(R.id.scroll)
            val targetX = 0 // Replace with the desired y-coordinate
            scroll.smoothScrollTo(0, targetX)
        }
        viewPager.adapter = adapter
    }

    fun tishrtclick(view: View) {
        val i=Intent(this,ProductDetails::class.java)
        startActivity(i)
    }
}
