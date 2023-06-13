package com.dhobi.perfectdhobidelivery.ui

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.ViewDataBinding
import androidx.viewpager.widget.PagerAdapter
import com.dhobi.perfectdhobidelivery.R
import com.dhobi.perfectdhobidelivery.base.BaseActivity
import com.dhobi.perfectdhobidelivery.databinding.ActivityWelcomeBinding
import com.dhobi.perfectdhobidelivery.utils.PrefManager

class Welcome : BaseActivity() {
    lateinit var binding: ActivityWelcomeBinding
    private var myViewPagerAdapter: MyViewPagerAdapter? = null
    private lateinit var layouts: IntArray
    private var prefManager: PrefManager? = null


    override fun resourceLayout(): Int {
        return R.layout.activity_welcome
    }

    override fun initializeBinding(binding: ViewDataBinding) {
        this.binding = binding as ActivityWelcomeBinding


    }

    override fun setFunction() {

        prefManager = PrefManager(this)
        if (!prefManager!!.isFirstTimeLaunch) {
            launchHomeScreen()
            finish()
        }

        layouts = intArrayOf(
            R.layout.welcome1,
            R.layout.welcome2,
            R.layout.welcome3,
            R.layout.welcome4)


        changeStatusBarColor()

        myViewPagerAdapter = MyViewPagerAdapter()
        binding.viewPager.adapter = myViewPagerAdapter
        binding.dotsIndicator.attachTo(binding.viewPager)


        binding.btnSkip.setOnClickListener(View.OnClickListener {
            launchHomeScreen()
        })
        binding.btnContinue.setOnClickListener(View.OnClickListener {
            val current = getItem(+1)
            if (current < layouts.size) {
                // move to next screen
                binding.viewPager.currentItem = current
            } else {
                launchHomeScreen()
            }
        })

    }


    private fun getItem(i: Int): Int {
        return binding.viewPager.currentItem + i
    }


    private fun launchHomeScreen() {
        prefManager!!.isFirstTimeLaunch = false
        startActivity(Intent(this@Welcome, Startscreen::class.java))
        finish()
    }


    private fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }


    inner class MyViewPagerAdapter : PagerAdapter() {
        private var layoutInflater: LayoutInflater? = null
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            layoutInflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = layoutInflater!!.inflate(layouts[position], container, false)
            container.addView(view)
            return view
        }

        override fun getCount(): Int {
            return layouts.size
        }

        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view === obj
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            val view = `object` as View
            container.removeView(view)
        }
    }


}