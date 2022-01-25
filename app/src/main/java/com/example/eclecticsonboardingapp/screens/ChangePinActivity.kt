package com.example.eclecticsonboardingapp.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.eclecticsonboardingapp.R
import com.example.eclecticsonboardingapp.databinding.ActivityChangePinBinding

class ChangePinActivity : AppCompatActivity() {

    private lateinit var binding:ActivityChangePinBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePinBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        //hide the app bar
        getSupportActionBar()?.hide();
    }
}