package com.gity.foodbank.ui.activity.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.gity.foodbank.R
import com.gity.foodbank.databinding.ActivityMainBinding
import com.gity.foodbank.ui.fragment.donate.DonateFragment
import com.gity.foodbank.ui.fragment.home.HomeFragment
import com.gity.foodbank.ui.fragment.profile.ProfileFragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var context = this@MainActivity

    private fun fragmentManager(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.content, fragment, fragment.javaClass.simpleName)
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Disable DarkMode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)


        binding.bottomNav.setOnItemSelectedListener(object : ChipNavigationBar.OnItemSelectedListener {
            override fun onItemSelected(id: Int) {
                when (id) {
                    R.id.bottom_nav_menu_home -> {
                        val fragment = HomeFragment.newInstance()
                        fragmentManager(fragment)
                    }

                    R.id.bottom_nav_menu_donate -> {
                        val fragment = DonateFragment.newInstance()
                        fragmentManager(fragment)
                    }

                    R.id.bottom_nav_menu_profile -> {
                        val fragment = ProfileFragment.newInstance()
                        fragmentManager(fragment)
                    }
                }
            }
        })

        fragmentManager(HomeFragment.newInstance())
        binding.bottomNav.setItemSelected(R.id.bottom_nav_menu_home)


    }


}


