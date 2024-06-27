package com.example.shoping

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.imageview.ShapeableImageView

class ListCategory : Fragment() {
    private var i = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val l1 = view.findViewById<ShapeableImageView>(R.id.l1)
        val l2 = view.findViewById<ShapeableImageView>(R.id.l2)
        val l3 = view.findViewById<ShapeableImageView>(R.id.l3)
        val l4 = view.findViewById<ShapeableImageView>(R.id.l4)
        val l5 = view.findViewById<ShapeableImageView>(R.id.l5)
        val l6 = view.findViewById<ShapeableImageView>(R.id.l6)
        val l7 = view.findViewById<ShapeableImageView>(R.id.l7)
        val l8 = view.findViewById<ShapeableImageView>(R.id.l8)

        val heartClickListener = View.OnClickListener { imageView ->
            val imgView = imageView as ShapeableImageView
            if (i == 0) {
                imgView.setImageResource(R.mipmap.filledheart)
                i++
            } else {
                imgView.setImageResource(R.mipmap.unfillheart)
                i--
            }
        }

        l1.setOnClickListener(heartClickListener)
        l2.setOnClickListener(heartClickListener)
        l3.setOnClickListener(heartClickListener)
        l4.setOnClickListener(heartClickListener)
        l5.setOnClickListener(heartClickListener)
        l6.setOnClickListener(heartClickListener)
        l7.setOnClickListener(heartClickListener)
        l8.setOnClickListener(heartClickListener)
        val one1 = view.findViewById<AppCompatButton>(R.id.one1)
        val two1 = view.findViewById<AppCompatButton>(R.id.two1)
        val three1 = view.findViewById<AppCompatButton>(R.id.three1)
        val four1 = view.findViewById<AppCompatButton>(R.id.four1)
        val five1 = view.findViewById<AppCompatButton>(R.id.five1)
        val six1 = view.findViewById<AppCompatButton>(R.id.siix1)

        one1.setOnClickListener {
            setButtonColors(one1, two1, three1, four1, five1, six1)
        }
        two1.setOnClickListener {
            setButtonColors(two1, one1, three1, four1, five1, six1)
        }
        three1.setOnClickListener {
            setButtonColors(three1, one1, two1, four1, five1, six1)
        }
        four1.setOnClickListener {
            setButtonColors(four1, one1, two1, three1, five1, six1)
        }
        five1.setOnClickListener {
            setButtonColors(five1, one1, two1, three1, four1, six1)
        }
        six1.setOnClickListener {
            setButtonColors(six1, one1, two1, three1, four1, five1)
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