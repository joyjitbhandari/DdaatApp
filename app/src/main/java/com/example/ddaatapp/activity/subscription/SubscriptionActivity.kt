package com.example.ddaatapp.activity.subscription

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.activity.signup.ProfileCreatedActivity
import com.example.ddaatapp.adapter.SubscriptionAdapter
import com.example.ddaatapp.utils.HorizontalListSpacingItemDecoration
import com.example.ddaatapp.databinding.ActivitySubscriptionBinding
import com.example.ddaatapp.model.responseDatamodel.SubscriptionData
import com.example.ddaatapp.network.RetrofitClient
import com.example.ddaatapp.utils.Constants
import com.example.ddaatapp.utils.Constants.SIGN_UP
import com.example.ddaatapp.utils.showToast
import com.example.ddaatapp.viewModel.SubscriptionViewModel
import com.example.ddaatapp.viewModel.ViewModelFactory
import com.flynaut.healthtag.util.EventObserver

class SubscriptionActivity : BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySubscriptionBinding

    private lateinit var operationFlow : String
    private lateinit var viewModel : SubscriptionViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubscriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        operationFlow = intent.getStringExtra("operation").toString()

        viewModel = ViewModelProvider(this,ViewModelFactory(RetrofitClient().apiService))[SubscriptionViewModel::class.java]

        showProgressDialog()
        initObserve()
        viewModel.getSubscriptionList()


//        //Card list setting
//        val cardList = arrayListOf(
//           SubscriptionDataModel(
//                false,
//                R.drawable.subs_card_shape_blue,
//                R.drawable.img_subs_card,
//                "Plan Name",
//                "On-demand videos subscription from",
//                "19.23",
//                "(interactive page with information)"
//            ),
//            SubscriptionDataModel(
//                false,
//                R.drawable.subs_card_shape_grey,
//                R.drawable.img_subs_card,
//                "Plan Name",
//                "On-demand videos subscription from",
//                "19.23",
//                "(interactive page with information)"
//            ),
//            com.example.ddaatapp.model.responseDatamodel.SubscriptionDataModel(
//                false,
//                R.drawable.subs_card_shape_purple,
//                R.drawable.img_subs_card,
//                "Plan Name",
//                "On-demand videos subscription from",
//                "19.23",
//                "(interactive page with information)"
//            ),
//            )


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

    private fun initObserve(){
        viewModel.apiResponse.observe(this, Observer {
            hideProgressDialog()
            if(it.success)
                adapterDataSet(it.data)
            else
                showToast(it.message, Toast.LENGTH_SHORT)
        })

        viewModel.toastMsg.observe(this,EventObserver{
            hideProgressDialog()
            showToast(it, Toast.LENGTH_SHORT)
        })

    }

    private fun adapterDataSet(cardList:List<SubscriptionData>){
        val subscriptionRecyclerView = binding.subscriptionRecycler
        val adapter : SubscriptionAdapter

        if(operationFlow == SIGN_UP){
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

        //item Decoration
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        subscriptionRecyclerView.addItemDecoration(HorizontalListSpacingItemDecoration(spacing))
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