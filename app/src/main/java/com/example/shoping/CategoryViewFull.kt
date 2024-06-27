package com.example.shoping

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.imageview.ShapeableImageView

class CategoryViewFull : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_view_full)

        val l1 = findViewById<ShapeableImageView>(R.id.unlike1)
        var i = 0
        l1.setOnClickListener(View.OnClickListener {
            if (i == 0) {
                l1.setImageResource(R.mipmap.filledheart)
                i++
            } else {
                l1.setImageResource(R.mipmap.unfillheart)
                i--
            }
        })
        val l2 = findViewById<ShapeableImageView>(R.id.unlike2)
        l2.setOnClickListener(View.OnClickListener {
            if (i == 0) {
                l2.setImageResource(R.mipmap.filledheart)
                i++
            } else {
                l2.setImageResource(R.mipmap.unfillheart)
                i--
            }
        })
        val l3 = findViewById<ShapeableImageView>(R.id.unlike3)
        l3.setOnClickListener(View.OnClickListener {
            if (i == 0) {
                l3.setImageResource(R.mipmap.filledheart)
                i++
            } else {
                l3.setImageResource(R.mipmap.unfillheart)
                i--
            }
        })

        val one = findViewById<AppCompatButton>(R.id.one)
        val two = findViewById<AppCompatButton>(R.id.two)
        val three = findViewById<AppCompatButton>(R.id.three)
        val four = findViewById<AppCompatButton>(R.id.four)
        val five = findViewById<AppCompatButton>(R.id.five)
        val six = findViewById<AppCompatButton>(R.id.siix)

        one.setOnClickListener {
            setButtonColors(one, two, three, four, five, six)
        }
        two.setOnClickListener {
            setButtonColors(two, one, three, four, five, six)
        }
        three.setOnClickListener {
            setButtonColors(three, one, two, four, five, six)
        }
        four.setOnClickListener {
            setButtonColors(four, one, two, three, five, six)
        }
        five.setOnClickListener {
            setButtonColors(five, one, two, three, four, six)
        }
        six.setOnClickListener {
            setButtonColors(six, one, two, three, four, five)
        }
    }
    private fun setButtonColors(activeButton: AppCompatButton, vararg otherButtons: AppCompatButton) {
        activeButton.setBackgroundColor(Color.BLACK)
        activeButton.setTextColor(Color.WHITE)

        for (button in otherButtons) {
            button.setBackgroundColor(Color.parseColor("#FADDD8D8"))
            button.setTextColor(Color.BLACK)
        }
    }
}