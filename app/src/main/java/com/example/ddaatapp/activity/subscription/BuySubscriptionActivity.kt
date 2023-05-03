package com.example.ddaatapp.activity.subscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.activity.signup.ProfileCreatedActivity
import com.example.ddaatapp.databinding.ActivityBuySubscriptionBinding

class BuySubscriptionActivity : AppCompatActivity() , View.OnClickListener {
    lateinit var binding: ActivityBuySubscriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuySubscriptionBinding.inflate(layoutInflater)
        setContentView( binding.root)

    }

    override fun onClick(view: View?) {
      when(view){
          binding.btnBack->{
              onBackPressed()
          }
          binding.btnPayment->{
              val intent = Intent(this, ProfileCreatedActivity::class.java)
              intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
              startActivity(intent)
          }
      }
    }

//    private fun showProfileCreatedDialog(){
//        val dialog =
//            Dialog(this, R.style.Theme_DeviceDefault_NoActionBar_Fullscreen)
//        dialog.setContentView(com.example.ddaatapp.R.layout.activity_profile_created)
//        dialog.window?.apply {
//            setLayout(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.MATCH_PARENT
//            )
//            setGravity(Gravity.CENTER)
//            val getStarted=dialog.findViewById<Button>(com.example.ddaatapp.R.id.btn_getStart)
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