package com.example.shoping

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter

class ImagePagerAdapter(
    private val context: Context,
    private val images: List<Int>,
    private val onClick: (Int) -> Unit
) : PagerAdapter() {

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.pager_item, container, false)

        val imageView = view.findViewById<ImageView>(R.id.imageView)
        imageView.setImageResource(images[position])

        imageView.setOnClickListener {
            onClick(images[position])
        }

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
