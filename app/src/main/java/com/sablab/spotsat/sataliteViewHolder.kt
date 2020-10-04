package com.sablab.spotsat

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class sataliteViewHolder (inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.card_view, parent, false))  {
        var textSatName:TextView? = null
        var testSatLong:TextView? = null
        var textSatLat:TextView? = null
        var textSatAlt:TextView? = null
        var layout : ConstraintLayout? = null
        init {
            textSatName = itemView.findViewById(R.id.sat_name)
            textSatLat = itemView.findViewById(R.id.lat_text)
            textSatAlt = itemView.findViewById(R.id.alt_text)
            testSatLong = itemView.findViewById(R.id.long_text)
            layout = itemView.findViewById(R.id.card_layout)
        }
        fun bind(satalite: Satalite) {
            if (satalite.name != "") {
                textSatName?.text = satalite.name
                textSatAlt?.text = satalite.alt.toString()
                textSatLat?.text = satalite.lat.toString()
                testSatLong?.text = satalite.long.toString()
                layout?.setOnClickListener {
                    var intet = Intent(itemView.context , SataliteDetails::class.java)
                    intet.putExtra("name",satalite.name)
                    intet.putExtra("id" , satalite.idNum)
                    intet.putExtra("lat" , satalite.lat)
                    intet.putExtra("lng" , satalite.long)
                    intet.putExtra("alt" , satalite.alt)
                    itemView.context.startActivity(intet)
                }
            }
        }
}