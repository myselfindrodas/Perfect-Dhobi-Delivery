package com.dhobi.perfectdhobidelivery.ui.fragment

import android.content.ContentValues
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.dhobi.perfectdhobi.utils.Status
import com.dhobi.perfectdhobidelivery.R
import com.dhobi.perfectdhobidelivery.data.ApiClient
import com.dhobi.perfectdhobidelivery.data.ApiHelper
import com.dhobi.perfectdhobidelivery.data.model.AssignOrderTodayDeliveryModel.AssignedSlot
import com.dhobi.perfectdhobidelivery.data.model.assignordermodel.AssignOrderModel
import com.dhobi.perfectdhobidelivery.data.modelfactory.CommonModelFactory
import com.dhobi.perfectdhobidelivery.databinding.FragmentHomeBinding
import com.dhobi.perfectdhobidelivery.ui.Login
import com.dhobi.perfectdhobidelivery.ui.MainActivity
import com.dhobi.perfectdhobidelivery.ui.adapter.AssignOrderAdapter
import com.dhobi.perfectdhobidelivery.ui.adapter.TodayOrderAdapter
import com.dhobi.perfectdhobidelivery.utils.Shared_Preferences
import com.dhobi.perfectdhobidelivery.utils.Utilities
import com.dhobi.perfectdhobidelivery.viewmodel.CommonViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog

class HomeFragment : Fragment(),AssignOrderAdapter.OnItemClickListener, TodayOrderAdapter.OnItemClickListener {

    lateinit var fragmentHomeBinding: FragmentHomeBinding
    lateinit var mainActivity: MainActivity
    lateinit var btnExpandaccount: LinearLayout
    lateinit var llmyaccountsubmenu: LinearLayout
    lateinit var btnNavprofile: LinearLayout
    lateinit var btnNavorders: LinearLayout
    lateinit var btnNavRateChart: LinearLayout
    lateinit var btnNavsupport: LinearLayout
    lateinit var btnNavfaq: LinearLayout
    lateinit var btnNavdelivery: LinearLayout
    lateinit var btnNavnotification: LinearLayout
    lateinit var btnNavEarn: LinearLayout
    lateinit var btnNavlogout: LinearLayout
    lateinit var btnMyaccountExpand: ImageView
    lateinit var btnMyaccountClose: ImageView


    private var assignorderadapter:AssignOrderAdapter?=null
    private var todayOrderAdapter:TodayOrderAdapter?=null
//    private val assignorderModelArrayList: ArrayList<AssignOrderModel> = ArrayList()
    private val todayorderModelArrayList: ArrayList<AssignOrderModel> = ArrayList()
    private lateinit var viewModel: CommonViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        val root = fragmentHomeBinding.root
        mainActivity = activity as MainActivity

        val vm: CommonViewModel by viewModels {
            CommonModelFactory(ApiHelper(ApiClient.apiService))
        }

        viewModel = vm

        btnExpandaccount= root.findViewById(R.id.btnExpandaccount)
        llmyaccountsubmenu= root.findViewById(R.id.llmyaccountsubmenu)
        btnMyaccountClose= root.findViewById(R.id.btnMyaccountClose)
        btnMyaccountExpand= root.findViewById(R.id.btnMyaccountExpand)
        btnNavorders= root.findViewById(R.id.btnNavorders)
        btnNavprofile= root.findViewById(R.id.btnNavprofile)
        btnNavRateChart= root.findViewById(R.id.btnNavRateChart)
        btnNavsupport= root.findViewById(R.id.btnNavsupport)
        btnNavfaq= root.findViewById(R.id.btnNavfaq)
        btnNavdelivery= root.findViewById(R.id.btnNavdelivery)
        btnNavnotification= root.findViewById(R.id.btnNavnotification)
        btnNavEarn= root.findViewById(R.id.btnNavEarn)
        btnNavlogout= root.findViewById(R.id.btnNavlogout)


        fragmentHomeBinding.topnav.iv.setOnClickListener {
            fragmentHomeBinding.dl.openDrawer(GravityCompat.START)
        }

        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        llmyaccountsubmenu.visibility=View.GONE
        btnMyaccountClose.visibility=View.GONE
        btnMyaccountExpand.visibility=View.VISIBLE
        btnExpandaccount.setOnClickListener {
            if (llmyaccountsubmenu.isVisible){
                llmyaccountsubmenu.visibility=View.GONE
                btnMyaccountClose.visibility=View.GONE
                btnMyaccountExpand.visibility=View.VISIBLE

//                btnExpandaccount.background = ContextCompat.getDrawable(mainActivity, R.drawable.right_rounded_blue_bg_btn)


            }else{
                llmyaccountsubmenu.visibility=View.VISIBLE
                btnMyaccountClose.visibility=View.VISIBLE
                btnMyaccountExpand.visibility=View.GONE
//                btnExpandaccount.background = ContextCompat.getDrawable(mainActivity, R.drawable.right_rounded_deepblue_bg_btn)


            }
        }


