package com.example.doctor

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.doctor.databinding.ActivityIntroBinding
import com.example.doctor.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding =  ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
           loginBtn.setOnClickListener {
               val intent = Intent(this@LoginActivity, CityActivity::class.java)
               startActivity(intent)
          }
            signupRedirect.setOnClickListener {
              val intent = Intent(this@LoginActivity, SignupActivity::class.java)
              startActivity(intent)
          }
        }
   }
}