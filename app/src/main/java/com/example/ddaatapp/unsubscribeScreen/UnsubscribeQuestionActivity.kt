package com.example.ddaatapp.unsubscribeScreen

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.notification.NotificationActivity
import com.example.ddaatapp.activity.showVideoContent.MyFavoriteActivity
import com.example.ddaatapp.adapter.FaqsAdapter
import com.example.ddaatapp.databinding.ActivityUnsubscribeQuestionBinding
import com.example.ddaatapp.utils.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton

class UnsubscribeQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding:ActivityUnsubscribeQuestionBinding

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnsubscribeQuestionBinding.inflate(layoutInflater)
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
        binding.bottomBar.selectedItemId  = R.id.nav_question
        binding.bottomBar.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_question -> return@OnNavigationItemSelectedListener true
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

        // FAQS List
        val faqsList = arrayListOf<com.example.ddaatapp.model.responseDatamodel.FaqsDataModel>(
            com.example.ddaatapp.model.responseDatamodel.FaqsDataModel(
                "Lorem Ipsum is simply ?",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."
            ),
            com.example.ddaatapp.model.responseDatamodel.FaqsDataModel(
                "Lorem Ipsum is simply ?",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."
            ),
            com.example.ddaatapp.model.responseDatamodel.FaqsDataModel(
                "Lorem Ipsum is simply ?",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."
            ),
            com.example.ddaatapp.model.responseDatamodel.FaqsDataModel(
                "Lorem Ipsum is simply ?",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."
            ),
            com.example.ddaatapp.model.responseDatamodel.FaqsDataModel(
                "Lorem Ipsum is simply ?",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."
            ),
            com.example.ddaatapp.model.responseDatamodel.FaqsDataModel(
                "Lorem Ipsum is simply ?",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."
            ),
            com.example.ddaatapp.model.responseDatamodel.FaqsDataModel(
                "Lorem Ipsum is simply ?",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard …."
            ),
        )
        //adapter
        val faqsRecyclerView = binding.faqsRecycler
        val adapter = FaqsAdapter(faqsList)
        faqsRecyclerView.adapter = adapter
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        faqsRecyclerView.addItemDecoration(LinearListSpacingItemDecoration(spacing))
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
            binding.btnSend->{
                showQuestionSentDialog()

            }
        }
    }

   private fun showQuestionSentDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_unsubscribe_question_send)

        dialog.window?.apply {
            setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setGravity(Gravity.CENTER)
            dialog.show()

            val buttonContinue= dialog.findViewById<Button>(R.id.btn_continue)

            buttonContinue.setOnClickListener {
                dialog.dismiss()
                binding.bottomBar.selectedItemId  = R.id.nav_home
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