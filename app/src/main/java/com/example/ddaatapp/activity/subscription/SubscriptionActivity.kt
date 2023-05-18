package com.example.ddaatapp.activity.subscription

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.signup.ProfileCreatedActivity
import com.example.ddaatapp.adapter.SubscriptionAdapter
import com.example.ddaatapp.commonClass.HorizontalListSpacingItemDecoration
import com.example.ddaatapp.databinding.ActivitySubscriptionBinding
import com.example.ddaatapp.datamodel.SubscriptionDataModel
import com.example.ddaatapp.`object`.Constants

class SubscriptionActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var binding: ActivitySubscriptionBinding

    private lateinit var operationFlow : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubscriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        operationFlow = intent.getStringExtra("operation").toString()


        //Card list setting
        val cardList = arrayListOf<SubscriptionDataModel>(
            SubscriptionDataModel(false,R.drawable.subs_card_shape_blue,R.drawable.img_subs_card,"Plan Name","On-demand videos subscription from","19.23","(interactive page with information)"),
            SubscriptionDataModel(false,R.drawable.subs_card_shape_grey,R.drawable.img_subs_card,"Plan Name","On-demand videos subscription from","19.23","(interactive page with information)"),
            SubscriptionDataModel(false,R.drawable.subs_card_shape_purple,R.drawable.img_subs_card,"Plan Name","On-demand videos subscription from","19.23","(interactive page with information)"),
            )

        val subscriptionRecyclerView = binding.subscriptionRecycler
        val adapter : SubscriptionAdapter

        if(operationFlow==Constants.SIGN_UP){
            binding.toolTitle.text = "Complete Profile"
            binding.btnSkip.visibility = View.VISIBLE
            adapter = SubscriptionAdapter(cardList,this,false)
        }else{
            binding.toolTitle.text = "Subscription"
            binding.btnSkip.visibility = View.GONE
            adapter = SubscriptionAdapter(cardList,this,true)
        }

        //adapter set for list
        subscriptionRecyclerView.adapter = adapter
        //MyNotes item Decoration
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        subscriptionRecyclerView.addItemDecoration(HorizontalListSpacingItemDecoration(spacing))

    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnSkip->{
                val operationFlow = Constants.UNSUBSCRIBE
                val intent = Intent(this, ProfileCreatedActivity::class.java)
                intent.putExtra("operation",operationFlow)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
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