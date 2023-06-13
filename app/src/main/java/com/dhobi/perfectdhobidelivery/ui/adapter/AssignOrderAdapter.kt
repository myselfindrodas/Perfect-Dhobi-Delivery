package com.dhobi.perfectdhobidelivery.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dhobi.perfectdhobidelivery.R
import com.dhobi.perfectdhobidelivery.data.model.AssignOrderTodayDeliveryModel.AssignedSlot
import com.dhobi.perfectdhobidelivery.data.model.assignordermodel.AssignOrderModel


class AssignOrderAdapter(
    ctx: Context,
    var onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<AssignOrderAdapter.MyViewHolder>() {
    private val inflater: LayoutInflater
    private var assignorderModelArrayList: ArrayList<AssignedSlot> = ArrayList()
    var ctx: Context

    init {
        inflater = LayoutInflater.from(ctx)
        this.ctx = ctx
    }


    interface OnItemClickListener {
        fun onClick(
            position: Int,
            view: View,
            mAssignorderModelArrayList: ArrayList<AssignedSlot>
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = inflater.inflate(R.layout.rv_assignedorderitem, parent, false)
        return MyViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder) {


            tvUsername.text = assignorderModelArrayList[position].customerName
            tvDatetime.text = "Date :"+assignorderModelArrayList[position].deliveryDate+" | "+"Time :"+assignorderModelArrayList[position].deliveryTime
            tvAddress.text = assignorderModelArrayList[position].fullAddress

            itemView.rootView.setOnClickListener {
                onItemClickListener.onClick(position, it,assignorderModelArrayList)

            }

//            llDeliveryDetails.setOnClickListener {
//
//                val navController = Navigation.findNavController(it)
//                navController.navigate(R.id.nav_orderdetails)
//            }


        }
    }

    fun updateData( mAssignorderModelArrayList: List<AssignedSlot>) {
        assignorderModelArrayList = mAssignorderModelArrayList as ArrayList<AssignedSlot>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return assignorderModelArrayList.size
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