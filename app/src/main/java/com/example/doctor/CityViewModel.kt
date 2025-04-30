package com.example.doctor

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CityViewModel (itemView: View): RecyclerView.ViewHolder(itemView){
    private val cityImage: ImageView = itemView.findViewById(R.id.cityImage)
    private val cityName: TextView = itemView.findViewById(R.id.cityName)

    fun bind(cityData: CityData){
        cityImage.setImageResource(cityData.imageResId)
        cityName.text = cityData.name
    }
}
