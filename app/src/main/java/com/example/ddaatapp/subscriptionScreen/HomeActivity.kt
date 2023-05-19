package com.example.ddaatapp.subscriptionScreen

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.articleAndBlog.AllBlogActivity
import com.example.ddaatapp.activity.notification.NotificationActivity
import com.example.ddaatapp.activity.showVideoContent.MyFavoriteActivity
import com.example.ddaatapp.adapter.ArticleBlogAdapter
import com.example.ddaatapp.adapter.MyNotesAdapter
import com.example.ddaatapp.commonClass.HorizontalListSpacingItemDecoration
import com.example.ddaatapp.commonClass.MyDrawerNavigationItemSelectedListener
import com.example.ddaatapp.commonClass.ShowDialog
import com.example.ddaatapp.databinding.ActivityHomeBinding
import com.example.ddaatapp.datamodel.ArticleDataModel
import com.example.ddaatapp.datamodel.MyNotesModel
import com.example.ddaatapp.fragment.*
import com.example.ddaatapp.`object`.Constants
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton


class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Setting up drawer Menu
        drawerLayout = binding.drawerLayout
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayUseLogoEnabled(true)

        //for navigation drawer item click listener
        val listener = MyDrawerNavigationItemSelectedListener(this)
        binding.navigationDrawerView.setNavigationItemSelectedListener(listener)


        //Setting header cancel button
        binding.navigationDrawerView.getHeaderView(0).findViewById<MaterialButton>(R.id.btn_drawer_cancel).setOnClickListener {
            drawerLayout.close()
        }


        //bottom navigation view
        binding.bottomBar.selectedItemId = R.id.nav_home

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
                R.id.nav_home -> return@OnNavigationItemSelectedListener true
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




// for notes view
        val noteList = arrayListOf<MyNotesModel>(
            MyNotesModel(
                "Notes Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",
                "15 Dec 2023"
            ),
            MyNotesModel(
                "Notes Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",
                "15 Dec 2023"
            ),
            MyNotesModel(
                "Notes Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",
                "15 Dec 2023"
            ),
            MyNotesModel(
                "Notes Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",
                "15 Dec 2023"
            )
        )
        //adapter setting for myNotes
        val myNotesRecyclerView = binding.myNotesRecyclerView
        val noteAdapter = MyNotesAdapter(noteList,false,this)
        myNotesRecyclerView.adapter = noteAdapter
        //MyNotes item Decoration
        val noteSpacing = resources.getDimensionPixelSize(R.dimen._15dp)
        myNotesRecyclerView.addItemDecoration(HorizontalListSpacingItemDecoration(noteSpacing))



        //By default video fragment
       inflateFragment(HomeVideoLibraryFragment(Constants.SUBSCRIPTION))



        // horizontal buttonView
        val chipGroup = binding.selectOneChipGroup
       chipGroup.setOnCheckedChangeListener { group, checkedId ->
           when(checkedId){
               R.id.btn_video_library ->{
                   inflateFragment(HomeVideoLibraryFragment(Constants.SUBSCRIPTION))
               }
               R.id.btn_streams ->{
                   inflateFragment(HomeStreamsFragment(Constants.HOME))

               }
               R.id.btn_up_sessions ->{
                   inflateFragment(HomeUpcomingSessionsFragment.newInstance())

               }
               R.id.btn_courses ->{
                   inflateFragment(HomeCoursesFragment.newInstance())

               }
           }
        }

// for article view
        val articleList = arrayListOf<ArticleDataModel>(
            ArticleDataModel(R.drawable.article_bg_img,"Lorem Ipsum is simply dummy text","Lorem Ipsum is simply dummy text of the printing and.....","June 04, 2022","Smith"),
            ArticleDataModel(R.drawable.article_bg_img,"Lorem Ipsum is simply dummy text","Lorem Ipsum is simply dummy text of the printing and.....","June 04, 2022","Smith"),
            ArticleDataModel(R.drawable.article_bg_img,"Lorem Ipsum is simply dummy text","Lorem Ipsum is simply dummy text of the printing and.....","June 04, 2022","Smith"),
            ArticleDataModel(R.drawable.article_bg_img,"Lorem Ipsum is simply dummy text","Lorem Ipsum is simply dummy text of the printing and.....","June 04, 2022","Smith")
        )
        val articleRecyclerView = binding.articleRecyclerView
        val articleAdapter = ArticleBlogAdapter(articleList,this,false)
        articleRecyclerView.adapter = articleAdapter

        //Article item Decoration
        val articleSpacing = resources.getDimensionPixelSize(R.dimen._15dp)
        articleRecyclerView.addItemDecoration(HorizontalListSpacingItemDecoration(articleSpacing))


}


    private fun inflateFragment(newInstance: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.list_item_frame, newInstance)
        transaction.commit()
    }



    override fun onClick(view: View?) {
        when(view){
            binding.btnHelp->{
                ShowDialog(this).showHelpDialog()
            }

            binding.btnDrawerMenu->{
                drawerLayout.openDrawer(GravityCompat.START)
            }

            binding.btnNotification->{
                startActivity(Intent(this,NotificationActivity::class.java))
            }

            binding.SearchView->{

            }

            binding.btnFilter->{
               ShowDialog(this).showFilterDialog()

            }

            binding.btnMotivationCancel->{
                binding.motivationCard.visibility = View.GONE
            }

            binding.btnMyFavorite->{
                startActivity(Intent(this, MyFavoriteActivity::class.java))
            }
            binding.btnViewAll->{
                startActivity(Intent(this,AllBlogActivity::class.java))
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