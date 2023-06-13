package com.dhobi.perfectdhobidelivery.ui.fragment

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.dhobi.perfectdhobi.utils.Status
import com.dhobi.perfectdhobidelivery.R
import com.dhobi.perfectdhobidelivery.data.ApiClient
import com.dhobi.perfectdhobidelivery.data.ApiHelper
import com.dhobi.perfectdhobidelivery.data.model.notificationmodel.Notification
import com.dhobi.perfectdhobidelivery.data.modelfactory.CommonModelFactory
import com.dhobi.perfectdhobidelivery.databinding.FragmentNotificationBinding
import com.dhobi.perfectdhobidelivery.ui.MainActivity
import com.dhobi.perfectdhobidelivery.ui.adapter.NotificationAdapter
import com.dhobi.perfectdhobidelivery.utils.Utilities
import com.dhobi.perfectdhobidelivery.viewmodel.CommonViewModel


class NotificationFragment : Fragment(), NotificationAdapter.OnItemClickListener {


    lateinit var fragmentNotificationBinding: FragmentNotificationBinding
    lateinit var mainActivity: MainActivity
    private var notificationAdapter: NotificationAdapter? = null
    private lateinit var viewModel: CommonViewModel

//    private val notificationListModelArrayList: ArrayList<NotifiactionModel>  = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentNotificationBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_notification, container, false)
        val root = fragmentNotificationBinding.root
        mainActivity = activity as MainActivity

        val vm: CommonViewModel by viewModels {
            CommonModelFactory(ApiHelper(ApiClient.apiService))
        }

        viewModel = vm


        fragmentNotificationBinding.topnav.ivBack.setOnClickListener {

            mainActivity.onBackPressedDispatcher.onBackPressed()

        }



        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentNotificationBinding.topnav.tvNavtitle.text = "Back"

//        for (i in 0..5) {
//
//            notificationListModelArrayList.add(
//                NotifiactionModel(
//                    "23-03-2023",
//                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"
//                )
//            )
//
//        }



        notificationAdapter = NotificationAdapter(mainActivity, this@NotificationFragment)
        fragmentNotificationBinding.rvNotification.adapter = notificationAdapter
        fragmentNotificationBinding.rvNotification.layoutManager = GridLayoutManager(mainActivity, 1)

//        notificationAdapter?.updateData(notificationListModelArrayList)

        notificationList()

    }


    private fun notificationList(){

        if (Utilities.isNetworkAvailable(mainActivity)) {
            viewModel.notificationlist(devicetype = "android",
                key = "d77d7bd089b6ea50c35aff32c2ff4608", source = "mob")
                .observe(mainActivity) {
                    it?.let { resource ->
                        when (resource.status) {
                            Status.SUCCESS -> {
                                mainActivity.hideProgressDialog()
                                resource.data?.let {itResponse->

                                    if (itResponse.status) {
                                        notificationAdapter?.updateData(itResponse.data.notifications)
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


    override fun onClick(
        position: Int,
        view: View,
        id: Int,
        s: String,
        mNotificationListModelArrayList: ArrayList<Notification>
    ) {



    }

}