package com.dhobi.perfectdhobidelivery.ui.fragment

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.location.Location
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.dhobi.perfectdhobidelivery.R
import com.dhobi.perfectdhobidelivery.databinding.FragmentDeliverydetailsBinding
import com.dhobi.perfectdhobidelivery.ui.MainActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class DeliverydetailsFragment : Fragment(), OnMapReadyCallback {

    lateinit var fragmentDeliverydetailsBinding: FragmentDeliverydetailsBinding
    lateinit var mainActivity: MainActivity

    var currentLocation: Location? = null
    private var mMap: GoogleMap? = null
    private var locationMarker: Marker? = null
    private var todaydelivery=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentDeliverydetailsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_deliverydetails, container, false)
        val root = fragmentDeliverydetailsBinding.root
        mainActivity = activity as MainActivity

        val intent = arguments
        if (intent != null && intent.containsKey("todaydelivery")) {
            todaydelivery = intent.getString("todaydelivery", "")
            println(todaydelivery)
        }

        val mapFragment = childFragmentManager.findFragmentById(R.id.current_location) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)


        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentDeliverydetailsBinding.topnav.tvNavtitle.text = "Back"

        fragmentDeliverydetailsBinding.topnav.ivBack.setOnClickListener {

            mainActivity.onBackPressedDispatcher.onBackPressed()

        }


        fragmentDeliverydetailsBinding.btnConfirmorder.setOnClickListener {

            val navController = Navigation.findNavController(view)
            navController.navigate(R.id.nav_home)

        }


        fragmentDeliverydetailsBinding.btnStartTrack.setOnClickListener {

            openGoogleMapsNavigationToB(mainActivity,22.606357589755948,88.42309460204574)

        }

        if (todaydelivery.equals("todaydelivery")){

            fragmentDeliverydetailsBinding.btnCall.visibility= View.VISIBLE
            fragmentDeliverydetailsBinding.btnConfirmorder.visibility = View.GONE
            fragmentDeliverydetailsBinding.btnStartTrack.visibility = View.VISIBLE
        }else{

            fragmentDeliverydetailsBinding.btnCall.visibility= View.GONE
            fragmentDeliverydetailsBinding.btnConfirmorder.visibility = View.VISIBLE
            fragmentDeliverydetailsBinding.btnStartTrack.visibility = View.GONE
        }


    }



    fun openGoogleMapsNavigationToB(context: Context, latitude : Double, longitude : Double) {
        val googleMapsUrl = "google.navigation:q=$latitude,$longitude&dirflg=d"
        val uri = Uri.parse(googleMapsUrl)

        val googleMapsPackage = "com.google.android.apps.maps"
        val intent = Intent(Intent.ACTION_VIEW, uri).apply {
            setPackage(googleMapsPackage)
        }

        context.startActivity(intent)
    }



    private fun bitmapDescriptorFromVector(context: Context, vectorResId: Int): BitmapDescriptor {
        val vectorDrawable = ContextCompat.getDrawable(context, vectorResId)
        vectorDrawable!!.setBounds(
            0,
            0,
            vectorDrawable.getIntrinsicWidth(),
            vectorDrawable.getIntrinsicHeight()
        );
        val bitmap = Bitmap.createBitmap(
            vectorDrawable.getIntrinsicWidth(),
            vectorDrawable.getIntrinsicHeight(),
            Bitmap.Config.ARGB_8888
        );
        val canvas = Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    override fun onMapReady(p0: GoogleMap) {
        mMap = p0
        val cameraPosition = CameraPosition.Builder().target(
            LatLng(22.606357589755948,88.42309460204574)
        ).zoom(17f).build()
        mMap?.animateCamera(
            CameraUpdateFactory.newCameraPosition(
                cameraPosition
            )
        )

        val marker = MarkerOptions().position(
            LatLng(22.606357589755948,88.42309460204574)
        ).icon(bitmapDescriptorFromVector(mainActivity,R.drawable.ic_marker2))

        locationMarker = mMap?.addMarker(

            marker
        )

    }

}