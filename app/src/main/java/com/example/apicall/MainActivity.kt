package com.example.apicall

import android.location.LocationManager
import android.location.LocationManager.GPS_PROVIDER
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apicall.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var  passlist=ArrayList<PassmodelItem>()
    var page=1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

binding.ncsscrollview.setOnScrollChangeListener(object : NestedScrollView.OnScrollChangeListener{
    override fun onScrollChange(
        v: NestedScrollView,
        scrollX: Int,
        scrollY: Int,
        oldScrollX: Int,
        oldScrollY: Int
    ) {
        if (scrollY == v.getChildAt(0).measuredHeight -v.measuredHeight){
            page++
            Data(page)
        }
    }


})


        binding.btnseaqrch.setOnClickListener {
Data(page)


        }

        location()


    }

    private fun location() {
        var locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        if (locationManager.isProviderEnabled(GPS_PROVIDER)) {

        } else {

        }
    }

    private fun internetcheck() {
        var manager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        var into = manager.activeNetworkInfo

        if (into != null && into.isConnected) {
           Data(page)
        } else {


        }
    }



    private fun Data(page: Int) {
        var apiinterface = Apiclint.getdata().create(Apiinterface::class.java)

            apiinterface.Datainterface().enqueue(object : Callback<List<PassmodelItem>> {
                override fun onResponse(
                    call: Call<List<PassmodelItem>>,
                    response: Response<List<PassmodelItem>>

                ) {
                    passlist.addAll(response.body() as ArrayList<PassmodelItem>)

                    binding.rcvData.layoutManager = GridLayoutManager(this@MainActivity,2)
                    binding.rcvData.adapter = DataAdepeter(response.body())
                }

                override fun onFailure(call: Call<List<PassmodelItem>>, t: Throwable) {

                }


            })
        }


}


