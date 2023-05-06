package com.example.lab8

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (
    private val mList: List<ItemsViewModel>,
    private val onItemClick:(position:Int)->Unit
):RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    class ViewHolder(private val ItemView: View, private val onItemClick: (position: Int) -> Unit
    ):RecyclerView.ViewHolder(ItemView){

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val imageView2: ImageView = itemView.findViewById(R.id.imageview2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]

        holder.imageView.setImageResource(ItemsViewModel.image)

        holder.textView.text = ItemsViewModel.text

        holder.imageView2.setImageResource(ItemsViewModel.image)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}