        btnNavorders.setOnClickListener {

            fragmentHomeBinding.dl.closeDrawer(GravityCompat.START)
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.nav_myorders)
        }


        btnNavdelivery.setOnClickListener {

            fragmentHomeBinding.dl.closeDrawer(GravityCompat.START)
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.nav_mydelivery)
        }


        btnNavRateChart.setOnClickListener {

            fragmentHomeBinding.dl.closeDrawer(GravityCompat.START)
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.nav_ratechart)
        }


        btnNavsupport.setOnClickListener {

            fragmentHomeBinding.dl.closeDrawer(GravityCompat.START)
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.nav_support)

        }


        btnNavfaq.setOnClickListener {

            fragmentHomeBinding.dl.closeDrawer(GravityCompat.START)
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.nav_faq)

        }


        btnNavprofile.setOnClickListener {

            fragmentHomeBinding.dl.closeDrawer(GravityCompat.START)
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.nav_profile)
        }



        btnNavlogout.setOnClickListener {

            val builder = AlertDialog.Builder(mainActivity)
            builder.setMessage("Do you want to logout?")
            builder.setPositiveButton(
                "Ok"
            ) { dialog, which ->
                logout()
                dialog.cancel()
            }

            builder.setNegativeButton("Cancel") { dialog, which ->
                dialog.cancel()
            }
            val alert = builder.create()
            alert.setOnShowListener { arg0: DialogInterface? ->
                alert.getButton(AlertDialog.BUTTON_NEGATIVE)
                    .setTextColor(resources.getColor(R.color.blue,resources.newTheme()))
                alert.getButton(AlertDialog.BUTTON_POSITIVE)
                    .setTextColor(resources.getColor(R.color.blue,resources.newTheme()))
            }
            alert.show()

        }





        btnNavnotification.setOnClickListener {

            fragmentHomeBinding.dl.closeDrawer(GravityCompat.START)
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.nav_notification)
        }


        fragmentHomeBinding.topnav.ivNotification.setOnClickListener {

            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.nav_notification)

        }


//        for (i in 0..5) {
//
//            assignorderModelArrayList.add(
//                AssignOrderModel(
//                    "Sudeshna Das",
//                    "Date : 20-04-2023 | Time : 12:30 PM",
//                    "Lorem ipsum dolor, 123456"
//                )
//            )
//
//        }


        for (i in 0..5) {

            todayorderModelArrayList.add(
                AssignOrderModel(
                    "Indrajit Das",
                    "Date : 20-04-2023 | Time : 12:30 PM",
                    "Lorem ipsum dolor, 123456"
                )
            )

        }



        assignorderadapter = AssignOrderAdapter(mainActivity, this@HomeFragment)
        fragmentHomeBinding.rvAssigndeliverylist.adapter = assignorderadapter
        fragmentHomeBinding.rvAssigndeliverylist.layoutManager = GridLayoutManager(mainActivity, 1)

