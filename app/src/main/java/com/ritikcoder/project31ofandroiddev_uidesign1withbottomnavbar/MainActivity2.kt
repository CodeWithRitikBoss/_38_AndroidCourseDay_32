package com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar.databinding.ActivityMain2Binding
import kotlinx.coroutines.awaitAll

class MainActivity2 : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var drawerLayout: DrawerLayout

    lateinit var shareIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        //Working on the Navigation Drawer.
        drawerLayout = binding.drawerLayout
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val navigationView: NavigationView = findViewById(R.id.nav_View)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_nav,
            R.string.close_nav
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }

        val navButtonView: BottomNavigationView = findViewById(R.id.bottomNavigation)

        //replace with Fragment.
        replaceWithFragment(HomeFragment())
        //by default, Home Fragment should be visible to the user.
        navButtonView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.searchIcon -> replaceWithFragment(SearchFragment())
                R.id.categoryIcon -> replaceWithFragment(CategoryFragment())
                R.id.homeIcon -> replaceWithFragment(HomeFragment())
                R.id.cartIcon -> replaceWithFragment(CartFragment())
                R.id.profileIcon -> replaceWithFragment(ProfileFragment())
                else -> {

                }
            }
            true
        }


        //send button code
        val shareBody= "Ritik's Shopping App :- "+ "https://play.google.com/store/apps/details?id=com.ritikcoder.project31ofandroiddev_uidesign1withbottomnavbar&h1=en"
        val shareSubject= "My Shopping Application"

        shareIntent= Intent(Intent.ACTION_SEND)
        shareIntent.type= "text/plane"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject)
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody)

        binding.imageViewForPersonIcon.setOnClickListener {
            //startActivity(Intent(this@MainActivity2, LoginActivity::class.java))
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayout, ProfileFragment())
            fragmentTransaction.commit()
        }


    }

    private fun replaceWithFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {


//            R.id.nav_profile -> replaceWithFragment(ProfileFragment())
//            R.id.nav_home -> replaceWithFragment(HomeFragment())
//            R.id.nav_Category -> replaceWithFragment(CategoryFragment())
//            R.id.nav_Notification -> replaceWithFragment(SearchFragment())
//            R.id.nav_cart -> replaceWithFragment(CartFragment())


            R.id.nav_profile -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, ProfileFragment()).commit()

            R.id.nav_home -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, HomeFragment()).commit()

            R.id.nav_Category -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, CategoryFragment()).commit()

            R.id.nav_cart -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, CartFragment()).commit()

            R.id.nav_Notification -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, SearchFragment()).commit()

            R.id.nav_setting -> supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, ProfileFragment()).commit()

            R.id.nav_share -> startActivity(shareIntent)

          //R.id.nav_share -> share= false

            R.id.nav_logout -> Toast.makeText(this, "Logout Successfully", Toast.LENGTH_SHORT)
                .show()

        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        //super.onBackPressed()
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
            //mainActivity4.activityClose()
            //orderSummary.finish()
//            finish()
//            orderSummary.activityClose()
        }
    }

}