package com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar.databinding.ActivityMain3Binding
import com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar.databinding.ActivityMain4Binding
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class MainActivity3 : AppCompatActivity() {

    lateinit var binding: ActivityMain3Binding
    lateinit var recyclerView: RecyclerView
    lateinit var apiAdapter: MyAPI_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewForMainActivity3Header.setOnClickListener {
            this.finish()
        }

        //initializing the recyclerView.
        recyclerView= binding.recyclerViewOfAPI

        //Building Retrofit.
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(API_Interface::class.java)

//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//        supportActionBar!!.title="Activity3"

        //Taking data.
        val retrofitData = retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<MyAPI_Data?> {
            override fun onResponse(call: Call<MyAPI_Data?>, response: Response<MyAPI_Data?>) {
                //if API call is a success, then use the data of API and show in you app.
                var responseBody = response.body()
                val productList = responseBody?.products!!

                //initializing the apiAdapter
                apiAdapter= MyAPI_Adapter(this@MainActivity3, productList)

                binding.progressBar.alpha= 0f
                binding.progressBar.visibility= View.GONE
                recyclerView.adapter= apiAdapter
                recyclerView.layoutManager= LinearLayoutManager(this@MainActivity3)

                apiAdapter.setOnItemClickListener(object: MyAPI_Adapter.onItemClickListener{
                    override fun onItemClick(position: Int) {
                        //onClicking each item, what action do you want to perform.
                        Toast.makeText(this@MainActivity3, "fine till the here", Toast.LENGTH_SHORT).show()

                        //Setting data to pass to MainActivity4 activity.
                        Picasso.get().load(apiAdapter.productAPI_ArrayList[position].thumbnail)
                        val intentToOpenActivity4= Intent(this@MainActivity3, MainActivity4::class.java)
                        intentToOpenActivity4.putExtra("productImage", "")
                        intentToOpenActivity4.putExtra("productName", apiAdapter.productAPI_ArrayList[position].title)
                        intentToOpenActivity4.putExtra("productDescription", apiAdapter.productAPI_ArrayList[position].description)
                        intentToOpenActivity4.putExtra("productPrice", "Rs "+ apiAdapter.productAPI_ArrayList[position].price)
                        startActivity(intentToOpenActivity4)
                        //startActivity(Intent(applicationContext, MainActivity4::class.java))
                    }
                })

                //Initialization of productAPIArrayList


            }

            override fun onFailure(call: Call<MyAPI_Data?>, t: Throwable) {
                //if API call fails, then what will you do.
                //this line of code is user to print message into the Logcat.
                Log.d("Main Activity 3", "onFailure:"+ t.message)

                Toast.makeText(this@MainActivity3, "Failed getting Product Data", Toast.LENGTH_SHORT).show()
                binding.textViewForShowTitle.text= "(●'◡'●)😓😟😔😔😟😓(●'◡'●)"
                binding.textViewForNoInternetConnection.visibility= View.VISIBLE
                binding.lottiBear.visibility= View.VISIBLE
                binding.progressBar.visibility= View.GONE
            }
        })

    }
}