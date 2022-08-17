package com.example.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(FirstFragment())
        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    Log.e(javaClass.simpleName, "onCreate: home", )
                    loadFragment(FirstFragment())
                    true
                }
                R.id.recode -> {
                    Log.e(javaClass.simpleName, "onCreate: recode", )
                    loadFragment(SecondeFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
    private fun loadFragment(fragment: Fragment){
        Log.e(javaClass.simpleName, "loadFragment : ", )
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}