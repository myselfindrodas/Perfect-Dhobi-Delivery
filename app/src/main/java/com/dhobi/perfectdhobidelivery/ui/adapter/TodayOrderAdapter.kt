package com.dhobi.perfectdhobidelivery.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dhobi.perfectdhobidelivery.R
import com.dhobi.perfectdhobidelivery.data.model.assignordermodel.AssignOrderModel


class TodayOrderAdapter(
    ctx: Context,
    var onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<TodayOrderAdapter.MyViewHolder>() {
    private val inflater: LayoutInflater
    private var todayorderModelArrayList: ArrayList<AssignOrderModel> = ArrayList()
    var ctx: Context

    init {
        inflater = LayoutInflater.from(ctx)
        this.ctx = ctx
    }


    interface OnItemClickListener {
        fun onClick(
            position: Int,
            view: View,
            mTodayorderModelArrayList: ArrayList<AssignOrderModel>,
            todayDelivery:Boolean=false
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = inflater.inflate(R.layout.rv_assignedorderitem, parent, false)
        return MyViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder) {


            tvUsername.text = todayorderModelArrayList[position].username
            tvDatetime.text = todayorderModelArrayList[position].datetime
            tvAddress.text = todayorderModelArrayList[position].location

            itemView.rootView.setOnClickListener {
                onItemClickListener.onClick(position, it,todayorderModelArrayList, true)

            }

//            llDeliveryDetails.setOnClickListener {
//
//                val navController = Navigation.findNavController(it)
//                navController.navigate(R.id.nav_orderdetails)
//            }


        }
    }

    fun updateData( mTodayorderModelArrayList: List<AssignOrderModel>) {
        todayorderModelArrayList = mTodayorderModelArrayList as ArrayList<AssignOrderModel>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return todayorderModelArrayList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvUsername: TextView
        var tvDatetime: TextView
        var tvAddress: TextView


        init {

            tvUsername = itemView.findViewById(R.id.tvUsername)
            tvDatetime = itemView.findViewById(R.id.tvDatetime)
            tvAddress = itemView.findViewById(R.id.tvAddress)
        }
    }
}