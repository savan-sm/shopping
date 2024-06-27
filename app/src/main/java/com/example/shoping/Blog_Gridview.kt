package com.example.shoping

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SlidingDrawer
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.navigation.NavigationView

class Blog_Gridview :AppCompatActivity(), SlidingDrawer.OnDrawerCloseListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var drawerToggle: ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var view: ShapeableImageView
    private lateinit var save: ShapeableImageView
    private lateinit var save1: ShapeableImageView
    private lateinit var save2: ShapeableImageView
    private lateinit var save3: ShapeableImageView
    private var i = 0


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog_gridview)

        view = findViewById(R.id.logo)
        save = findViewById(R.id.shapeableImageView1)
        save1 = findViewById(R.id.shapeableImageView2)
        save2 = findViewById(R.id.shapeableImageView3)
        save3 = findViewById(R.id.shapeableImageView4)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.my_drawer_layout)
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
            R.string.app_name, R.string.app_name)
        drawerToggle.setHomeAsUpIndicator(R.drawable.icon_nav)
        drawerLayout.addDrawerListener(drawerToggle)
        navigationView = findViewById(R.id.navigation)

        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Clicked Home!!!", Toast.LENGTH_SHORT).show()

                }
                R.id.attend_track -> Toast.makeText(this, "Clicked Attendance Track!!!", Toast.LENGTH_SHORT).show()
                R.id.scan_qr -> Toast.makeText(this, "Clicked QR Scan!!!", Toast.LENGTH_SHORT).show()
                R.id.profile -> Toast.makeText(this, "Clicked Profile!!!", Toast.LENGTH_SHORT).show()
                R.id.settings -> Toast.makeText(this, "Clicked Setting!!!", Toast.LENGTH_SHORT).show()
                R.id.use -> Toast.makeText(this, "Clicked How to Use!!!", Toast.LENGTH_SHORT).show()
                R.id.sugg -> Toast.makeText(this, "Clicked Suggestions!!!", Toast.LENGTH_SHORT).show()
                R.id.share -> Toast.makeText(this,"Clicked Share App!!!", Toast.LENGTH_SHORT).show()
            }
            true
        }

        supportActionBar?.title = ""

        save.setOnClickListener {
            if (i == 0) {
                save.setImageResource(R.mipmap.save)
                i++
            } else if (i == 1) {
                save.setImageResource(R.mipmap.unsave)
                i--
            }
        }

        save1.setOnClickListener {
            if (i == 0) {
                save1.setImageResource(R.mipmap.save)
                i++
            } else if (i == 1) {
                save1.setImageResource(R.mipmap.unsave)
                i--
            }
        }

        save2.setOnClickListener {
            if (i == 0) {
                save2.setImageResource(R.mipmap.save)
                i++
            } else if (i == 1) {
                save2.setImageResource(R.mipmap.unsave)
                i--
            }
        }

        save3.setOnClickListener {
            if (i == 0) {
                save3.setImageResource(R.mipmap.save)
                i++
            } else if (i == 1) {
                save3.setImageResource(R.mipmap.unsave)
                i--
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         getMenuInflater().inflate(R.menu.actionbar,menu);
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
        //        int id = item.getItemId();
//        if(id==R.id.bag){
//            Toast.makeText(this, "Shopping!!!", Toast.LENGTH_SHORT).show();
//        }
        return if (drawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onDrawerClosed() {
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

    fun detail(view: View) {
        val i=Intent(this,blogpost::class.java)
        startActivity(i)
    }
}