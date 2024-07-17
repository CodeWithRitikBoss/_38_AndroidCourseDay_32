package com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Handler().postDelayed({
//            startActivity(Intent(this, MainActivity2::class.java))
//            finish()
//        }, 1000)

        //These line of code is used to show animated splash screen.
        //Start
        image= binding.imageViewForSplashScreen
        image.alpha= 0f
        image.animate().setDuration(4600).alpha(1f).withEndAction{
            startActivity(Intent(this, MainActivity2::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
        //End

    }
}