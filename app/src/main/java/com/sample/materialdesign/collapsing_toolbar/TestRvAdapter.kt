package com.sample.materialdesign.collapsing_toolbar

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sample.materialdesign.R

class TestRvAdapter : RecyclerView.Adapter<TestRvAdapter.ViewHolder>() {

    private val items = mutableListOf<String>()

    fun replaceAll(items: List<String>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.item_test, parent, false)
        )

    override fun getItemCount(): Int =
        items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position])

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val tvNumber: TextView = itemView.findViewById(R.id.tv_number)
        private val tvContents: TextView = itemView.findViewById(R.id.tv_contents)

        fun bind(item: String){
            tvNumber.text = item
            tvContents.text = "Contents $item"
        }
    }
}