package com.dhobi.perfectdhobidelivery.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.dhobi.perfectdhobidelivery.R
import com.dhobi.perfectdhobidelivery.base.BaseActivity
import com.dhobi.perfectdhobidelivery.databinding.ActivityStartscreenBinding

class Startscreen : BaseActivity() {
    lateinit var binding: ActivityStartscreenBinding

    override fun resourceLayout(): Int {
        return R.layout.activity_startscreen
    }

    override fun initializeBinding(binding: ViewDataBinding) {
        this.binding = binding as ActivityStartscreenBinding

    }

    override fun setFunction() {

        binding.btnContinue.setOnClickListener {

            val intent = Intent(this, Login::class.java)
            startActivity(intent)

        }
    }

}