package com.dhobi.perfectdhobidelivery.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.dhobi.perfectdhobidelivery.R
import com.dhobi.perfectdhobidelivery.data.model.assignordermodel.AssignOrderModel
import com.dhobi.perfectdhobidelivery.databinding.FragmentMyDeliveryBinding
import com.dhobi.perfectdhobidelivery.ui.MainActivity
import com.dhobi.perfectdhobidelivery.ui.adapter.MyDeliveryAdapter
import com.dhobi.perfectdhobidelivery.ui.adapter.MyOrderAdapter

class MyDeliveryFragment : Fragment(),MyDeliveryAdapter.OnItemClickListener {

    lateinit var fragmentMyDeliveryBinding: FragmentMyDeliveryBinding
    lateinit var mainActivity: MainActivity
    private var myDeliveryAdapter:MyDeliveryAdapter?=null
    private val mydeliveryModelArrayList: ArrayList<AssignOrderModel> = ArrayList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentMyDeliveryBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_my_delivery, container, false)
        val root = fragmentMyDeliveryBinding.root
        mainActivity = activity as MainActivity

        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        for (i in 0..5) {

            mydeliveryModelArrayList.add(
                AssignOrderModel(
                    "Sudeshna Das",
                    "Date : 20-04-2023 | Time : 12:30 PM",
                    "Lorem ipsum dolor, 123456"
                )
            )

        }



        myDeliveryAdapter = MyDeliveryAdapter(mainActivity, this@MyDeliveryFragment)
        fragmentMyDeliveryBinding.rvTodaydeliveryList.adapter = myDeliveryAdapter
        fragmentMyDeliveryBinding.rvTodaydeliveryList.layoutManager = GridLayoutManager(mainActivity, 1)

        myDeliveryAdapter?.updateData(mydeliveryModelArrayList)


        fragmentMyDeliveryBinding.topnav.tvNavtitle.text = "Back"

        fragmentMyDeliveryBinding.topnav.ivBack.setOnClickListener {

            mainActivity.onBackPressedDispatcher.onBackPressed()
        }




        fragmentMyDeliveryBinding.btnTodaydelivery.setOnClickListener {

            fragmentMyDeliveryBinding.btnTodaydelivery.setTextColor(ContextCompat.getColor(mainActivity, R.color.black))
            fragmentMyDeliveryBinding.viewTodaydelivery.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.blue))

            fragmentMyDeliveryBinding.btnUpcomingdelivery.setTextColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))
            fragmentMyDeliveryBinding.viewUpcomingdelivery.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))

            fragmentMyDeliveryBinding.btnCompleteddelivery.setTextColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))
            fragmentMyDeliveryBinding.viewCompleteddelivery.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))

            myDeliveryAdapter?.updateData(mydeliveryModelArrayList)

            fragmentMyDeliveryBinding.rvTodaydeliveryList.visibility = View.VISIBLE
            fragmentMyDeliveryBinding.rvUpcomingdeliveryList.visibility = View.GONE
            fragmentMyDeliveryBinding.rvCompleteddeliveryList.visibility = View.GONE


        }



        fragmentMyDeliveryBinding.btnUpcomingdelivery.setOnClickListener {

            fragmentMyDeliveryBinding.btnTodaydelivery.setTextColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))
            fragmentMyDeliveryBinding.viewTodaydelivery.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))

            fragmentMyDeliveryBinding.btnUpcomingdelivery.setTextColor(ContextCompat.getColor(mainActivity, R.color.black))
            fragmentMyDeliveryBinding.viewUpcomingdelivery.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.blue))

            fragmentMyDeliveryBinding.btnCompleteddelivery.setTextColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))
            fragmentMyDeliveryBinding.viewCompleteddelivery.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))

            myDeliveryAdapter = MyDeliveryAdapter(mainActivity, this@MyDeliveryFragment)
            fragmentMyDeliveryBinding.rvUpcomingdeliveryList.adapter = myDeliveryAdapter
            fragmentMyDeliveryBinding.rvUpcomingdeliveryList.layoutManager = GridLayoutManager(mainActivity, 1)
            myDeliveryAdapter?.updateData(mydeliveryModelArrayList)

            fragmentMyDeliveryBinding.rvTodaydeliveryList.visibility = View.GONE
            fragmentMyDeliveryBinding.rvUpcomingdeliveryList.visibility = View.VISIBLE
            fragmentMyDeliveryBinding.rvCompleteddeliveryList.visibility = View.GONE


        }






        fragmentMyDeliveryBinding.btnCompleteddelivery.setOnClickListener {

            fragmentMyDeliveryBinding.btnTodaydelivery.setTextColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))
            fragmentMyDeliveryBinding.viewTodaydelivery.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))

            fragmentMyDeliveryBinding.btnUpcomingdelivery.setTextColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))
            fragmentMyDeliveryBinding.viewUpcomingdelivery.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))

            fragmentMyDeliveryBinding.btnCompleteddelivery.setTextColor(ContextCompat.getColor(mainActivity, R.color.black))
            fragmentMyDeliveryBinding.viewCompleteddelivery.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.blue))


            myDeliveryAdapter = MyDeliveryAdapter(mainActivity, this@MyDeliveryFragment, true)
            fragmentMyDeliveryBinding.rvCompleteddeliveryList.adapter = myDeliveryAdapter
            fragmentMyDeliveryBinding.rvCompleteddeliveryList.layoutManager = GridLayoutManager(mainActivity, 1)
            myDeliveryAdapter?.updateData(mydeliveryModelArrayList)

            fragmentMyDeliveryBinding.rvTodaydeliveryList.visibility = View.GONE
            fragmentMyDeliveryBinding.rvUpcomingdeliveryList.visibility = View.GONE
            fragmentMyDeliveryBinding.rvCompleteddeliveryList.visibility = View.VISIBLE


        }








    }

    override fun onClick(
        position: Int,
        view: View,
        mAssignorderModelArrayList: ArrayList<AssignOrderModel>
    ) {

    }

}