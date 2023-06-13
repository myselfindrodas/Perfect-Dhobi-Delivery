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
import com.dhobi.perfectdhobidelivery.databinding.FragmentMyOrdersBinding
import com.dhobi.perfectdhobidelivery.ui.MainActivity
import com.dhobi.perfectdhobidelivery.ui.adapter.AssignOrderAdapter
import com.dhobi.perfectdhobidelivery.ui.adapter.MyOrderAdapter

class MyOrdersFragment : Fragment(),MyOrderAdapter.OnItemClickListener {

    lateinit var fragmentMyOrdersBinding: FragmentMyOrdersBinding
    lateinit var mainActivity: MainActivity
    private var myOrderAdapter:MyOrderAdapter?=null
    private val myorderModelArrayList: ArrayList<AssignOrderModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentMyOrdersBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_my_orders, container, false)
        val root = fragmentMyOrdersBinding.root
        mainActivity = activity as MainActivity

        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        for (i in 0..5) {

            myorderModelArrayList.add(
                AssignOrderModel(
                    "Sudeshna Das",
                    "Date : 20-04-2023 | Time : 12:30 PM",
                    "Lorem ipsum dolor, 123456"
                )
            )

        }



        myOrderAdapter = MyOrderAdapter(mainActivity, this@MyOrdersFragment)
        fragmentMyOrdersBinding.rvTodayorderList.adapter = myOrderAdapter
        fragmentMyOrdersBinding.rvTodayorderList.layoutManager = GridLayoutManager(mainActivity, 1)

        myOrderAdapter?.updateData(myorderModelArrayList)



        fragmentMyOrdersBinding.topnav.tvNavtitle.text = "Back"

        fragmentMyOrdersBinding.topnav.ivBack.setOnClickListener {

            mainActivity.onBackPressedDispatcher.onBackPressed()
        }


        fragmentMyOrdersBinding.btnTodayorder.setOnClickListener {

            fragmentMyOrdersBinding.btnTodayorder.setTextColor(ContextCompat.getColor(mainActivity, R.color.black))
            fragmentMyOrdersBinding.viewTodayorder.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.blue))

            fragmentMyOrdersBinding.btnUpcomingorder.setTextColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))
            fragmentMyOrdersBinding.viewUpcomingorder.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))

            fragmentMyOrdersBinding.btnCompletedorder.setTextColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))
            fragmentMyOrdersBinding.viewCompletedorder.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))

            myOrderAdapter?.updateData(myorderModelArrayList)
            fragmentMyOrdersBinding.rvTodayorderList.visibility = View.VISIBLE
            fragmentMyOrdersBinding.rvUpcomingorderList.visibility = View.GONE
            fragmentMyOrdersBinding.rvCompletedorderList.visibility = View.GONE


        }



        fragmentMyOrdersBinding.btnUpcomingorder.setOnClickListener {


            fragmentMyOrdersBinding.btnTodayorder.setTextColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))
            fragmentMyOrdersBinding.viewTodayorder.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))

            fragmentMyOrdersBinding.btnUpcomingorder.setTextColor(ContextCompat.getColor(mainActivity, R.color.black))
            fragmentMyOrdersBinding.viewUpcomingorder.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.blue))

            fragmentMyOrdersBinding.btnCompletedorder.setTextColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))
            fragmentMyOrdersBinding.viewCompletedorder.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))

            myOrderAdapter = MyOrderAdapter(mainActivity, this@MyOrdersFragment)
            fragmentMyOrdersBinding.rvUpcomingorderList.adapter = myOrderAdapter
            fragmentMyOrdersBinding.rvUpcomingorderList.layoutManager = GridLayoutManager(mainActivity, 1)
            myOrderAdapter?.updateData(myorderModelArrayList)

            fragmentMyOrdersBinding.rvTodayorderList.visibility = View.GONE
            fragmentMyOrdersBinding.rvUpcomingorderList.visibility = View.VISIBLE
            fragmentMyOrdersBinding.rvCompletedorderList.visibility = View.GONE


        }




        fragmentMyOrdersBinding.btnCompletedorder.setOnClickListener {

            fragmentMyOrdersBinding.btnTodayorder.setTextColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))
            fragmentMyOrdersBinding.viewTodayorder.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))

            fragmentMyOrdersBinding.btnUpcomingorder.setTextColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))
            fragmentMyOrdersBinding.viewUpcomingorder.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.grey_text2))

            fragmentMyOrdersBinding.btnCompletedorder.setTextColor(ContextCompat.getColor(mainActivity, R.color.black))
            fragmentMyOrdersBinding.viewCompletedorder.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.blue))


            myOrderAdapter = MyOrderAdapter(mainActivity, this@MyOrdersFragment, true)
            fragmentMyOrdersBinding.rvCompletedorderList.adapter = myOrderAdapter
            fragmentMyOrdersBinding.rvCompletedorderList.layoutManager = GridLayoutManager(mainActivity, 1)
            myOrderAdapter?.updateData(myorderModelArrayList)

            fragmentMyOrdersBinding.rvTodayorderList.visibility = View.GONE
            fragmentMyOrdersBinding.rvUpcomingorderList.visibility = View.GONE
            fragmentMyOrdersBinding.rvCompletedorderList.visibility = View.VISIBLE


        }
    }

    override fun onClick(
        position: Int,
        view: View,
        mAssignorderModelArrayList: ArrayList<AssignOrderModel>
    ) {



    }

}