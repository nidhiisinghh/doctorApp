package com.example.doctor

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CityActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cityAdapter: CityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        recyclerView = findViewById(R.id.cityRecyclerView)

        val item_list = mutableListOf(
            CityData(
                "Delhi",
                R.drawable.delhi
            ),
            CityData(
                "Mumbai",
                R.drawable.mumbai
            ),
            CityData(
                "Bangalore",
                R.drawable.bangalore
            ),
            CityData(
                "Chennai",
                R.drawable.monument
            ),
            CityData(
                "Kolkata",
                R.drawable.kolkata
            ),
            CityData(
                "Hyderabad",
                R.drawable.hyderabad
            ),
            CityData(
                "Pune",
                R.drawable.pune
            ),
            CityData(
                "Jaipur",
                R.drawable.jaipur
            )
        )

        cityAdapter = CityAdapter(item_list)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@CityActivity)
            adapter = cityAdapter
        }
    }
}