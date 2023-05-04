package com.example.ddaatapp.subscriptionScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.ddaatapp.R
import com.example.ddaatapp.commonClass.MyDrawerNavigationItemSelectedListener
import com.example.ddaatapp.databinding.ActivityVideoLibraryBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class VideoLibraryActivity : AppCompatActivity() , View.OnClickListener  {
    lateinit var binding: ActivityVideoLibraryBinding

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVideoLibraryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Setting up drawer Menu
        drawerLayout = binding.drawerLayout
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //for navigation drawer item click listener
        val listener = MyDrawerNavigationItemSelectedListener(this)
        binding.navigationDrawerView.setNavigationItemSelectedListener(listener)


        // Bottom Nav bar
        binding.bottomBar.selectedItemId  = R.id.nav_video_library

        binding.bottomBar.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_video_library -> return@OnNavigationItemSelectedListener true
                R.id.nav_sessions ->{
                    startActivity(Intent(applicationContext, SessionsActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_home -> {
                    startActivity(Intent(applicationContext, HomeActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_streams -> {
                    startActivity(Intent(applicationContext, StreamsActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_courses -> {
                    startActivity(Intent(applicationContext, CoursesActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })

    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnDrawerMenu->{
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.close()
        }
        else super.onBackPressed()
    }
}