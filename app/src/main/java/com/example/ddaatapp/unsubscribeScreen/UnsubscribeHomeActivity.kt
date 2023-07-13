package com.example.ddaatapp.unsubscribeScreen

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.blogs.AllBlogActivity
import com.example.ddaatapp.activity.notification.NotificationActivity
import com.example.ddaatapp.activity.showVideoContent.MyFavoriteActivity
import com.example.ddaatapp.adapter.ArticleBlogAdapter
import com.example.ddaatapp.utils.HorizontalListSpacingItemDecoration
import com.example.ddaatapp.utils.MyDrawerNavigationItemSelectedListener
import com.example.ddaatapp.utils.ShowDialog
import com.example.ddaatapp.databinding.ActivityUnsubscribeHomeBinding
import com.example.ddaatapp.fragment.*
import com.example.ddaatapp.utils.Constants
import com.example.ddaatapp.utils.SavedData.profileData
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton

class UnsubscribeHomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUnsubscribeHomeBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUnsubscribeHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Setting up drawer Menu
        drawerLayout = binding.drawerLayout
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayUseLogoEnabled(true)

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

        //navigation data set
        binding.navigationDrawerView.getHeaderView(0).findViewById<TextView>(R.id.nav_header_name).text = profileData.name
        binding.navigationDrawerView.getHeaderView(0).findViewById<TextView>(R.id.nav_header_email).text = profileData.email



        //bottom navigation view
        binding.bottomBar.selectedItemId = R.id.nav_home

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
                R.id.nav_home -> return@OnNavigationItemSelectedListener true

                R.id.nav_search -> {
                    startActivity(Intent(applicationContext, UnsubscribeSearchActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_chat -> {
                    startActivity(Intent(applicationContext, UnsubscribeChatActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        })



        //By default video fragment
       inflateFragment(HomeVideoLibraryFragment(Constants.UNSUBSCRIBE))


        // horizontal buttonView
        val chipGroup = binding.selectOneChipGroup
       chipGroup.setOnCheckedChangeListener { group, checkedId ->
           when(checkedId){
               R.id.btn_video_library ->{
                   inflateFragment(HomeVideoLibraryFragment(Constants.UNSUBSCRIBE))
               }
               R.id.btn_streams ->{
                   inflateFragment(HomeStreamsFragment(Constants.HOME))
               }
               R.id.btn_liveStream ->{
                   inflateFragment(UnsubscribeHomeLiveStreamingFragment(Constants.HOME))
               }
           }
        }

// for article view
        val articleList = arrayListOf<com.example.ddaatapp.model.responseDatamodel.ArticleDataModel>(
            com.example.ddaatapp.model.responseDatamodel.ArticleDataModel(
                R.drawable.article_bg_img,
                "Lorem Ipsum is simply dummy text",
                "Lorem Ipsum is simply dummy text of the printing and.....",
                "June 04, 2022",
                "Smith"
            ),
            com.example.ddaatapp.model.responseDatamodel.ArticleDataModel(
                R.drawable.article_bg_img,
                "Lorem Ipsum is simply dummy text",
                "Lorem Ipsum is simply dummy text of the printing and.....",
                "June 04, 2022",
                "Smith"
            ),
            com.example.ddaatapp.model.responseDatamodel.ArticleDataModel(
                R.drawable.article_bg_img,
                "Lorem Ipsum is simply dummy text",
                "Lorem Ipsum is simply dummy text of the printing and.....",
                "June 04, 2022",
                "Smith"
            ),
            com.example.ddaatapp.model.responseDatamodel.ArticleDataModel(
                R.drawable.article_bg_img,
                "Lorem Ipsum is simply dummy text",
                "Lorem Ipsum is simply dummy text of the printing and.....",
                "June 04, 2022",
                "Smith"
            )
        )
        val articleRecyclerView = binding.articleRecyclerView
//        val articleAdapter = ArticleBlogAdapter(articleList,this,false)
//        articleRecyclerView.adapter = articleAdapter

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