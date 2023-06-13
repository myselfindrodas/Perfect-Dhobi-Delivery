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


class MyOrderAdapter(
    ctx: Context,
    var onItemClickListener: OnItemClickListener,
    var isCompletedorder:Boolean=false
) :
    RecyclerView.Adapter<MyOrderAdapter.MyViewHolder>() {
    private val inflater: LayoutInflater
    private var myorderModelArrayList: ArrayList<AssignOrderModel> = ArrayList()
    var ctx: Context

    init {
        inflater = LayoutInflater.from(ctx)
        this.ctx = ctx
    }


    interface OnItemClickListener {
        fun onClick(
            position: Int,
            view: View,
            mAssignorderModelArrayList: ArrayList<AssignOrderModel>
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = inflater.inflate(R.layout.rv_assignedorderitem, parent, false)
        return MyViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        with(holder) {


            if (isCompletedorder){
                tvTaken.visibility = View.VISIBLE
            }else{
                tvTaken.visibility = View.GONE
            }
            tvUsername.text = myorderModelArrayList[position].username
            tvDatetime.text = myorderModelArrayList[position].datetime
            tvAddress.text = myorderModelArrayList[position].location

            itemView.rootView.setOnClickListener {
                onItemClickListener.onClick(position, it,myorderModelArrayList)

            }

//            llDeliveryDetails.setOnClickListener {
//
//                val navController = Navigation.findNavController(it)
//                navController.navigate(R.id.nav_orderdetails)
//            }


        }
    }

    fun updateData( mAssignorderModelArrayList: List<AssignOrderModel>) {
        myorderModelArrayList = mAssignorderModelArrayList as ArrayList<AssignOrderModel>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return myorderModelArrayList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvUsername: TextView
        var tvDatetime: TextView
        var tvAddress: TextView
        var tvTaken: TextView


        init {

            tvUsername = itemView.findViewById(R.id.tvUsername)
            tvDatetime = itemView.findViewById(R.id.tvDatetime)
            tvAddress = itemView.findViewById(R.id.tvAddress)
            tvTaken = itemView.findViewById(R.id.tvTaken)
        }
    }
}