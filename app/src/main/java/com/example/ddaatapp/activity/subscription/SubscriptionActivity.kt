package com.example.ddaatapp.activity.subscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.activity.signup.ProfileCreatedActivity
import com.example.ddaatapp.databinding.ActivitySubscriptionBinding

class SubscriptionActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var binding: ActivitySubscriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubscriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val subsList = ArrayList<SubscriptionModel>()
//
//
//
//     val listView  = binding.subsListView
//        listView.adapter = SubscriptionAdapter(this,subsList)

    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnSkip->{
                val intent = Intent(this, ProfileCreatedActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
            binding.c1BtnContinue->{
                val intent = Intent(this,BuySubscriptionActivity::class.java)
                startActivity(intent)
            }
            binding.btnBack->{
                onBackPressed()
            }
        }
    }

//    private fun showProfileCreatedDialog(){
//        val dialog =
//            Dialog(this, android.R.style.Theme_DeviceDefault_NoActionBar_Fullscreen)
//        dialog.setContentView(R.layout.activity_profile_created)
//        dialog.window?.apply {
//            setLayout(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.MATCH_PARENT
//            )
//            setGravity(Gravity.CENTER)
//            val getStarted=dialog.findViewById<Button>(R.id.btn_getStart)
//
//            getStarted.setOnClickListener {
//                val intent = Intent(dialog.context, HomeActivity::class.java)
//                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
//                startActivity(intent)
//                dialog.dismiss()
//            }
//            dialog.show()
//        }
//    }
}