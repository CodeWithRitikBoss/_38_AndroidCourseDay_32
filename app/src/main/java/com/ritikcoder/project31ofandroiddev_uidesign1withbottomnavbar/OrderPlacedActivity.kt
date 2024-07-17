package com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.window.OnBackInvokedDispatcher
import com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar.databinding.ActivityOrderPlacedBinding
import nl.dionsegijn.konfetti.KonfettiView
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size

class OrderPlacedActivity : AppCompatActivity() {

    lateinit var binding: ActivityOrderPlacedBinding
    lateinit var konfettiView: KonfettiView
    lateinit var paymentsActivity: PaymentsActivity
    lateinit var orderSummary: OrderSummary
    lateinit var mainActivity4: MainActivity4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityOrderPlacedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewForPlacedOrderActivityHeader.setOnClickListener {
            this.finish()
        }

        binding.textViewToGoToHomeActivity.setOnClickListener {
            finish()
            //startActivity(Intent(this@OrderPlacedActivity, MainActivity2::class.java))
        }

        konfettiView= binding.konfettiViewForEffect1
        konfettiView.build()
            .addColors(Color.YELLOW, Color.BLUE, Color.RED)
            .setDirection(0.0, 359.0)
            .setSpeed(1f, 5f)
            .setFadeOutEnabled(true)
            .setTimeToLive(2000L)
            .addShapes(Shape.Square, Shape.Circle)
            .addSizes(Size(14))
            .setPosition(-50f, 1300f, -50f, -50f)
            .streamFor(1000, 120000L)

    }

}