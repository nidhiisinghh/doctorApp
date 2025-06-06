package com.example.doctor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doctor.DoctorAdapter
import com.example.doctor.SpecialtyAdapter
import com.example.doctor.Doctor
import com.example.doctor.Specialty

class MainActivity : AppCompatActivity() {

    private lateinit var specialtyAdapter: SpecialtyAdapter
    private lateinit var doctorAdapter: DoctorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSpecialtiesRecyclerView()
        setupDoctorsRecyclerView()
    }

    private fun setupSpecialtiesRecyclerView() {
        val rvSpecialties = findViewById<RecyclerView>(R.id.rvSpecialties)

        // Horizontal layout for specialties
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvSpecialties.layoutManager = layoutManager

        // Sample specialty data
        val specialties = listOf(
            Specialty("General", R.drawable.salad),
            Specialty("Ophthalmology", R.drawable.eye),
            Specialty("Dentist", R.drawable.tooth),
            Specialty("Nutrition", R.drawable.salad)
        )

        specialtyAdapter = SpecialtyAdapter(specialties)
        rvSpecialties.adapter = specialtyAdapter
    }

    private fun setupDoctorsRecyclerView() {
        val rvDoctors = findViewById<RecyclerView>(R.id.rvTopDoctors)

        // Vertical layout for doctors
        val layoutManager = LinearLayoutManager(this)
        rvDoctors.layoutManager = layoutManager

        // Sample doctor data
        val doctors = listOf(
            Doctor(
                "Dr. Jacob Garcia",
                "Pediatric",
                4.6f,
                130,
                "$15/hr",
                R.drawable.user
            ),
            Doctor(
                "Dr. Antonia Romero",
                "Neurologic",
                4.8f,
                123,
                "$25/hr",
                R.drawable.user
            )
        )

        doctorAdapter = DoctorAdapter(doctors)
        rvDoctors.adapter = doctorAdapter
    }
}