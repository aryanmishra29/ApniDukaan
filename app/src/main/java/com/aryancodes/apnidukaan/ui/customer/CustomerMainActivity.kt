package com.aryancodes.apnidukaan.ui.customer

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.PopupMenu
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
import com.aryancodes.apnidukaan.util.AndroidUtil

class CustomerMainActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_language ->{
                showLanguageMenu()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun showLanguageMenu() {
        val popupMenu = PopupMenu(this, findViewById(R.id.action_language))
        popupMenu.inflate(R.menu.language_menu)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.language_english -> {
                    true
                }
                R.id.language_hindi -> {
                    true
                }
                R.id.language_bengali -> {
                    true
                }
                R.id.language_urdu -> {
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }

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
        AndroidUtil.replaceFragment(this, R.id.customer_fragment_container, fragment)
        return true
    }
}