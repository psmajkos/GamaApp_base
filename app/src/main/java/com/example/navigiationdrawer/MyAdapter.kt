package com.example.navigiationdrawer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val data: List<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    // ViewHolder class to hold references to the views within each item
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTextView: TextView = itemView.findViewById(R.id.myRecyclerView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_layout, parent, false) // Replace 'item_layout' with your item layout XML
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.itemTextView.text = item
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
