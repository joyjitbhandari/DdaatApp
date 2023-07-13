package com.example.ddaatapp.unsubscribeScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.notification.NotificationActivity
import com.example.ddaatapp.activity.showVideoContent.MyFavoriteActivity
import com.example.ddaatapp.adapter.UnsubscribeChatListAdapter
import com.example.ddaatapp.utils.LinearListSpacingItemDecoration
import com.example.ddaatapp.utils.MyDrawerNavigationItemSelectedListener
import com.example.ddaatapp.utils.ShowDialog
import com.example.ddaatapp.databinding.ActivityUnsubscribeChatBinding
import com.example.ddaatapp.utils.SavedData
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton

class UnsubscribeChatActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityUnsubscribeChatBinding

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnsubscribeChatBinding.inflate(layoutInflater)
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
        //navigation data set
        binding.navigationDrawerView.getHeaderView(0).findViewById<TextView>(R.id.nav_header_name).text = SavedData.profileData.name
        binding.navigationDrawerView.getHeaderView(0).findViewById<TextView>(R.id.nav_header_email).text = SavedData.profileData.email

        // Bottom nav bar
        binding.bottomBar.selectedItemId  = R.id.nav_chat
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

                R.id.nav_search -> {
                    startActivity(Intent(applicationContext, UnsubscribeSearchActivity::class.java))
                    finish()
                    overridePendingTransition(0, 0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_chat -> return@OnNavigationItemSelectedListener true
            }
            false
        })


        //Chat list Setup
        val chatList = arrayListOf<com.example.ddaatapp.model.responseDatamodel.UnsubscribeChatListDataModel>(
            com.example.ddaatapp.model.responseDatamodel.UnsubscribeChatListDataModel(
                R.drawable.notify_img4,
                "Ellie Olsen",
                "Hey there! What's up? is everything fine..?",
                "10:56 AM"
            ),
            com.example.ddaatapp.model.responseDatamodel.UnsubscribeChatListDataModel(
                R.drawable.notify_img5,
                "Ellie Olsen",
                "Hey there! What's up? is everything fine..?",
                "10:56 AM"
            ),
            com.example.ddaatapp.model.responseDatamodel.UnsubscribeChatListDataModel(
                R.drawable.notify_img4,
                "Ellie Olsen",
                "Hey there! What's up? is everything fine..?",
                "10:56 AM"
            ),
            com.example.ddaatapp.model.responseDatamodel.UnsubscribeChatListDataModel(
                R.drawable.notify_img4,
                "Ellie Olsen",
                "Hey there! What's up? is everything fine..?",
                "10:56 AM"
            ),
            com.example.ddaatapp.model.responseDatamodel.UnsubscribeChatListDataModel(
                R.drawable.notify_img4,
                "Ellie Olsen",
                "Hey there! What's up? is everything fine..?",
                "10:56 AM"
            ),
            com.example.ddaatapp.model.responseDatamodel.UnsubscribeChatListDataModel(
                R.drawable.notify_img5,
                "Ellie Olsen",
                "Hey there! What's up? is everything fine..?",
                "10:56 AM"
            ),
            com.example.ddaatapp.model.responseDatamodel.UnsubscribeChatListDataModel(
                R.drawable.notify_img4,
                "Ellie Olsen",
                "Hey there! What's up? is everything fine..?",
                "10:56 AM"
            ),
        )
        val chatListRecyclerView = binding.chatListRecycler
        chatListRecyclerView.adapter = UnsubscribeChatListAdapter(chatList,this)
        //List item Decoration
        val podcastSpacing = resources.getDimensionPixelSize(R.dimen._15dp)
        chatListRecyclerView.addItemDecoration(LinearListSpacingItemDecoration(podcastSpacing))
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