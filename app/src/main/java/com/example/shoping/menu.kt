package com.example.shoping

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class menu : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val close:ImageView =findViewById(R.id.close)
        close.setOnClickListener(View.OnClickListener {
            onBackPressed()

        })
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)

        val adapter = TabAdapter(supportFragmentManager)
        adapter.addFragment(WomenFragment(), "Women")
        adapter.addFragment(MenFragment(), "Men")
        adapter.addFragment(ChildFragment(), "Child")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        }
    }
