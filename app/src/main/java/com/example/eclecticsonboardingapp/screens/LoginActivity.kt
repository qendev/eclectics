package com.example.eclecticsonboardingapp.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.eclecticsonboardingapp.R
import com.example.eclecticsonboardingapp.databinding.ActivityLoginBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding

    private lateinit var bsBehavior: BottomSheetBehavior<ConstraintLayout>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        bsBehavior = BottomSheetBehavior()



        //hide the app bar
        getSupportActionBar()?.hide();

        displayDialog()
    }

    private fun displayDialog() {
        val view = layoutInflater.inflate(R.layout.custom_login, null)
        val dialog = BottomSheetDialog(this)

        val buttonBiometric = view.findViewById(R.id.buttonBiometric)as Button
        buttonBiometric.setOnClickListener {
            dialog.dismiss()
            showBiometricDialog()
        }
        dialog.setContentView(view)
        dialog.show()
    }

    private fun showBiometricDialog() {
        val view = layoutInflater.inflate(R.layout.custom_biomestric_dialog, null)
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(view)
        dialog.show()
        val buttonSkip = view.findViewById(R.id.buttonSkip) as Button
        buttonSkip.setOnClickListener {
            showVerification()

        }




    }

    private fun showVerification() {
        val intent = Intent(this, VerificationActivity::class.java)
        startActivity(intent)


    }
}