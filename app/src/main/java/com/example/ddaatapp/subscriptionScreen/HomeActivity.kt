package com.example.ddaatapp.subscriptionScreen

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.activity.blogs.AllBlogActivity
import com.example.ddaatapp.activity.notification.NotificationActivity
import com.example.ddaatapp.activity.showVideoContent.MyFavoriteActivity
import com.example.ddaatapp.adapter.ArticleBlogAdapter
import com.example.ddaatapp.adapter.MyNotesAdapter
import com.example.ddaatapp.databinding.ActivityHomeBinding
import com.example.ddaatapp.fragment.*
import com.example.ddaatapp.model.responseDatamodel.BlogData
import com.example.ddaatapp.network.RetrofitClient
import com.example.ddaatapp.utils.*
import com.example.ddaatapp.viewModel.HomeViewModel
import com.example.ddaatapp.viewModel.ViewModelFactory
import com.flynaut.healthtag.util.EventObserver
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton


class HomeActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var viewModel : HomeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //View model initialized
        viewModel = ViewModelProvider(this, ViewModelFactory(RetrofitClient().apiService))[HomeViewModel::class.java]

        //view-model method calling
            showProgressDialog()
            initObserver()
            viewModel.getAllBlog()

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
        //navigation data set
        binding.navigationDrawerView.getHeaderView(0).findViewById<TextView>(R.id.nav_header_name).text = SavedData.profileData.name
        binding.navigationDrawerView.getHeaderView(0).findViewById<TextView>(R.id.nav_header_email).text = SavedData.profileData.email


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
        val noteList = arrayListOf<com.example.ddaatapp.model.responseDatamodel.MyNotesModel>(
            com.example.ddaatapp.model.responseDatamodel.MyNotesModel(
                "Notes Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",
                "15 Dec 2023"
            ),
            com.example.ddaatapp.model.responseDatamodel.MyNotesModel(
                "Notes Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",
                "15 Dec 2023"
            ),
            com.example.ddaatapp.model.responseDatamodel.MyNotesModel(
                "Notes Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",
                "15 Dec 2023"
            ),
            com.example.ddaatapp.model.responseDatamodel.MyNotesModel(
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

    private fun initObserver() {
        viewModel.allBlogResponse.observe(this, Observer {
            hideProgressDialog()
            if(it.success)
                setArticleAdapter(it.data)
            else
                showToast(it.message, Toast.LENGTH_SHORT)
        })

        viewModel.toastMsg.observe(this, EventObserver{
            hideProgressDialog()
            showToast(it, Toast.LENGTH_SHORT)
        })
    }

    private fun setArticleAdapter(articleList:List<BlogData>){
        val articleRecyclerView = binding.articleRecyclerView
        val articleAdapter = ArticleBlogAdapter(articleList,this,false, 6)
        articleRecyclerView.adapter = articleAdapter

//        Article item Decoration
        val articleSpacing = resources.getDimensionPixelSize(R.dimen._15dp)
        articleRecyclerView.addItemDecoration(HorizontalListSpacingItemDecoration(articleSpacing))
    }
}