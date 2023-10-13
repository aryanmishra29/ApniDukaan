package com.aryancodes.apnidukaan.util

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

object AndroidUtil {
    fun showToast (context: Context, message: String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
    fun replaceFragment(activity: AppCompatActivity, containerId: Int, fragment: Fragment){
        activity.supportFragmentManager.commit{
            replace(containerId, fragment)
        }
    }
}