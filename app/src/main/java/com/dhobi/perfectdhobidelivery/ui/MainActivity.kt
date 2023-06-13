package com.dhobi.perfectdhobidelivery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import com.dhobi.perfectdhobidelivery.R
import com.dhobi.perfectdhobidelivery.base.BaseActivity
import com.dhobi.perfectdhobidelivery.databinding.ActivityMainBinding

class MainActivity : BaseActivity(),
    NavController.OnDestinationChangedListener  {

    lateinit var binding: ActivityMainBinding
    var mNavController: NavController? = null

    override fun resourceLayout(): Int {
        return R.layout.activity_main
    }

    override fun initializeBinding(binding: ViewDataBinding) {
        this.binding = binding as ActivityMainBinding

    }

    override fun setFunction() {

        mNavController = findNavController(R.id.flFragment)

        mNavController?.addOnDestinationChangedListener(this)
        mNavController?.navigate(R.id.nav_home)

    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        hideKeyboard()
    }


    override fun onDestroy() {
        findNavController(R.id.flFragment).removeOnDestinationChangedListener(this)
        super.onDestroy()
    }

    fun showProgressDialog() {
        binding.rlLoading.visibility = View.VISIBLE
    }

    fun hideProgressDialog() {
        binding.rlLoading.visibility = View.GONE

    }

}