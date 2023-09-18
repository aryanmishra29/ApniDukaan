package com.aryancodes.apnidukaan.ui.customer

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.aryancodes.apnidukaan.R
import com.aryancodes.apnidukaan.databinding.ActivityCustomerMainBinding
import com.aryancodes.apnidukaan.ui.customer.cart.CustomerCartFragment
import com.aryancodes.apnidukaan.ui.customer.profile.CustomerProfileFragment
import com.aryancodes.apnidukaan.ui.customer.shop.CustomerShopFragment

class CustomerMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomerMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityCustomerMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.customerNavView
        replaceFragment(CustomerShopFragment())
        navView.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.customer_nav_shop -> replaceFragment(CustomerShopFragment())
                R.id.customer_nav_cart -> replaceFragment(CustomerCartFragment())
                R.id.customer_nav_profile -> replaceFragment(CustomerProfileFragment())
                else -> {
                    Log.e("Bottom Nav","Error")
                    true
                }
            }
        }

    }

    private fun replaceFragment(fragment: Fragment): Boolean {
        supportFragmentManager.commit {
            replace(R.id.customer_fragment_container, fragment)
        }
        return true
    }
}