package com.example.lab8_with_glide

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

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
        val itemsViewModel = mList[position]

        Glide.with(holder.itemView.context)
            .load(itemsViewModel.image)
            .into(holder.imageView)

        holder.textView.text = itemsViewModel.text

        Glide.with(holder.itemView.context)
            .load(itemsViewModel.image)
            .into(holder.imageView2)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}