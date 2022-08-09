package com.caroby.musicapp

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.caroby.musicapp.pages.HomeFragment
import com.caroby.musicapp.pages.UserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val homeFragment= HomeFragment();
    private val userFragment= UserFragment();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragmant(HomeFragment());

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener {
            when(it.itemId){
                R.id.page_1 -> replaceFragmant(HomeFragment())
                R.id.page_2 -> replaceFragmant(UserFragment())
            }
            true
        }



    }


    private fun replaceFragmant(fragment: Fragment){
        if (fragment==null) return;

        val transaction=supportFragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout,fragment);
        transaction.commit();
    }

    fun showSnack(view:View,messaage:String){

        Snackbar.make(view, messaage, Snackbar.LENGTH_SHORT).show();
    }
}