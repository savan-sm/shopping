package com.example.shoping

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(private var imageList: List<ImageItem>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>(), Filterable {

    private var filteredImageList: List<ImageItem> = imageList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageItem = filteredImageList[position]
        holder.titleTextView.text = imageItem.title
        holder.imageView.setImageResource(imageItem.imageResId)
        holder.dateTextView.text = imageItem.date
        holder.descriptionTextView.text = imageItem.description
    }

    override fun getItemCount(): Int {
        return filteredImageList.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val query = constraint?.toString()?.lowercase() ?: ""
                val results = FilterResults()
                results.values = if (query.isEmpty()) {
                    imageList
                } else {
                    imageList.filter {it.title.lowercase().contains(query) ||
                            it.date.lowercase().contains(query) ||
                            it.description.lowercase().contains(query)
                    }
                }
                return results
            }
            @SuppressLint("NotifyDataSetChanged")
            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredImageList = results?.values as List<ImageItem>
                notifyDataSetChanged()
            }
        }
    }
    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
    }
}