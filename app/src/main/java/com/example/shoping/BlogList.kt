package com.example.shoping

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class BlogList : AppCompatActivity() {
    private lateinit var imageAdapter: ImageAdapter
    private lateinit var imageList: List<ImageItem>
    private lateinit var searchView: SearchView
    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog_list)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        val logo = findViewById<ShapeableImageView>(R.id.logo)
        logo.visibility = View.VISIBLE

        imageList = getImageList()
        imageAdapter = ImageAdapter(imageList)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = imageAdapter
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.actionbar, menu)
//        val searchItem = menu.findItem(R.id.search)
//        searchView = searchItem?.actionView as SearchView
//
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                imageAdapter.filter.filter(query)
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                imageAdapter.filter.filter(newText)
//                return false
//            }
//        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.search -> {
                search(item)
                return true
            }
            R.id.bag -> {
                search(item)
                return true
            }
        }
        return true
    }
    private fun getImageList(): List<ImageItem> {
        return listOf(
            ImageItem("2021 Style Guide:\nThe Biggest Fall Trends", R.mipmap.dress1, "The excitement of fall fashion\nis here and I am already loving\nsome of the trend forecasts.", "4 days ago"),
            ImageItem("3 Pairs of Denim\nYou Won’t Believe", R.mipmap.dress2, "The excitement of fall fashion\nis here and I am already loving\nsome of the trend forecasts.", "5 days ago"),
            ImageItem("5 Fall LooksI’m\n Loving", R.mipmap.dress3, "The excitement of fall fashion\nis here and I am already loving\nsome of the trend forecasts.", "01/11/2021"),
            ImageItem("5 Fall Boot Trends\nYou Need to Try", R.mipmap.dress4, "The excitement of fall fashion\nis here and I am already loving\nsome of the trend forecasts.", "25/10/2021"),
            ImageItem("2021 Style Guide:\nThe Biggest Fall Trends", R.mipmap.dress5, "The excitement of fall fashion\nis here and I am already loving\nsome of the trend forecasts.", "16/10/2021"),
            ImageItem("3 Pairs of Denim\nYou Won’t Believe", R.mipmap.dress6, "The excitement of fall fashion\nis here and I am already loving\nsome of the trend forecasts.", "10/10/2021"),
        )
    }

    fun search(item: MenuItem) {
        Toast.makeText(this,"kjdsnfviu", Toast.LENGTH_SHORT).show()
        val logo = findViewById<ShapeableImageView>(R.id.logo)
        logo.visibility = View.GONE
    }
}