package com.dhobi.perfectdhobidelivery.ui.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dhobi.perfectdhobidelivery.R

class DrawerFragment : Fragment() {
    var v: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.drawer_layout_item, container, false) //add_activity_frg
        return v
    }
}