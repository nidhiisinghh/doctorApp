package com.example.doctor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CityAdapter(private val city_List:MutableList<CityData>): RecyclerView.Adapter<CityViewModel>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewModel {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.city_layout,parent,false)
        return CityViewModel(view)
    }

    override fun getItemCount(): Int {
        return city_List.size
    }

    override fun onBindViewHolder(holder: CityViewModel, position: Int) {
        holder.bind(city_List[position])
    }
}

