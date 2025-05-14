package com.example.doctor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.doctor.R
import com.example.doctor.Specialty

class SpecialtyAdapter(private val specialties: List<Specialty>) :
    RecyclerView.Adapter<SpecialtyAdapter.SpecialtyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecialtyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_specialty, parent, false)
        return SpecialtyViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpecialtyViewHolder, position: Int) {
        val specialty = specialties[position]
        holder.bind(specialty)
    }

    override fun getItemCount(): Int = specialties.size

    inner class SpecialtyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivIcon: ImageView = itemView.findViewById(R.id.ivSpecialtyIcon)
        private val tvName: TextView = itemView.findViewById(R.id.tvSpecialtyName)

        fun bind(specialty: Specialty) {
            ivIcon.setImageResource(specialty.iconResId)
            tvName.text = specialty.name
        }
    }
}
