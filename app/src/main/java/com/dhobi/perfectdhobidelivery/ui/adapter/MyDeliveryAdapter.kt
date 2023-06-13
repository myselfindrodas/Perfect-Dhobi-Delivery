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


class MyDeliveryAdapter(
    ctx: Context,
    var onItemClickListener: OnItemClickListener,
    var isCompleteddelivery:Boolean=false
) :
    RecyclerView.Adapter<MyDeliveryAdapter.MyViewHolder>() {
    private val inflater: LayoutInflater
    private var mydeliveryModelArrayList: ArrayList<AssignOrderModel> = ArrayList()
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


            if (isCompleteddelivery){
                tvTaken.visibility = View.VISIBLE
                tvTaken.text = "Delivered"
            }else{
                tvTaken.visibility = View.GONE
            }
            tvUsername.text = mydeliveryModelArrayList[position].username
            tvDatetime.text = mydeliveryModelArrayList[position].datetime
            tvAddress.text = mydeliveryModelArrayList[position].location

            itemView.rootView.setOnClickListener {
                onItemClickListener.onClick(position, it,mydeliveryModelArrayList)

            }

//            llDeliveryDetails.setOnClickListener {
//
//                val navController = Navigation.findNavController(it)
//                navController.navigate(R.id.nav_orderdetails)
//            }


        }
    }

    fun updateData( mAssignorderModelArrayList: List<AssignOrderModel>) {
        mydeliveryModelArrayList = mAssignorderModelArrayList as ArrayList<AssignOrderModel>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mydeliveryModelArrayList.size
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