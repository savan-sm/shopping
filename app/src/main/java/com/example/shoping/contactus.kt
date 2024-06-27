package com.example.shoping

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class contactus : AppCompatActivity() {

    private lateinit var imageSignOut: ImageView
    private lateinit var image: ImageView
    private lateinit var searchLayout: View
    private lateinit var searchView: SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contactus)

        imageSignOut = findViewById(R.id.imageSignOut)
        searchLayout = findViewById(R.id.search_layout)
        searchView = findViewById(R.id.search_view)
        image=findViewById(R.id.image)

        imageSignOut.setOnClickListener {
            toggleSearchView(true)
            image.visibility=View.GONE
        }


    }

    private fun toggleSearchView(show: Boolean) {
        searchLayout.visibility = if (show) View.VISIBLE else View.GONE
        if (!show) {
            searchView.setQuery("", false)
        }
    }



}