package com.example.ddaatapp.activity.subscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.activity.paymentAndBilling.PaymentAndBillingActivity
import com.example.ddaatapp.activity.signup.ProfileCreatedActivity
import com.example.ddaatapp.databinding.ActivityBuySubscriptionBinding
import com.example.ddaatapp.`object`.Constants

class BuySubscriptionActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding: ActivityBuySubscriptionBinding
    private lateinit var operationFlow : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuySubscriptionBinding.inflate(layoutInflater)
        setContentView( binding.root)

        operationFlow = intent.getStringExtra("operation").toString()

    }

    override fun onClick(view: View?) {
      when(view){
          binding.btnBack->{
              onBackPressed()
          }
          binding.btnPayment->{
              when(operationFlow){
                  Constants.SIGN_UP->{
                      val intent = Intent(this, ProfileCreatedActivity::class.java)
                      intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                      startActivity(intent)
                  }
                  Constants.SUBSCRIPTION->{
                      val intent = Intent(this, PaymentAndBillingActivity::class.java)
//                      intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                      startActivity(intent)
                  }
              }

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