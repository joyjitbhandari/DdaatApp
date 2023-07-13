package com.example.ddaatapp.activity.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.NotificationAdapter
import com.example.ddaatapp.utils.LinearListSpacingItemDecoration
import com.example.ddaatapp.databinding.ActivityNotificationBinding

class NotificationActivity : AppCompatActivity() {
    lateinit var binding: ActivityNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Recycler list view adapter set
        val notficationList = arrayListOf<com.example.ddaatapp.responseDatamodel.NotificationDataModel>(
            com.example.ddaatapp.responseDatamodel.NotificationDataModel(
                R.drawable.notify_img2,
                "Arnold Berry and 1 other posted on your talk page.",
                "10 min ago"
            ),
            com.example.ddaatapp.responseDatamodel.NotificationDataModel(
                R.drawable.notify_img1,
                "Arnold Berry and 1 other posted on your talk page.",
                "10 min ago"
            ),
            com.example.ddaatapp.responseDatamodel.NotificationDataModel(
                R.drawable.notify_img3,
                "Arnold Berry and 1 other posted on your talk page.",
                "10 min ago"
            ),
            com.example.ddaatapp.responseDatamodel.NotificationDataModel(
                R.drawable.notify_img4,
                "Arnold Berry and 1 other posted on your talk page.",
                "10 min ago"
            ),
            com.example.ddaatapp.responseDatamodel.NotificationDataModel(
                R.drawable.notify_img5,
                "Arnold Berry and 1 other posted on your talk page.",
                "10 min ago"
            ),
            com.example.ddaatapp.responseDatamodel.NotificationDataModel(
                R.drawable.notify_img1,
                "Arnold Berry and 1 other posted on your talk page.",
                "10 min ago"
            ),
            com.example.ddaatapp.responseDatamodel.NotificationDataModel(
                R.drawable.notify_img2,
                "Arnold Berry and 1 other posted on your talk page.",
                "10 min ago"
            ),
            com.example.ddaatapp.responseDatamodel.NotificationDataModel(
                R.drawable.notify_img2,
                "Arnold Berry and 1 other posted on your talk page.",
                "10 min ago"
            ),
            com.example.ddaatapp.responseDatamodel.NotificationDataModel(
                R.drawable.notify_img1,
                "Arnold Berry and 1 other posted on your talk page.",
                "10 min ago"
            ),
            com.example.ddaatapp.responseDatamodel.NotificationDataModel(
                R.drawable.notify_img3,
                "Arnold Berry and 1 other posted on your talk page.",
                "10 min ago"
            ),
            com.example.ddaatapp.responseDatamodel.NotificationDataModel(
                R.drawable.notify_img4,
                "Arnold Berry and 1 other posted on your talk page.",
                "10 min ago"
            ),
            com.example.ddaatapp.responseDatamodel.NotificationDataModel(
                R.drawable.notify_img5,
                "Arnold Berry and 1 other posted on your talk page.",
                "10 min ago"
            ),
            com.example.ddaatapp.responseDatamodel.NotificationDataModel(
                R.drawable.notify_img1,
                "Arnold Berry and 1 other posted on your talk page.",
                "10 min ago"
            ),
            com.example.ddaatapp.responseDatamodel.NotificationDataModel(
                R.drawable.notify_img2,
                "Arnold Berry and 1 other posted on your talk page.",
                "10 min ago"
            )
        )

        val notificationRecycler = binding.notificationRecycler
        val notifyAdapter = NotificationAdapter(notficationList)
        notificationRecycler.adapter = notifyAdapter
        //List item Decoration
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        notificationRecycler.addItemDecoration(LinearListSpacingItemDecoration(spacing))



//        Back button functionality
        binding.btnBack.setOnClickListener{
            onBackPressed()
        }


    }
}