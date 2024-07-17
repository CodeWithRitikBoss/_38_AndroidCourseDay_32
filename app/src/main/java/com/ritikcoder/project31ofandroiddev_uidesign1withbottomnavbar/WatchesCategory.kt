package com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar.databinding.ActivityWatchsCategoryBinding

class WatchesCategory : AppCompatActivity() {
    lateinit var binding: ActivityWatchsCategoryBinding

    private lateinit var myRecyclerView: RecyclerView
    private lateinit var watchesArrayList: ArrayList<WatchesDataClass>
    private lateinit var myWatchAdapter: MyWatchesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWatchsCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewForWatchActivityHeader.setOnClickListener {
            this.finish()
        }

        myRecyclerView= binding.recyclerViewOfWatches

        myRecyclerView.layoutManager= LinearLayoutManager(this)

        watchesArrayList= arrayListOf<WatchesDataClass>()

        for (index in 1..20){
            val watchesDataClass= WatchesDataClass(index, index)
            watchesArrayList.add(watchesDataClass)
        }
        myWatchAdapter= MyWatchesAdapter(watchesArrayList, this)
        myRecyclerView.adapter= myWatchAdapter


        //Setting what action will be there perform after clicking the Recycler view each item.
        myWatchAdapter.setOnItemClickListenerForWatches(object: MyWatchesAdapter.onItemClickListenerForWatches {
            override fun onItemClick(position: Int) {
                //On clicking each item, what action do you want to perform.
                //Toast.makeText(context, "Home Fragment Fine", Toast.LENGTH_SHORT).show()

                //Setting data to pass to MainActivity4 activity.
                val intentToOpenActivity4= Intent(this@WatchesCategory, MainActivity4::class.java)
                intentToOpenActivity4.putExtra("productImage", R.drawable.img_4)
                intentToOpenActivity4.putExtra("productName", "Watch"+ watchesArrayList[position].watchName)
                intentToOpenActivity4.putExtra("productDescription", "This is the Description of Watch No. - "+ watchesArrayList[position].watchName)
                intentToOpenActivity4.putExtra("productPrice", "Rs "+ watchesArrayList[position].watchPrice + 50)
                startActivity(intentToOpenActivity4)
            }
        })




    }
}