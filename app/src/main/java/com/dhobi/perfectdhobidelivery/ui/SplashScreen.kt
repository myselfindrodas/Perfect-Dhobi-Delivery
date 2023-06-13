package com.dhobi.perfectdhobidelivery.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.ViewDataBinding
import com.dhobi.perfectdhobidelivery.R
import com.dhobi.perfectdhobidelivery.base.BaseActivity
import com.dhobi.perfectdhobidelivery.databinding.ActivitySplashScreenBinding
import com.dhobi.perfectdhobidelivery.utils.AnimUtils
import com.dhobi.perfectdhobidelivery.utils.PrefManager
import com.dhobi.perfectdhobidelivery.utils.Shared_Preferences

class SplashScreen : BaseActivity() {
    lateinit var binding: ActivitySplashScreenBinding
    private var prefManager: PrefManager? = null


    override fun resourceLayout(): Int {
        return  R.layout.activity_splash_screen
    }

    override fun initializeBinding(binding: ViewDataBinding) {
        this.binding = binding as ActivitySplashScreenBinding
    }

    override fun setFunction() {
        callNextScreen()
    }

    private fun callNextScreen() {
        prefManager = PrefManager(this)

        Handler(Looper.myLooper()!!).postDelayed({

            if (prefManager!!.isFirstTimeLaunch) {
                val intent = Intent(this, Welcome::class.java)
                startActivity(intent)
                AnimUtils.FadeOutAnim(this)
                finish()
            } else {

                if (Shared_Preferences.getLoginStatus()==true) {

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    AnimUtils.FadeOutAnim(this)
                    finish()
                } else {

                    val intent = Intent(this, Login::class.java)
                    startActivity(intent)
                    AnimUtils.FadeOutAnim(this)
                    finish()

                }

            }

        }, 3000)
    }


}