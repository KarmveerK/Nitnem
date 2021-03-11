package com.akaalistudios.nitnem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BaniAdapter(val banis: Array<String>, val listener : (String)->Unit) : RecyclerView.Adapter<BaniAdapter.BaniViewHolder>() {
    inner class BaniViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bani_name = itemView.findViewById<TextView>(R.id.bani_item_bani_name)
        init {
            itemView.setOnClickListener {
                listener(banis[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaniViewHolder {
        val itemLayout = LayoutInflater.from(parent.context).inflate(R.layout.bani_item,parent,false)
        return BaniViewHolder(itemLayout)

    }

    override fun onBindViewHolder(holder: BaniViewHolder, position: Int) {
        with(holder){
            bani_name.text = banis[position]
        }
    }

    override fun getItemCount(): Int {
        return banis.size
    }
    override fun getItemId(position: Int): Long {
        return banis[position].hashCode().toLong()
    }


}