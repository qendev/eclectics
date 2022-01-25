package com.example.eclecticsonboardingapp.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eclecticsonboardingapp.R
import com.example.eclecticsonboardingapp.databinding.ActivityVerificationBinding

class VerificationActivity : AppCompatActivity() {
    private lateinit var binding:ActivityVerificationBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)



        //hide the app bar
        getSupportActionBar()?.hide();

        binding.buttonContinue.setOnClickListener {
            val intent = Intent(this,ChangePinActivity::class.java)
            startActivity(intent)
        }
    }
}