package com.example.ddaatapp.unsubscribeScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.notification.NotificationActivity
import com.example.ddaatapp.activity.showVideoContent.MyFavoriteActivity
import com.example.ddaatapp.adapter.StreamsAdapter
import com.example.ddaatapp.adapter.VideoLibraryAdapter
import com.example.ddaatapp.commonClass.DynamicInterestChipCreator
import com.example.ddaatapp.commonClass.LinearListSpacingItemDecoration
import com.example.ddaatapp.commonClass.MyDrawerNavigationItemSelectedListener
import com.example.ddaatapp.commonClass.ShowDialog
import com.example.ddaatapp.databinding.ActivityUnsubscribeSearchBinding
import com.example.ddaatapp.responseDatamodel.StreamsDataModel
import com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel
import com.example.ddaatapp.`object`.Constants
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton

class UnsubscribeSearchActivity : AppCompatActivity() , View.OnClickListener{
    private lateinit var binding : ActivityUnsubscribeSearchBinding

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnsubscribeSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Setting up drawer Menu
        drawerLayout = binding.drawerLayout
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //Setting drawer menu item visibility
        binding.navigationDrawerView.menu.findItem(R.id.drawerMySuperpower).isVisible = false
        binding.navigationDrawerView.menu.findItem(R.id.drawerMyNotes).isVisible = false
        binding.navigationDrawerView.menu.findItem(R.id.drawerReview).isVisible = false

        //for navigation drawer item click listener
        val listener = MyDrawerNavigationItemSelectedListener(this)
        binding.navigationDrawerView.setNavigationItemSelectedListener(listener)

        //Setting header cancel button
        binding.navigationDrawerView.getHeaderView(0).findViewById<MaterialButton>(R.id.btn_drawer_cancel).setOnClickListener {
            drawerLayout.close()
        }

        // Bottom nav bar
        binding.bottomBar.selectedItemId  = R.id.nav_search
        binding.bottomBar.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_question -> {
                    startActivity(Intent(applicationContext, UnsubscribeQuestionActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_streams -> {
                    startActivity(Intent(applicationContext, UnsubscribeStreamsActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_home -> {
                    startActivity(Intent(applicationContext, UnsubscribeHomeActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.nav_search ->  return@OnNavigationItemSelectedListener true
                R.id.nav_chat -> {
                    startActivity(Intent(applicationContext, UnsubscribeChatActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })


        //Setup chips in chipGroup view
        DynamicInterestChipCreator(this).setupChip(binding.choiceChipGroup)

        //Popular Video  setup
        val videoList = arrayListOf<com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel>(
            com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image2,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            )

        val popularVideo = binding.popularVideoRecycler
        val videoAdapter =  VideoLibraryAdapter(videoList,2,this, Constants.UNSUBSCRIBE)
        popularVideo.adapter = videoAdapter
        //List item Decoration
        val videoSpacing = resources.getDimensionPixelSize(R.dimen._15dp)
        popularVideo.addItemDecoration(LinearListSpacingItemDecoration(videoSpacing))

        //Music Setup
        val musicList = arrayListOf<com.example.ddaatapp.responseDatamodel.StreamsDataModel>(
            com.example.ddaatapp.responseDatamodel.StreamsDataModel(
                R.drawable.video_sample_image,
                "Music Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.responseDatamodel.StreamsDataModel(
                R.drawable.video_sample_image2,
                "Music Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
        )
        val musicRecycler = binding.musicRecycler
        val musicAdapter = StreamsAdapter(musicList,2,false,this)
        musicRecycler.adapter = musicAdapter
        //List item Decoration
        val musicSpacing = resources.getDimensionPixelSize(R.dimen._15dp)
        musicRecycler.addItemDecoration(LinearListSpacingItemDecoration(musicSpacing))


        //Podcast Station Setup
        val podcastList = arrayListOf<com.example.ddaatapp.responseDatamodel.StreamsDataModel>(
            com.example.ddaatapp.responseDatamodel.StreamsDataModel(
                R.drawable.video_sample_image,
                "Podcast Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.responseDatamodel.StreamsDataModel(
                R.drawable.video_sample_image2,
                "Podcast Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
        )
        val podcastRecycler = binding.podcastStationRecycler
        val podcastAdapter = StreamsAdapter(podcastList,2,true,this)
        podcastRecycler.adapter = podcastAdapter
        //List item Decoration
        val podcastSpacing = resources.getDimensionPixelSize(R.dimen._15dp)
        podcastRecycler.addItemDecoration(LinearListSpacingItemDecoration(podcastSpacing))

    }



    override fun onClick(view: View?) {
        when(view){
            binding.btnDrawerMenu->{
                drawerLayout.openDrawer(GravityCompat.START)
            }
            binding.btnNotification->{
                startActivity(Intent(this, NotificationActivity::class.java))
            }
            binding.btnFilter->{
                ShowDialog(this).showFilterDialog()
            }
            binding.btnHelp->{
                ShowDialog(this).showHelpDialog()
            }
            binding.btnMyFavorite->{
                startActivity(Intent(this, MyFavoriteActivity::class.java))
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