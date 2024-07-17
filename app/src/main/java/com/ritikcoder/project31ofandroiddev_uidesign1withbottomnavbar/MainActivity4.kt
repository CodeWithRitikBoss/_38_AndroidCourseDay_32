package com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar.databinding.ActivityMain3Binding
import com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {

    lateinit var binding: ActivityMain4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewForMainActivity4Header.setOnClickListener {
            this.finish()
        }

//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//        supportActionBar!!.title="Activity3"

        val productImage= intent.getIntExtra("productImage", R.drawable.img_2)
        val productName= intent.getStringExtra("productName")
        val productDescription= intent.getStringExtra("productDescription")
        val productPrice= intent.getStringExtra("productPrice")

        //setting data into the fields.
        binding.imageViewForProductImage.setImageResource(productImage)
        binding.textViewForProductName.text= productName
        binding.textViewForProductDescription.text= productDescription
        binding.textViewForProductPrice.text= productPrice?.substring(3)

        binding.imageViewForShare.setOnClickListener {
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()
        }
        binding.imageViewForUnFavourite.setOnClickListener {
            Toast.makeText(this, "Item added in Favourite List", Toast.LENGTH_SHORT).show()
            binding.imageViewForUnFavourite.visibility= View.GONE
            binding.imageViewForFavourite.visibility= View.VISIBLE
        }
        binding.imageViewForFavourite.setOnClickListener {
            Toast.makeText(this, "Item Removed From Favourite List", Toast.LENGTH_SHORT).show()
            binding.imageViewForFavourite.visibility= View.GONE
            binding.imageViewForUnFavourite.visibility= View.VISIBLE
        }
        binding.imageViewForProductImage.setOnClickListener {
            //Toast.makeText(this, "Zoom in", Toast.LENGTH_SHORT).show()
            binding.imageViewForShowLargeImage.setImageResource(productImage)
            binding.cardViewForLargeImage.visibility= View.VISIBLE
            binding.imageViewForShare.visibility= View.GONE
            binding.imageViewForFavourite.visibility= View.GONE
            binding.imageViewForUnFavourite.visibility= View.GONE
        }
        binding.textViewForCloseLargeImage.setOnClickListener {
            //Toast.makeText(this, "Zoom out", Toast.LENGTH_SHORT).show()
            binding.cardViewForLargeImage.visibility= View.GONE
            binding.imageViewForShare.visibility= View.VISIBLE
            binding.imageViewForFavourite.visibility= View.VISIBLE
            binding.imageViewForUnFavourite.visibility= View.VISIBLE
        }

        binding.buttonForBuyNow.setOnClickListener {

            val intentToOpenOrderSummaryActivity= Intent(this, OrderSummary::class.java)
            intentToOpenOrderSummaryActivity.putExtra("productImage", productImage)
            intentToOpenOrderSummaryActivity.putExtra("productName", productName)
            intentToOpenOrderSummaryActivity.putExtra("productPrice", productPrice)
            startActivity(intentToOpenOrderSummaryActivity)
        }



    }

}