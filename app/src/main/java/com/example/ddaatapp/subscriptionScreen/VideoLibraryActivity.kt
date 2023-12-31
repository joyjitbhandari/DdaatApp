package com.example.ddaatapp.subscriptionScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.activity.notification.NotificationActivity
import com.example.ddaatapp.activity.showVideoContent.MyFavoriteActivity
import com.example.ddaatapp.activity.showVideoContent.MyWatchlistActivity
import com.example.ddaatapp.adapter.VideoLibraryAdapter
import com.example.ddaatapp.databinding.ActivityVideoLibraryBinding
import com.example.ddaatapp.utils.Constants
import com.example.ddaatapp.utils.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton

class VideoLibraryActivity: BaseActivity() , View.OnClickListener  {
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

        //Setting header cancel button
        binding.navigationDrawerView.getHeaderView(0).findViewById<MaterialButton>(R.id.btn_drawer_cancel).setOnClickListener {
            drawerLayout.close()
        }
        //navigation data set
        binding.navigationDrawerView.getHeaderView(0).findViewById<TextView>(R.id.nav_header_name).text = SavedData.profileData.name
        binding.navigationDrawerView.getHeaderView(0).findViewById<TextView>(R.id.nav_header_email).text = SavedData.profileData.email

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

        //Setup chips in chipGroup view
        DynamicInterestChipCreator(this).setupChip(binding.choiceChipGroup)


        // Setting top videos in recycler
        //video list
        val videoList = arrayListOf<com.example.ddaatapp.model.responseDatamodel.VideoLibraryDataModel>(
            com.example.ddaatapp.model.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image2,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image3,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image3,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
        )

        val topVideoRecyclerView= binding.topVideoRecycler
        val adapter = VideoLibraryAdapter(videoList,5,this, Constants.SUBSCRIPTION)
        topVideoRecyclerView.adapter = adapter
        //List item Decoration
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        topVideoRecyclerView.addItemDecoration(LinearListSpacingItemDecoration(spacing))
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
            binding.btnFilter->{
                ShowDialog(this).showFilterDialog()
            }
            binding.btnMyWatchList->{
                startActivity(Intent(this,MyWatchlistActivity::class.java))
            }
            binding.btnMyFavorite->{
                startActivity(Intent(this,MyFavoriteActivity::class.java))
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