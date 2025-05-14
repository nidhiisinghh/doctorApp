package com.example.doctor

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Doctor_recommendation : AppCompatActivity() {
    private lateinit var doctorAdapter: DoctorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_doctor_recommendation)

        setupDoctorsRecyclerView()
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