package com.mentorq

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.mentorq.fragment.HomeFragment
import com.mentorq.fragment.OrderFragment
import com.mentorq.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {

    var profileFragment : ProfileFragment = ProfileFragment()
    var homeFragment : HomeFragment = HomeFragment()
    var orderFragment: OrderFragment = OrderFragment()
    var fragmentManager : FragmentManager = supportFragmentManager
    var activeFragment : Fragment = profileFragment


    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_profile-> {
                fragmentManager.beginTransaction().hide(activeFragment).show(profileFragment).commit()
                activeFragment = profileFragment
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_home -> {
                fragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit()
                activeFragment = homeFragment
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_order -> {
                fragmentManager.beginTransaction().hide(activeFragment).show(orderFragment).commit()
                activeFragment = orderFragment
                return@OnNavigationItemSelectedListener true
            }
        }

        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager.beginTransaction().add(R.id.container, homeFragment, "home").hide(homeFragment).commit();
        fragmentManager.beginTransaction().add(R.id.container, orderFragment, "order").hide(orderFragment).commit();
        fragmentManager.beginTransaction().add(R.id.container, profileFragment, "profile").commit();

        val navView: BottomNavigationView = findViewById(R.id.nav_view)


        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

}
