package com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar.databinding.ActivityOrderSummaryBinding

class OrderSummary : AppCompatActivity() {

    lateinit var binding: ActivityOrderSummaryBinding
    private lateinit var spinner: Spinner
    lateinit var totalPrice1: String
    lateinit var totalPriceToPassAnotherActivity: String
    lateinit var mainActivity4: MainActivity4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderSummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewForOrderSummeryActivityHeader.setOnClickListener {
            this.finish()
        }

        //Getting the data from the MainActivity4.
        val productImage = intent.getIntExtra("productImage", R.drawable.img_2)
        val productName = intent.getStringExtra("productName")
        val productPrice = intent.getStringExtra("productPrice")?.substring(3)

        val productPriceInt = productPrice?.toInt()
        var deliveryCharges: Int = 0

        binding.apply {
            imageViewToShowProductImage.setImageResource(productImage)
            textViewToShowProductName.text = productName
            textViewToShowProductPrice.text = productPrice
            textViewToShowProductPrice1.text = productPrice
            val totalPrice = productPrice?.toInt()
            var discountPrice: Int = 0

            if (totalPrice != null) {
                if (totalPrice >= 1000) {
                    discountPrice = 300
                }
                if (totalPrice < 1000) {
                    discountPrice = 150
                }
                if (totalPrice < 500) {
                    discountPrice = 50
                }
            }

            textViewToShowDiscountPrice.text = discountPrice.toString()
            totalPrice1 = totalPrice?.minus(discountPrice).toString()
            totalPriceToPassAnotherActivity = totalPrice?.minus(discountPrice).toString()

            if (productPriceInt != null) {
                if (productPriceInt < 500) {
                    deliveryCharges = 40
                    val totalAmountAfterDeliveryCharges = totalPrice1.toInt()
                    totalPrice1 = totalAmountAfterDeliveryCharges.plus(deliveryCharges).toString()
                    textViewToDelvieryCharges.text = deliveryCharges.toString()
                }
            }
            textViewToShowTotalAmount.text = totalPrice1
            textViewToShowPayPrice.text = totalPrice1
        }

//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//        supportActionBar!!.title="title"

        //Working on the Spinner items.
        spinner = binding.spinner

        //list item for spinner
        val listItem = listOf("Qty:   1", "Qty:   2", "Qty:   3", "Qty:   4", "Qty:   5")

        //adapter for spinner.
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listItem)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter

        //setting dropdown item view resource in the spinner.
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                //Toast.makeText(this@OrderSummary, "you have selected $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        //end the setting dropdown spinner code.

        binding.buttonForContinue.setOnClickListener {
            val intentToOpenPaymentsActivity =
                Intent(this@OrderSummary, PaymentsActivity::class.java)
            intentToOpenPaymentsActivity.putExtra("productPrice", totalPriceToPassAnotherActivity)
            if (productPriceInt != null) {
                if (productPriceInt < 500) {
                    intentToOpenPaymentsActivity.putExtra("deliveryCharges", "40")
                }else {
                    intentToOpenPaymentsActivity.putExtra("deliveryCharges", "1")
                }
            }
            startActivity(intentToOpenPaymentsActivity)
        }

    }

    //this code is used to work on the supportActionBar with back arrow <--
//    override fun onSupportNavigateUp(): Boolean {
//        finish()
//        return true
//    }

}