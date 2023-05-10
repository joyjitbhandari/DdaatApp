package com.example.ddaatapp.subscriptionScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.notification.NotificationActivity
import com.example.ddaatapp.activity.session.RequestSessionActivity
import com.example.ddaatapp.activity.showVideoContent.MyFavoriteActivity
import com.example.ddaatapp.adapter.MyTabPagerAdapter
import com.example.ddaatapp.commonClass.MyDrawerNavigationItemSelectedListener
import com.example.ddaatapp.commonClass.ShowDialog
import com.example.ddaatapp.databinding.ActivitySessionsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton

class SessionsActivity : AppCompatActivity(), View.OnClickListener{
    lateinit var binding: ActivitySessionsBinding

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySessionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Setting up drawer Menu
        drawerLayout = binding.drawerLayout
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //for navigation drawer item click listener
        val listener = MyDrawerNavigationItemSelectedListener(this)
        binding.navigationDrawerView.setNavigationItemSelectedListener(listener)

        //Setting header cancel button
        binding.navigationDrawerView.getHeaderView(0).findViewById<MaterialButton>(R.id.btn_drawer_cancel).setOnClickListener {
            drawerLayout.close()
        }


        binding.bottomBar.selectedItemId  = R.id.nav_sessions
        binding.bottomBar.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_video_library -> {
                    startActivity(Intent(applicationContext, VideoLibraryActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_sessions ->return@OnNavigationItemSelectedListener true
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

        //Setting up fragments to viewpager using tablayout
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        val adapter = MyTabPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnDrawerMenu->{
                drawerLayout.openDrawer(GravityCompat.START)
            }
            binding.btnNotification->{
                startActivity(Intent(this, NotificationActivity::class.java))
            }
            binding.btnHelp->{
                ShowDialog(this).showHelpDialog()
            }
            binding.btnMyFavorite->{
                startActivity(Intent(this, MyFavoriteActivity::class.java))
            }
            binding.btnAddSession->{
                startActivity(Intent(this, RequestSessionActivity::class.java))
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
