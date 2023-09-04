package com.example.submissionakhiraplikasipemula

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListHPAdapter(private val listHP: ArrayList<HP>) : RecyclerView.Adapter<ListHPAdapter.ViewHolder>() {


    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto : ImageView= itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hp,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listHP.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val(name,description,photo) = listHP [position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listHP[holder.adapterPosition])
            Toast.makeText(holder.itemView.context,"kamu memilih " + listHP[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
    }
    interface OnItemClickCallback{
        fun onItemClicked(data:HP)
    }
}