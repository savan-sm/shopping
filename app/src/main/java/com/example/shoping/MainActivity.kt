package com.example.shoping

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var drawerToggle: ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView
    private lateinit var viewPager: ViewPager
    private val apparelImages = intArrayOf(R.drawable.img_20, R.drawable.img_4,R.drawable.img_20, R.drawable.img_2)
    private val allImages = intArrayOf(R.drawable.img_2, R.drawable.img_3,R.drawable.img_4, R.drawable.img_5)
    private val dressImages = intArrayOf(R.drawable.img_2, R.drawable.img_21,R.drawable.img_4, R.drawable.img_20)
    private val TshirtImages = intArrayOf(R.drawable.img_2, R.drawable.img_2,R.drawable.img_2, R.drawable.img_2)
    private val bagImages = intArrayOf(R.drawable.img_5, R.drawable.img_5,R.drawable.img_5, R.drawable.img_5)

    private lateinit var imageViews: Array<ImageView>
    private lateinit var textViewAbout: TextView
    private lateinit var textViewContact: TextView
    private lateinit var textViewBlog: TextView
    private lateinit var all: TextView
    private lateinit var apparel: TextView
    private lateinit var dress: TextView
    private lateinit var tshirt: TextView
    private lateinit var bag: TextView
    private lateinit var tool: Toolbar

    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewAbout = findViewById(R.id.text_view_about)
        textViewContact = findViewById(R.id.text_view_contact)
        textViewBlog = findViewById(R.id.text_view_blog)
        all = findViewById(R.id.all)
        apparel = findViewById(R.id.apparel)
        dress = findViewById(R.id.dress)
        tshirt = findViewById(R.id.tshirt)
        bag = findViewById(R.id.bag)
        tool = findViewById(R.id.imageProfile)

        drawerLayout = findViewById(R.id.my_drawer_layout)
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, tool, R.string.app_name, R.string.app_name)
        drawerToggle.setHomeAsUpIndicator(R.drawable.icon_nav)
        drawerLayout.addDrawerListener(drawerToggle)
        navigationView = findViewById(R.id.navigation)

        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    showPopupMenu(findViewById(R.id.nav_home))
                    true
                }
                R.id.attend_track -> {
                    Toast.makeText(this, "Clicked Attendance Track!!!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.scan_qr -> {
                    Toast.makeText(this, "Clicked QR Scan!!!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.profile -> {
                    Toast.makeText(this, "Clicked Profile!!!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.settings -> {
                    Toast.makeText(this, "Clicked Setting!!!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.use -> {
                    Toast.makeText(this, "Clicked How to Use!!!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.sugg -> {
                    Toast.makeText(this, "Clicked Suggestions!!!", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.share -> {
                    Toast.makeText(this, "Clicked Share App!!!", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        val img1: ImageView = findViewById(R.id.image1)
        img1.setOnClickListener {
            val intent = Intent(this, product1::class.java)
            startActivity(intent)
        }

        val images = listOf(
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5
        )

        imageViews = arrayOf(
            findViewById(R.id.image1),
            findViewById(R.id.image2),
            findViewById(R.id.image3),
            findViewById(R.id.image4)
        )

        val collection: ImageView = findViewById(R.id.collection)
        collection.setOnClickListener {
            val intent = Intent(applicationContext, categoryView::class.java)
            startActivity(intent)
        }

        viewPager = findViewById(R.id.viewPager)
        val adapter = ImagePagerAdapter(this, images) {}
        viewPager.adapter = adapter

        val cart: ImageView = findViewById(R.id.cart)
        cart.setOnClickListener {
            val intent = Intent(this, addtocart::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // getMenuInflater().inflate(R.menu.actionbar,menu);
        return true
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (drawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    fun onDrawerClosed() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT or Gravity.RIGHT)) {
            drawerLayout.closeDrawers()
        }
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT or Gravity.RIGHT)) {
            drawerLayout.closeDrawers()
            return
        }
        super.onBackPressed()
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.subcategory1_1 -> {
                    Toast.makeText(this, "Subcategory 1.1 clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.subcategory1_2 -> {
                    Toast.makeText(this, "Subcategory 1.2 clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.subcategory2_1 -> {
                    Toast.makeText(this, "Subcategory 2.1 clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.subcategory2_2 -> {
                    Toast.makeText(this, "Subcategory 2.2 clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, catgridview::class.java)
                    startActivity(intent)
                    true
                }
                R.id.subcategory2_3 -> {
                    Toast.makeText(this, "Subcategory 3.1 clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.category3 -> {
                    Toast.makeText(this, "About clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, about::class.java)
                    startActivity(intent)
                    true
                }
                R.id.category4 -> {
                    Toast.makeText(this, "contact clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, contactus::class.java)
                    startActivity(intent)
                    true
                }
                R.id.category5 -> {
                    Toast.makeText(this, "blog clicked", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, Blog_Gridview::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }

    private fun showImages(imageArray: IntArray) {
        for ((index, imageView) in imageViews.withIndex()) {
            if (index < imageArray.size) {
                imageView.visibility = View.VISIBLE
                imageView.setImageResource(imageArray[index])
            } else {
                imageView.visibility = View.GONE
            }
        }
    }

    fun all(view: View) {
        showImages(allImages)
        resetTextViewColors()
        val textView = view as TextView
        textView.setTextColor(Color.WHITE)
        textView.setBackgroundColor(Color.BLACK)
    }

    fun apparel(view: View) {
        showImages(apparelImages)
        resetTextViewColors()
        val textView = view as TextView
        textView.setTextColor(Color.WHITE)
        textView.setBackgroundColor(Color.BLACK)
    }

    fun dress(view: View) {
        showImages(dressImages)
        resetTextViewColors()
        val textView = view as TextView
        textView.setTextColor(Color.WHITE)
        textView.setBackgroundColor(Color.BLACK)
    }

    fun tishrt(view: View) {
        showImages(TshirtImages)
        resetTextViewColors()
        val textView = view as TextView
        textView.setTextColor(Color.WHITE)
        textView.setBackgroundColor(Color.BLACK)
    }

    fun bag(view: View) {
        showImages(bagImages)
        resetTextViewColors()
        val textView = view as TextView
        textView.setTextColor(Color.WHITE)
        textView.setBackgroundColor(Color.BLACK)
    }

    fun about(view: View) {
        resetTextViewColors()
        val textView = view as TextView
        textView.setTextColor(Color.WHITE)
        textView.setBackgroundColor(Color.BLACK)
        val intent = Intent(this, about::class.java)
        startActivity(intent)
    }

    fun contact(view: View) {
        resetTextViewColors()
        val textView = view as TextView
        textView.setTextColor(Color.WHITE)
        textView.setBackgroundColor(Color.BLACK)
        val intent = Intent(this, contactus::class.java)
        startActivity(intent)
    }

    fun blog(view: View) {
        resetTextViewColors()
        val textView = view as TextView
        textView.setTextColor(Color.WHITE)
        textView.setBackgroundColor(Color.BLACK)
        val intent = Intent(this, Blog_Gridview::class.java)
        startActivity(intent)
    }

    private fun resetTextViewColors() {
        textViewAbout.setTextColor(Color.BLACK)
        textViewAbout.setBackgroundColor(Color.TRANSPARENT)
        textViewContact.setTextColor(Color.BLACK)
        textViewContact.setBackgroundColor(Color.TRANSPARENT)
        textViewBlog.setTextColor(Color.BLACK)
        textViewBlog.setBackgroundColor(Color.TRANSPARENT)
        all.setTextColor(Color.BLACK)
        all.setBackgroundColor(Color.TRANSPARENT)
        apparel.setTextColor(Color.BLACK)
        apparel.setBackgroundColor(Color.TRANSPARENT)
        dress.setTextColor(Color.BLACK)
        dress.setBackgroundColor(Color.TRANSPARENT)
        tshirt.setTextColor(Color.BLACK)
        tshirt.setBackgroundColor(Color.TRANSPARENT)
        bag.setTextColor(Color.BLACK)
        bag.setBackgroundColor(Color.TRANSPARENT)
    }

    fun scrollnew(view: View) {
        val scroll: ScrollView = findViewById(R.id.scroll)
        val targetY = 1800 // Replace with the desired y-coordinate
        scroll.smoothScrollTo(0, targetY)
    }
}