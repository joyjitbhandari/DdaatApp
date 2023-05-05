package com.example.ddaatapp.subscriptionScreen

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.notification.NotificationActivity
import com.example.ddaatapp.adapter.ArticleBlogAdapter
import com.example.ddaatapp.adapter.MyNotesAdapter
import com.example.ddaatapp.commonClass.HorizontalSpacingItemDecoration
import com.example.ddaatapp.commonClass.MyDrawerNavigationItemSelectedListener
import com.example.ddaatapp.databinding.ActivityHomeBinding
import com.example.ddaatapp.databinding.DialogApplyFilterBinding
import com.example.ddaatapp.datamodel.ArticleDataModel
import com.example.ddaatapp.datamodel.MyNotesModel
import com.example.ddaatapp.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView


@Suppress("DEPRECATION")
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

        //binding.navigationDrawerView.setNavigationItemSelectedListener(this)

        //for navigation drawer item click listener

        val listener = MyDrawerNavigationItemSelectedListener(this)
        binding.navigationDrawerView.setNavigationItemSelectedListener(listener)


        val headerView: View =
            LayoutInflater.from(this).inflate(R.layout.nav_header, drawerLayout, false)
        val cancelButton = headerView.findViewById<Button>(R.id.btn_drawer_cancel)
        cancelButton.setOnClickListener{
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
        myNotesRecyclerView.addItemDecoration(HorizontalSpacingItemDecoration(noteSpacing))



        //By default video fragment
       inflateFragment(HomeVideoLibraryFragment.newInstance())



        // horizontal buttonView
        val chipGroup = binding.selectOneChipGroup
       chipGroup.setOnCheckedChangeListener { group, checkedId ->
           when(checkedId){
               R.id.btn_video_library ->{
                   inflateFragment(HomeVideoLibraryFragment.newInstance())
               }
               R.id.btn_streams ->{
                   inflateFragment(HomeStreamsFragment.newInstance())

               }
               R.id.btn_up_sessions ->{
                   inflateFragment(HomeSessionsFragment.newInstance())

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
        val articleAdapter = ArticleBlogAdapter(articleList)
        articleRecyclerView.adapter = articleAdapter

        //Article item Decoration
        val articleSpacing = resources.getDimensionPixelSize(R.dimen._15dp)
        articleRecyclerView.addItemDecoration(HorizontalSpacingItemDecoration(articleSpacing))


}


    private fun inflateFragment(newInstance: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.list_item_frame, newInstance)
        transaction.commit()
    }


    private fun showHelpDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_help_box)

        dialog.window?.apply {
            setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setGravity(Gravity.CENTER)
            dialog.show()

            val cancel = dialog.findViewById<Button>(R.id.btn_cancel)

            cancel.setOnClickListener {
                dialog.dismiss()
            }
        }
    }



    private fun showFilterDialog() {
        val dialog = Dialog(this)
        val dialogBinding = DialogApplyFilterBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)

        dialog.window?.apply {
            setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setGravity(Gravity.CENTER)
            dialog.show()

            val cancel = dialog.findViewById<Button>(R.id.btn_cancel)

            cancel.setOnClickListener {
                dialog.dismiss()
            }
        }
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnHelp->{
                showHelpDialog()
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
                showFilterDialog()
            }

            binding.btnMotivationCancel->{
                binding.motivationCard.visibility = View.GONE
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