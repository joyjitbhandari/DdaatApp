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
import com.example.ddaatapp.commonClass.LinearListSpacingItemDecoration
import com.example.ddaatapp.commonClass.MyDrawerNavigationItemSelectedListener
import com.example.ddaatapp.commonClass.ShowDialog
import com.example.ddaatapp.databinding.ActivityStreamsBinding
import com.example.ddaatapp.databinding.ActivityUnsubscribeHomeBinding
import com.example.ddaatapp.databinding.ActivityUnsubscribeStreamsBinding
import com.example.ddaatapp.databinding.InterestChoiceChipItemBinding
import com.example.ddaatapp.datamodel.StreamsDataModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip

class UnsubscribeStreamsActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var binding: ActivityUnsubscribeStreamsBinding

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnsubscribeStreamsBinding.inflate(layoutInflater)
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

        // Bottom nav bar
        binding.bottomBar.selectedItemId  = R.id.nav_streams
        binding.bottomBar.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.nav_video_library -> {
//                    startActivity(Intent(applicationContext, VideoLibraryActivity::class.java))
//                    finish()
//                    overridePendingTransition(0, 0)
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.nav_sessions -> {
//                    startActivity(Intent(applicationContext, SessionsActivity::class.java))
//                    finish()
//                    overridePendingTransition(0, 0)
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.nav_home -> {
//                    startActivity(Intent(applicationContext, HomeActivity::class.java))
//                    finish()
//                    overridePendingTransition(0, 0)
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.nav_streams -> return@OnNavigationItemSelectedListener true
//                R.id.nav_courses -> {
//                    startActivity(Intent(applicationContext, CoursesActivity::class.java))
//                    finish()
//                    overridePendingTransition(0, 0)
//                    return@OnNavigationItemSelectedListener true
//                }
//            }
            false
        })


        //Setup chips in chipGroup view
        setupChip()

        //DdaatStation setup
        val streamList = arrayListOf<StreamsDataModel>(
            StreamsDataModel(R.drawable.video_sample_image,"Stream Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            StreamsDataModel(R.drawable.video_sample_image2,"Stream Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
        )

        val ddaatStationRecycler = binding.ddaatStationRecycler
        val videoAdapter = StreamsAdapter(streamList,streamList.size,false,this)
        ddaatStationRecycler.adapter = videoAdapter
        //List item Decoration
        val stationSpacing = resources.getDimensionPixelSize(R.dimen._15dp)
        ddaatStationRecycler.addItemDecoration(LinearListSpacingItemDecoration(stationSpacing))


        //Podcast Station Setup
        val podcastList = arrayListOf<StreamsDataModel>(
            StreamsDataModel(R.drawable.video_sample_image,"Podcast Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            StreamsDataModel(R.drawable.video_sample_image2,"Podcast Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            StreamsDataModel(R.drawable.video_sample_image3,"Podcast Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
        )
        val podcastRecycler = binding.podcastStationRecycler
        val podcastAdapter = StreamsAdapter(podcastList,podcastList.size,true,this)
        podcastRecycler.adapter = podcastAdapter
        //List item Decoration
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        podcastRecycler.addItemDecoration(LinearListSpacingItemDecoration(spacing))

    }

    private fun setupChip() {
        val interestList =
            arrayListOf(
                "Need Motivation",
                "Fitness",
                "Business",
                "Job",
                "Relationship",
                "Feeling Lonely",
                "Careers")
        for (name in interestList) {
            val chip = createChip(name)
            binding.choiceChipGroup.addView(chip)
        }
    }

    private fun createChip(label: String): Chip {
        val chip = InterestChoiceChipItemBinding.inflate(layoutInflater).root
        chip.text = label

        //setting padding
        val padding1 = resources.getDimension(R.dimen._20dp).toInt()
        val padding2 = resources.getDimension(R.dimen._18dp).toInt()
        chip.setPadding(padding1, padding2, padding1, padding2)
        return chip
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
            binding.btnSelectGenres->{
                ShowDialog(this).showSelectGenresDialog()
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