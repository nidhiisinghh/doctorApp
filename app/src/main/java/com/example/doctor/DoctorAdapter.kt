package com.example.doctor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.doctor.R
import com.example.doctor.Doctor

class DoctorAdapter(private val doctors: List<Doctor>) :
    RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_doctor, parent, false)
        return DoctorViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        val doctor = doctors[position]
        holder.bind(doctor)
    }

    override fun getItemCount(): Int = doctors.size

    inner class DoctorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ivDoctor: ImageView = itemView.findViewById(R.id.ivDoctorImage)
        private val tvName: TextView = itemView.findViewById(R.id.tvDoctorName)
        private val tvSpecialty: TextView = itemView.findViewById(R.id.tvDoctorSpecialty)
        private val tvRating: TextView = itemView.findViewById(R.id.tvRating)
        private val tvReviewCount: TextView = itemView.findViewById(R.id.tvReviewCount)
        private val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)

        fun bind(doctor: Doctor) {
            ivDoctor.setImageResource(doctor.imageResId)
            tvName.text = doctor.name
            tvSpecialty.text = doctor.specialty
            tvRating.text = doctor.rating.toString()
            tvReviewCount.text = "(${doctor.reviewCount} Reviews)"
            tvPrice.text = doctor.price
        }
    }
}
