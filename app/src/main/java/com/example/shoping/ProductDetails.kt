package com.example.shoping

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.imageview.ShapeableImageView

class ProductDetails : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""

        val ring = findViewById<ShapeableImageView>(R.id.ring1)
        val ring1 = findViewById<ShapeableImageView>(R.id.ring2)
        val ring2 = findViewById<ShapeableImageView>(R.id.ring3)
        val ring3 = findViewById<ShapeableImageView>(R.id.ring4)
        val ring4 = findViewById<ShapeableImageView>(R.id.ring5)

        val line1 = findViewById<ShapeableImageView>(R.id.line1)
        val line2 = findViewById<ShapeableImageView>(R.id.line2)
        val line3 = findViewById<ShapeableImageView>(R.id.line3)
        val line4 = findViewById<ShapeableImageView>(R.id.line4)

        val dot1 = findViewById<ShapeableImageView>(R.id.dot1)
        val dot2 = findViewById<ShapeableImageView>(R.id.dot2)
        val dot3 = findViewById<ShapeableImageView>(R.id.dot3)
        val dot4 = findViewById<ShapeableImageView>(R.id.dot4)

        line2.visibility = View.INVISIBLE
        line3.visibility = View.INVISIBLE
        line4.visibility = View.INVISIBLE
        dot2.visibility = View.INVISIBLE
        dot3.visibility = View.INVISIBLE
        dot4.visibility = View.INVISIBLE
        ring1.setOnClickListener(View.OnClickListener {
            ring.setImageResource(R.mipmap.ring1)
            line1.visibility = View.VISIBLE
            line2.visibility = View.INVISIBLE
            line3.visibility = View.INVISIBLE
            line4.visibility = View.INVISIBLE
            dot1.visibility = View.VISIBLE
            dot2.visibility = View.INVISIBLE
            dot3.visibility = View.INVISIBLE
            dot4.visibility = View.INVISIBLE
        })
        ring2.setOnClickListener(View.OnClickListener {
            ring.setImageResource(R.mipmap.ring2)
            line2.visibility = View.VISIBLE
            line1.visibility = View.INVISIBLE
            line3.visibility = View.INVISIBLE
            line4.visibility = View.INVISIBLE
            dot2.visibility = View.VISIBLE
            dot1.visibility = View.INVISIBLE
            dot3.visibility = View.INVISIBLE
            dot4.visibility = View.INVISIBLE
        })
        ring4.setOnClickListener(View.OnClickListener {
            ring.setImageResource(R.mipmap.ring3)
            line1.visibility = View.INVISIBLE
            line2.visibility = View.INVISIBLE
            line3.visibility = View.INVISIBLE
            line4.visibility = View.VISIBLE
            dot1.visibility = View.INVISIBLE
            dot2.visibility = View.INVISIBLE
            dot3.visibility = View.INVISIBLE
            dot4.visibility = View.VISIBLE
        })
        ring3.setOnClickListener(View.OnClickListener {
            ring.setImageResource(R.mipmap.ring4)
            line3.visibility = View.VISIBLE
            line1.visibility = View.INVISIBLE
            line2.visibility = View.INVISIBLE
            line4.visibility = View.INVISIBLE
            dot3.visibility = View.VISIBLE
            dot2.visibility = View.INVISIBLE
            dot1.visibility = View.INVISIBLE
            dot4.visibility = View.INVISIBLE
        })

        val likeunlike = findViewById<ShapeableImageView>(R.id.unlike)
        val p2 = findViewById<ShapeableImageView>(R.id.p2)
        val p3 = findViewById<ShapeableImageView>(R.id.p3)
        val p4 = findViewById<ShapeableImageView>(R.id.p4)

        var i = 0
        likeunlike.setOnClickListener(View.OnClickListener {
            if (i == 0) {
                likeunlike.setImageResource(R.mipmap.filledheart)
                i++
            } else if (i == 1) {
                likeunlike.setImageResource(R.mipmap.unfillheart)
                i--
            }
        })
        p2.setOnClickListener(View.OnClickListener {
            if (i == 0) {
                p2.setImageResource(R.mipmap.filledheart)
                i++
            } else if (i == 1) {
                p2.setImageResource(R.mipmap.unfillheart)
                i--
            }
        })
        p3.setOnClickListener(View.OnClickListener {
            if (i == 0) {
                p3.setImageResource(R.mipmap.filledheart)
                i++
            } else if (i == 1) {
                p3.setImageResource(R.mipmap.unfillheart)
                i--
            }
        })
        p4.setOnClickListener(View.OnClickListener {
            if (i == 0) {
                p4.setImageResource(R.mipmap.filledheart)
                i++
            } else if (i == 1) {
                p4.setImageResource(R.mipmap.unfillheart)
                i--
            }
        })


    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.actionbar, menu)
        return true }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return true
    }
}