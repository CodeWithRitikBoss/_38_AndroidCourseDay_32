package com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar.databinding.ActivityPaymentsBinding
import kotlin.properties.Delegates

class PaymentsActivity : AppCompatActivity() {
    lateinit var binding: ActivityPaymentsBinding
    var deliveryCharges by Delegates.notNull<Int>()
    var payAbleAmount: Int?= 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPaymentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewForPaymentActivityHeader.setOnClickListener {
            this.finish()
        }

        //Data getting form the previous Activity.
        val productPrice= intent.getStringExtra("productPrice")
        val productDeliveryCharges= intent.getStringExtra("deliveryCharges")

        val intDeliveryCharges= productDeliveryCharges?.toInt()
        //Toast.makeText(this, ":- $productDeliveryCharges", Toast.LENGTH_SHORT).show()

        //Setting the ProductPrice into the TextViews.
        binding.apply {
            textViewToShowProductPrice.text= productPrice
        }

        //Setting some conditions for Delivery charges.
        val intProductPrice= productPrice?.toInt()
        if (intDeliveryCharges != null) {
            if (intDeliveryCharges == 40) {
                deliveryCharges= 40
                payAbleAmount= intProductPrice?.plus(deliveryCharges)
                binding.textViewToShowDeliveryCharges.text= deliveryCharges.toString()
            }else {
                payAbleAmount= intProductPrice
            }
        }
        binding.textViewToShowFinalProductPrice.text= payAbleAmount.toString()
        binding.textViewToShowPayPrice.text= payAbleAmount.toString()



        //Working on RadioButton Selection.
        binding.apply {

            radioButtonForPhonepe.setOnClickListener {
                radioButtonForUpi.isChecked = false
                radioButtonForWalletPostpaid.isChecked= false
                radioButtonForCreditDebitAtmCard.isChecked= false
                radioButtonForNetBanking.isChecked= false
                radioButtonForEMI.isChecked= false
            }
            radioButtonForUpi.setOnClickListener {
                radioButtonForPhonepe.isChecked = false
                radioButtonForWalletPostpaid.isChecked= false
                radioButtonForCreditDebitAtmCard.isChecked= false
                radioButtonForNetBanking.isChecked= false
                radioButtonForEMI.isChecked= false
            }
            radioButtonForWalletPostpaid.setOnClickListener {
                radioButtonForUpi.isChecked = false
                radioButtonForPhonepe.isChecked= false
                radioButtonForCreditDebitAtmCard.isChecked= false
                radioButtonForNetBanking.isChecked= false
                radioButtonForEMI.isChecked= false
            }
            radioButtonForCreditDebitAtmCard.setOnClickListener {
                radioButtonForUpi.isChecked = false
                radioButtonForWalletPostpaid.isChecked= false
                radioButtonForPhonepe.isChecked= false
                radioButtonForNetBanking.isChecked= false
                radioButtonForEMI.isChecked= false
            }
            radioButtonForNetBanking.setOnClickListener {
                radioButtonForUpi.isChecked = false
                radioButtonForWalletPostpaid.isChecked= false
                radioButtonForCreditDebitAtmCard.isChecked= false
                radioButtonForPhonepe.isChecked= false
                radioButtonForEMI.isChecked= false
            }
//            radioButtonForEMI.setOnClickListener {
//                radioButtonForUpi.isChecked = false
//                radioButtonForWalletPostpaid.isChecked= false
//                radioButtonForCreditDebitAtmCard.isChecked= false
//                radioButtonForNetBanking.isChecked= false
//                radioButtonForPhonepe.isChecked= false
//            }



            buttonForContinue.setOnClickListener {
                finish()
                startActivity(Intent(this@PaymentsActivity, OrderPlacedActivity::class.java))
            }


        }

    }
}