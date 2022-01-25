package com.example.eclecticsonboardingapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.eclecticsonboardingapp.R
import com.example.eclecticsonboardingapp.model.screensModelClass
import com.example.eclecticsonboardingapp.screens.LoginActivity
import java.util.ArrayList

class ScreensAdapters(private val models: ArrayList<screensModelClass>, private val context: Context):PagerAdapter() {

    //    private var layoutInflater: LayoutInflater? = null
    override fun getCount(): Int {
        return models.size
    }

    override fun isViewFromObject(
        view: View,
        `object`: Any
    ): Boolean {
        return view == `object`
    }

    @SuppressLint("CutPasteId")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        layoutInflater = LayoutInflater.from(context)
//        val view = layoutInflater.inflate(R.layout.item, container, false)
        Log.e("position", position.toString())
        //inflate the item layout
        val mView = LayoutInflater.from(context).inflate(R.layout.slides_item, container, false)
        val imageView: ImageView
        val textViewWelcome:TextView
        val imageViewTitle:ImageView
        val imageViewContent:ImageView
        val textViewDescription:TextView
        val buttonSetUp:Button


        val desc: TextView
        textViewWelcome = mView.findViewById(R.id.textViewWelcome)
        imageViewTitle = mView.findViewById(R.id.imageViewTitle)
        imageViewContent = mView.findViewById(R.id.imageViewShield)
        textViewDescription = mView.findViewById(R.id.textViewDescription)
        buttonSetUp = mView.findViewById(R.id.buttonSetUp)


        textViewWelcome.setText(models[position].title)
        imageViewTitle.setImageResource(models[position].titleImage)
        imageViewContent.setImageResource(models[position].image)
        textViewDescription.setText(models[position].description)







        //click the getstarted button to open the login activity
        buttonSetUp.setOnClickListener {
            context.startActivity(Intent(context, LoginActivity::class.java))

        }





        container.addView(mView, 0)



        return mView
    }


    override fun destroyItem(
        container: ViewGroup,
        position: Int,
        `object`: Any
    ) {
        container.removeView(`object` as View)
    }
}