//        assignorderadapter?.updateData(assignorderModelArrayList)

        todayOrderAdapter = TodayOrderAdapter(mainActivity, this@HomeFragment)
        fragmentHomeBinding.rvtodaydeliverylist.adapter = todayOrderAdapter
        fragmentHomeBinding.rvtodaydeliverylist.layoutManager = GridLayoutManager(mainActivity, 1)

        todayOrderAdapter?.updateData(todayorderModelArrayList)


        assigndeliverytodaydelivery()

    }

    override fun onClick(
        position: Int,
        view: View,
        mAssignorderModelArrayList: ArrayList<AssignedSlot>
    ) {


        showBottomDialog(view, mAssignorderModelArrayList[position].latitude, mAssignorderModelArrayList[position].longitude)


    }









    private fun showBottomDialog(itview: View, lat:String, lon:String){
        var btnTrack: TextView? = null
        var btnOrderdetails: TextView? = null
        val dialog = BottomSheetDialog(mainActivity,R.style.CustomBottomSheetDialog)
        val view=layoutInflater.inflate(R.layout.bottom_dialog_layout,null)
        btnTrack = view.findViewById(R.id.btnTrack)
        btnOrderdetails = view.findViewById(R.id.btnOrder)
        dialog.setCancelable(true)

        btnTrack?.setOnClickListener {

            openGoogleMapsNavigationToB(mainActivity,lat.toDouble(),lon.toDouble())

        }


        btnOrderdetails?.setOnClickListener {

            openOrderdetails(itview)
            dialog.hide()
        }
        dialog.setContentView(view)
        dialog.show()


    }


    fun openOrderdetails(itview: View){

        val navController = Navigation.findNavController(itview)
        navController.navigate(R.id.nav_oderdetails)

    }

    fun openGoogleMapsNavigationToB(context: Context, latitude : Double, longitude : Double) {
        val googleMapsUrl = "google.navigation:q=$latitude,$longitude&dirflg=d"
        val uri = Uri.parse(googleMapsUrl)

        val googleMapsPackage = "com.google.android.apps.maps"
        val intent = Intent(Intent.ACTION_VIEW, uri).apply {
            setPackage(googleMapsPackage)
        }

        context.startActivity(intent)
    }

    override fun onClick(
        position: Int,
        view: View,
        mTodayorderModelArrayList: ArrayList<AssignOrderModel>,
        todayDelivery: Boolean
    ) {

        if (todayDelivery){

            val bundle = Bundle()
            bundle.putString("todaydelivery", "todaydelivery")
            val navController = Navigation.findNavController(view)
            navController.navigate(R.id.nav_deliverydetails, bundle)
        }

    }



    private fun logout(){

        if (Utilities.isNetworkAvailable(mainActivity)) {
            viewModel.logout(devicetype = "android", key = "d77d7bd089b6ea50c35aff32c2ff4608", source = "mob").observe(mainActivity) {
                it?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            mainActivity.hideProgressDialog()
                            if (resource.data?.status == true) {

                                Shared_Preferences.setLoginStatus(false)
                                Shared_Preferences.clearPref()
                                val intent = Intent(mainActivity, Login::class.java)
                                startActivity(intent)
                                mainActivity.finish()

                            } else {
                                Toast.makeText(mainActivity, resource.data?.message, Toast.LENGTH_SHORT).show()
                            }

                        }
                        Status.ERROR -> {
                            mainActivity.hideProgressDialog()
                            val builder = android.app.AlertDialog.Builder(mainActivity)
                            builder.setMessage(it.data?.message)
                            builder.setPositiveButton(
                                "Ok"
                            ) { dialog, which ->

                                dialog.cancel()

                            }
                            val alert = builder.create()
                            alert.setOnShowListener { arg0 ->
                                alert.getButton(android.app.AlertDialog.BUTTON_POSITIVE)
                                    .setTextColor(resources.getColor(R.color.blue))
                            }
                            alert.show()


                        }

                        Status.LOADING -> {
                            mainActivity.showProgressDialog()
                        }
                    }
                }
            }

        } else {
            Toast.makeText(mainActivity, "Ooops! Internet Connection Error", Toast.LENGTH_SHORT).show()
        }
    }


    private fun assigndeliverytodaydelivery(){

        if (Utilities.isNetworkAvailable(mainActivity)) {
            viewModel.assignedslottodaydelivery(devicetype = "android",
                key = "d77d7bd089b6ea50c35aff32c2ff4608", source = "mob")
                .observe(mainActivity) {
                    it?.let { resource ->
                        when (resource.status) {
                            Status.SUCCESS -> {
                                mainActivity.hideProgressDialog()
                                resource.data?.let {itResponse->

                                    if (itResponse.status) {
                                        assignorderadapter?.updateData(itResponse.data.assignedSlots)
                                    } else {

                                        Toast.makeText(mainActivity, resource.data.message, Toast.LENGTH_SHORT).show()

                                    }
                                }


                            }
                            Status.ERROR -> {
                                mainActivity.hideProgressDialog()
                                Log.d(ContentValues.TAG, "print-->"+ it.message)
                                if (it.message!!.contains("404",true)) {
                                    Toast.makeText(mainActivity, "NO data found", Toast.LENGTH_SHORT).show()

                                }
                            }

                            Status.LOADING -> {
                                mainActivity.showProgressDialog()
                            }

                        }

                    }
                }

        } else {
            Toast.makeText(mainActivity, "Ooops! Internet Connection Error", Toast.LENGTH_SHORT)
                .show()
        }
    }


}