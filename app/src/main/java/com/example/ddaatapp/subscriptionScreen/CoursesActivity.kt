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
import com.example.ddaatapp.activity.showVideoContent.MyFavoriteActivity
import com.example.ddaatapp.activity.showVideoContent.MyWatchlistActivity
import com.example.ddaatapp.adapter.CourseAdapter
import com.example.ddaatapp.adapter.LiveCourseAdapter
import com.example.ddaatapp.adapter.MyPurchasedAdapter
import com.example.ddaatapp.commonClass.HorizontalListSpacingItemDecoration
import com.example.ddaatapp.commonClass.LinearListSpacingItemDecoration
import com.example.ddaatapp.commonClass.MyDrawerNavigationItemSelectedListener
import com.example.ddaatapp.commonClass.ShowDialog
import com.example.ddaatapp.databinding.ActivityCoursesBinding
import com.example.ddaatapp.datamodel.CourseDataModel
import com.example.ddaatapp.datamodel.LiveCourseDataModel
import com.example.ddaatapp.datamodel.MyPurchasedDataModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton

class CoursesActivity : AppCompatActivity(), View.OnClickListener  {
    lateinit var binding : ActivityCoursesBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoursesBinding.inflate(layoutInflater)
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


        //Bottom nav bar
        binding.bottomBar.selectedItemId  = R.id.nav_courses
        binding.bottomBar.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_video_library -> {
                    startActivity(Intent(applicationContext, VideoLibraryActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_sessions -> {
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
                R.id.nav_courses -> return@OnNavigationItemSelectedListener true
            }
            false
        })

        //Setup Live course list
        val liveCourseList = arrayListOf<LiveCourseDataModel>(
            LiveCourseDataModel(R.drawable.live_course_sample_img,"Course Name"),
            LiveCourseDataModel(R.drawable.live_course_sample_img,"Course Name"),
            LiveCourseDataModel(R.drawable.live_course_sample_img,"Course Name"),

            )

        //Setup adapter
        val liveCourseRecycler = binding.liveCourseRecycler
        val liveCourseAdapter = LiveCourseAdapter(liveCourseList,this)
        liveCourseRecycler.adapter = liveCourseAdapter
        //Item Decoration
        val noteSpacing = resources.getDimensionPixelSize(R.dimen._15dp)
        liveCourseRecycler.addItemDecoration(HorizontalListSpacingItemDecoration(noteSpacing))



        //setup course list
        val courseList = arrayListOf<CourseDataModel>(
            CourseDataModel(R.drawable.video_sample_image,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",true),
            CourseDataModel(R.drawable.video_sample_image2,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",false),
            CourseDataModel(R.drawable.video_sample_image3,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",true),
            CourseDataModel(R.drawable.video_sample_image3,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",true),
            CourseDataModel(R.drawable.video_sample_image3,"Podcast Title","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",false)
        )

        //setting up the list view adapter
        val courseRecycler = binding.courseRecycler
        val courseAdapter = CourseAdapter(courseList,2,this)
        courseRecycler.adapter = courseAdapter
        //List item Decoration
        val courseSpacing = resources.getDimensionPixelSize(R.dimen._15dp)
        courseRecycler.addItemDecoration(LinearListSpacingItemDecoration(courseSpacing))


        // set up My Purchased list
        val purchasedList = arrayListOf<MyPurchasedDataModel>(
            MyPurchasedDataModel(R.drawable.video_sample_image,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"),
            MyPurchasedDataModel(R.drawable.video_sample_image2,"Course Name","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been")
        )

        //setting up the list view adapter
        val myPurchasedRecycler = binding.myPurchasedRecycler
        val myPurchaseAdapter = MyPurchasedAdapter(purchasedList,2,this)
        myPurchasedRecycler.adapter =  myPurchaseAdapter
        //List item Decoration
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        myPurchasedRecycler.addItemDecoration(LinearListSpacingItemDecoration(spacing))

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
            binding.btnMyWatchList->{
                startActivity(Intent(this, MyWatchlistActivity::class.java))
            }
            binding.btnFilter->{
                ShowDialog(this).showFilterDialog()
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
