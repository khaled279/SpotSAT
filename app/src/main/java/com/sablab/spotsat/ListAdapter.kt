package com.sablab.spotsat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListAdapter (private val list : ArrayList<Satalite> ) : RecyclerView.Adapter<sataliteViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): sataliteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return sataliteViewHolder(inflater, parent)    }

    override fun onBindViewHolder(holder: sataliteViewHolder, position: Int) {
        val satalie:Satalite = list[position]
        holder.bind(satalie)
    }

    override fun getItemCount(): Int = list.size

}