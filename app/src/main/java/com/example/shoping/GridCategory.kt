package com.example.shoping

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.imageview.ShapeableImageView


class GridCategory : Fragment() {
    private var i = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_grid_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val likeunlike = view.findViewById<ImageButton>(R.id.unlike)
        val p2 = view.findViewById<ImageButton>(R.id.p2)
        val p3 = view.findViewById<ShapeableImageView>(R.id.p3)
        val p4 = view.findViewById<ShapeableImageView>(R.id.p4)
        val p5 = view.findViewById<ShapeableImageView>(R.id.p5)
        val p6 = view.findViewById<ShapeableImageView>(R.id.p6)
        val p7 = view.findViewById<ShapeableImageView>(R.id.p7)
        val p8 = view.findViewById<ShapeableImageView>(R.id.p8)

        val detail = view.findViewById<ShapeableImageView>(R.id.tshirt)
        detail.setOnClickListener(View.OnClickListener {
            val intent = Intent(requireActivity(), Checkout::class.java)
            startActivity(intent)
        })


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

        likeunlike.setOnClickListener(heartClickListener)
        p2.setOnClickListener(heartClickListener)
        p3.setOnClickListener(heartClickListener)
        p4.setOnClickListener(heartClickListener)
        p5.setOnClickListener(heartClickListener)
        p6.setOnClickListener(heartClickListener)
        p7.setOnClickListener(heartClickListener)
        p8.setOnClickListener(heartClickListener)
        val one = view.findViewById<AppCompatButton>(R.id.one)
        val two = view.findViewById<AppCompatButton>(R.id.two)
        val three = view.findViewById<AppCompatButton>(R.id.three)
        val four = view.findViewById<AppCompatButton>(R.id.four)
        val five = view.findViewById<AppCompatButton>(R.id.five)
        val six = view.findViewById<AppCompatButton>(R.id.siix)

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