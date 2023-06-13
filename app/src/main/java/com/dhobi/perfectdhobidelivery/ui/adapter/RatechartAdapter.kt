package com.dhobi.perfectdhobidelivery.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dhobi.perfectdhobidelivery.R
import com.dhobi.perfectdhobidelivery.data.model.RatechartModel.RateChart
import com.dhobi.perfectdhobidelivery.data.model.ratemodel.RateModel
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class RatechartAdapter(
    ctx: Context,
    var onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<RatechartAdapter.MyViewHolder>() {
    private val inflater: LayoutInflater
    private var ratechartListModelArrayList: ArrayList<RateChart> = arrayListOf()
    var ctx: Context

    init {
        inflater = LayoutInflater.from(ctx)
        this.ctx = ctx
    }

    interface OnItemClickListener {
        fun onClick(position: Int, view: View, id: Int, s: String, mRatechartListModelArrayList: ArrayList<RateChart>)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = inflater.inflate(R.layout.rv_rateitem, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {



        holder.tvrateDescription.text = ratechartListModelArrayList[position].name
        holder.tvRate.text = "₹"+ratechartListModelArrayList[position].price.numberDecimal

//        val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
//        val output = SimpleDateFormat("dd-MM-yyyy")
//        var d: Date? = null
//        try {
//            d = input.parse(notificationListModelArrayList[position].createdAt.toString())
//        } catch (e: ParseException) {
//            e.printStackTrace()
//        }
//        val formatted: String = output.format(d)


//        holder.tvTitle.text = formatted
//        holder.tvDescriptions.text = notificationListModelArrayList[position].description


        holder.itemView.rootView.setOnClickListener {
//            onItemClickListener.onClick(position, it,notificationListModelArrayList[position].id,
//                notificationListModelArrayList[position].title, notificationListModelArrayList)

        }


    }




    fun updateData(mRatechartListModelArrayList: List<RateChart>){
        ratechartListModelArrayList= mRatechartListModelArrayList as ArrayList<RateChart>
        notifyDataSetChanged()
    }



    override fun getItemCount(): Int {
        return ratechartListModelArrayList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvrateDescription: TextView
        var tvRate: TextView

        init {
            tvrateDescription = itemView.findViewById(R.id.tvrateDescription)
            tvRate = itemView.findViewById(R.id.tvRate)
        }
    }
}