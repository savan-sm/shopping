package com.example.shoping

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.navigation.NavigationView

class catgridview : AppCompatActivity() {
    private var drawerLayout: DrawerLayout? = null
    private var drawerToggle: ActionBarDrawerToggle? = null
    private var navigationView: NavigationView? = null
    @SuppressLint("MissingInflatedId", "ResourceAsColor", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catgridview)
        val list = findViewById<ShapeableImageView>(R.id.listimg)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        var i = 0
        list.setOnClickListener(View.OnClickListener {
            val fr: Fragment
            if (i == 0) {
                fr = ListCategory()
                val fm = supportFragmentManager
                val fragmentTransaction = fm.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_section, fr)
                fragmentTransaction.commit()
                list.setImageResource(R.mipmap.grid)
                i++
            } else if(i ==1){
                list.setImageResource(R.mipmap.list)
                i--
                fr = GridCategory()
                val fm = supportFragmentManager
                val fragmentTransaction = fm.beginTransaction()
                fragmentTransaction.replace(R.id.fragment_section, fr)
                fragmentTransaction.commit()
            }
        })
        drawerLayout = findViewById<DrawerLayout>(R.id.my_drawer_layout)
        drawerToggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.app_name, R.string.app_name
        )
        drawerToggle!!.setHomeAsUpIndicator(R.drawable.icon_nav)
        drawerLayout?.addDrawerListener(drawerToggle!!)
        navigationView = findViewById(R.id.navigation)

        navigationView?.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Clicked Home!!!", Toast.LENGTH_SHORT).show()
                }
                R.id.attend_track -> {
                    Toast.makeText(this, "Clicked Attendance Track!!!", Toast.LENGTH_SHORT).show()
                }
                R.id.scan_qr -> {
                    Toast.makeText(this, "Clicked QR Scan!!!", Toast.LENGTH_SHORT).show()
                }
                R.id.profile -> {
                    Toast.makeText(this, "Clicked Profile!!!", Toast.LENGTH_SHORT).show()
                }
                R.id.settings -> {
                    Toast.makeText(this, "Clicked Setting!!!", Toast.LENGTH_SHORT).show()
                }
                R.id.use -> {
                    Toast.makeText(this, "Clicked How to Use!!!", Toast.LENGTH_SHORT).show()
                }
                R.id.sugg -> {
                    Toast.makeText(this, "Clicked Suggestions!!!", Toast.LENGTH_SHORT).show()
                }
                R.id.share -> {
                    Toast.makeText(this, "Clicked Share App!!!", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.actionbar, menu)
        return true
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        drawerToggle?.onConfigurationChanged(newConfig)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToggle?.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToggle?.onOptionsItemSelected(item) == true) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun onDrawerClosed() {
        if (drawerLayout?.isDrawerOpen(Gravity.LEFT or Gravity.RIGHT) == true) {
            drawerLayout!!.closeDrawers()
        }
    }

    override fun onBackPressed() {
        if (drawerLayout?.isDrawerOpen(Gravity.LEFT or Gravity.RIGHT) == true) {
            drawerLayout!!.closeDrawers()
            return
        }
        super.onBackPressed()
    }


    fun CategoryViewfull(view: View) {
        val intent = Intent(this, CategoryViewFull::class.java)
        startActivity(intent)
    }

    fun shop(item: MenuItem) {
        val intent = Intent(this, Emptycart::class.java)
        startActivity(intent)
    }
}