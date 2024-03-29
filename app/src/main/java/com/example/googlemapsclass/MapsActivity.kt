package com.example.googlemapsclass

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.googlemapsclass.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //mMap.mapType= GoogleMap.MAP_TYPE_NORMAL

        val ChefTesoro= LatLng(6.1971034,-75.5592313)
        mMap.addMarker(MarkerOptions().position(ChefTesoro).title("Chef Burger El Tesoro"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ChefTesoro))

        val ChefLaureles= LatLng(6.24614,-75.5974009)
        mMap.addMarker(MarkerOptions().position(ChefLaureles).title("Chef Burger Laureles"))

        val ChefMayorca= LatLng(6.1603391,-75.6044992)
        mMap.addMarker(MarkerOptions().position(ChefMayorca).title("Chef Burger Mayorca"))

        val ChefVivaEnvigado= LatLng(6.1765164,-75.5917998)
        mMap.addMarker(MarkerOptions().position(ChefVivaEnvigado).title("Chef Burger Viva Envigado"))

        val ChefMillaOro= LatLng(6.2043456,-75.5719071)
        mMap.addMarker(MarkerOptions().position(ChefMillaOro).title("Chef Burger Milla de oro "))

        val ChefProvenza= LatLng(6.208567,-75.5654462)
        mMap.addMarker(MarkerOptions().position(ChefProvenza).title("Chef Burger Provenza "))

        val ChefLemont= LatLng(6.1532427,-75.5384121)
        mMap.addMarker(MarkerOptions().position(ChefLemont).title("Chef Burger Lemont"))

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        mMap.isMyLocationEnabled= true
    }
}