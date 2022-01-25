package com.example.eclecticsonboardingapp.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.eclecticsonboardingapp.R
import com.example.eclecticsonboardingapp.adapter.ScreensAdapters
import com.example.eclecticsonboardingapp.databinding.ActivityMainBinding
import com.example.eclecticsonboardingapp.model.screensModelClass


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ScreensAdapters
    private lateinit var models: ArrayList<screensModelClass>
    private lateinit var viewPager: ViewPager

    var sliderDotspanel: LinearLayout? = null
    private var dotscount = 0
    private var mCurrentPosition:Int = 0

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        //hide the app bar
        getSupportActionBar()?.hide();


        viewPager = binding.viewPager
        sliderDotspanel = binding.sliderDots

        models = ArrayList()
        models.add(screensModelClass(R.drawable.shield,R.drawable.brandbook,"Welcome to", "A simplified checkin & checkout system for\nall visitors at various checkpoints in\na premises"))
        models.add(screensModelClass(R.drawable.undraw,R.drawable.brandbook,"Welcome to", "All laptops and computer machinery that a\nvisitor might be having should be scanned\nfor serial code"))
        models.add(screensModelClass(R.drawable.group,R.drawable.brandbook,"Welcome to", "A centralised data point to enable swift\ntracking of all visitors in a premises\nat a particular time"))

        adapter = ScreensAdapters(models, this)
        viewPager.adapter = adapter

        viewPager.setPadding(30, 0, 30, 0)
        dotscount = adapter.count

        val dots = arrayOfNulls<ImageView>(dotscount)

        for (i in 0 until dotscount) {
            dots[i] = ImageView(this)
            dots[i]!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.in_active_dot))
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            params.setMargins(8, 0, 8, 0)
            sliderDotspanel!!.addView(dots[i], params)
        }
        dots[0]?.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.active_dot))

        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{

            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int){

            }

            override fun onPageSelected(position: Int) {

                Log.e("positon",position.toString())

                mCurrentPosition=position
                for (i in 0 until dotscount) {
                    dots[i]?.setImageDrawable(ContextCompat.getDrawable(this@MainActivity,R.drawable.in_active_dot))
                }

                dots[position]?.setImageDrawable(ContextCompat.getDrawable(this@MainActivity,R.drawable.active_dot))



            }
        })

    }




}
