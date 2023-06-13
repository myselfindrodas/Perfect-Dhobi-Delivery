package com.dhobi.perfectdhobidelivery.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.dhobi.perfectdhobidelivery.R
import com.dhobi.perfectdhobidelivery.databinding.FragmentOrderDetailsBinding
import com.dhobi.perfectdhobidelivery.ui.MainActivity


class OrderDetailsFragment : Fragment() {

    lateinit var fragmentOrderDetailsBinding: FragmentOrderDetailsBinding
    lateinit var mainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        fragmentOrderDetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_order_details, container, false)
        val root = fragmentOrderDetailsBinding.root
        mainActivity = activity as MainActivity

        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fragmentOrderDetailsBinding.topnav.tvNavtitle.text = "Back"

        fragmentOrderDetailsBinding.topnav.ivBack.setOnClickListener {

            mainActivity.onBackPressedDispatcher.onBackPressed()
        }

        fragmentOrderDetailsBinding.btnProceed.setOnClickListener {

            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.nav_deliverydetails)
        }


        with(fragmentOrderDetailsBinding){

            llSubPress.visibility=View.GONE
            llSubCombo.visibility=View.GONE
            llSubDryClean.visibility=View.GONE
            llSubAccessories.visibility=View.GONE
            llSubFurnising.visibility=View.GONE
            llSubPressAds.visibility=View.GONE
            llSubDelivery.visibility=View.GONE
            llSubSpray.visibility=View.GONE
            llSubStainRemoval.visibility=View.GONE
            llAdsOnList.visibility=View.GONE
            llNotesList.visibility=View.GONE
            llOrderList.visibility=View.VISIBLE
            changeBackgroundColor(tvOrderItm,viewOrder)
            llOrderItem.setOnClickListener {
                llOrderList.visibility=View.VISIBLE
                llAdsOnList.visibility=View.GONE
                llNotesList.visibility=View.GONE
                changeBackgroundColor(tvOrderItm,viewOrder)

            }
            llAddOns.setOnClickListener {
                llOrderList.visibility=View.GONE
                llNotesList.visibility=View.GONE
                llAdsOnList.visibility=View.VISIBLE
                changeBackgroundColor(tvAdsOn,viewAdsOn)
            }
            llNotes.setOnClickListener {
                llOrderList.visibility=View.GONE
                llAdsOnList.visibility=View.GONE
                llNotesList.visibility=View.VISIBLE
                changeBackgroundColor(tvNote,viewNote)
            }

            llPressAds.setOnClickListener {
                if (llSubPressAds.isVisible){
                    llSubPressAds.visibility=View.GONE
                    ivDown.rotation = 90f
                }else{
                    llSubPressAds.visibility=View.VISIBLE
                    ivDown.rotation = 270f
                }
            }
            llStainRemoval.setOnClickListener {
                if (llSubStainRemoval.isVisible){
                    llSubStainRemoval.visibility=View.GONE
                    ivDown.rotation = 90f
                }else{
                    llSubStainRemoval.visibility=View.VISIBLE
                    ivDown.rotation = 270f
                }
            }
            llDelivery.setOnClickListener {
                if (llSubDelivery.isVisible){
                    llSubDelivery.visibility=View.GONE
                    ivDown.rotation = 90f
                }else{
                    llSubDelivery.visibility=View.VISIBLE
                    ivDown.rotation = 270f
                }
            }
            llSpray.setOnClickListener {
                if (llSubSpray.isVisible){
                    llSubSpray.visibility=View.GONE
                    ivDown.rotation = 90f
                }else{
                    llSubSpray.visibility=View.VISIBLE
                    ivDown.rotation = 270f
                }
            }


            llPress.setOnClickListener {
                if (llSubPress.isVisible){
                    llSubPress.visibility=View.GONE
                    ivDown.rotation = 90f
                }else{
                    llSubPress.visibility=View.VISIBLE
                    ivDown.rotation = 270f
                }
            }
            llCombo.setOnClickListener {
                if (llSubCombo.isVisible){
                    llSubCombo.visibility=View.GONE
                    ivDown1.rotation = 90f
                }else{
                    llSubCombo.visibility=View.VISIBLE
                    ivDown1.rotation = 270f
                }
            }
            llDryClean.setOnClickListener {
                if (llSubDryClean.isVisible){
                    llSubDryClean.visibility=View.GONE
                    ivDown2.rotation = 90f
                }else{
                    llSubDryClean.visibility=View.VISIBLE
                    ivDown2.rotation = 270f
                }
            }
            llAccessories.setOnClickListener {
                if (llSubAccessories.isVisible){
                    llSubAccessories.visibility=View.GONE
                    ivDown3.rotation = 90f
                }else{
                    llSubAccessories.visibility=View.VISIBLE
                    ivDown3.rotation = 270f
                }
            }
            llFurnising.setOnClickListener {
                if (llSubFurnising.isVisible){
                    llSubFurnising.visibility=View.GONE
                    ivDown4.rotation = 90f
                }else{
                    llSubFurnising.visibility=View.VISIBLE
                    ivDown4.rotation = 270f
                }
            }
        }


    }



    private fun changeBackgroundColor(text: TextView, view: View){
        with(fragmentOrderDetailsBinding){

            tvOrderItm.setTextColor(ContextCompat.getColor(mainActivity, R.color.grey_text))
            viewOrder.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.grey_text))
            tvAdsOn.setTextColor(ContextCompat.getColor(mainActivity, R.color.grey_text))
            viewAdsOn.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.grey_text))
            tvNote.setTextColor(ContextCompat.getColor(mainActivity, R.color.grey_text))
            viewNote.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.grey_text))


            text.setTextColor(ContextCompat.getColor(mainActivity, R.color.black))
            view.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.blue))
        }
    }

}