package com.aryancodes.apnidukaan.ui.business

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.PopupMenu
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.aryancodes.apnidukaan.R
import com.aryancodes.apnidukaan.databinding.ActivityBusinessMainBinding
import com.aryancodes.apnidukaan.ui.business.feed.BusinessFeedFragment
import com.aryancodes.apnidukaan.ui.business.myStore.BusinessMyStoreFragment
import com.aryancodes.apnidukaan.ui.business.orders.BusinessOrdersFragment
import com.aryancodes.apnidukaan.ui.business.orders.BusinessOrdersViewModel
import com.aryancodes.apnidukaan.ui.customer.cart.CustomerCartFragment
import com.aryancodes.apnidukaan.ui.customer.profile.CustomerProfileFragment
import com.aryancodes.apnidukaan.ui.customer.shop.CustomerShopFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BusinessMainActivity : AppCompatActivity() {

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
    private lateinit var binding: ActivityBusinessMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBusinessMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.businessNavView
        replaceFragment(BusinessFeedFragment())
        navView.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.business_nav_feed -> replaceFragment(BusinessFeedFragment())
                R.id.business_nav_orders -> replaceFragment(BusinessOrdersFragment())
                R.id.business_nav_my_store -> replaceFragment(BusinessMyStoreFragment())
                else -> {
                    Log.e("Bottom Nav","Error")
                    true
                }
            }
        }

    }

    private fun replaceFragment(fragment: Fragment): Boolean {
        supportFragmentManager.commit {
            replace(R.id.business_fragment_container, fragment)
        }
        return true
    }
}