package com.example.ddaatapp.activity.paymentAndBilling

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.adapter.AtmCardAdapter
import com.example.ddaatapp.adapter.AtmCardTransactionAdapter
import com.example.ddaatapp.utils.HorizontalListSpacingItemDecoration
import com.example.ddaatapp.utils.LinearListSpacingItemDecoration
import com.example.ddaatapp.databinding.ActivityPaymentAndBillingBinding
import com.example.ddaatapp.utils.Constants

class PaymentAndBillingActivity : BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPaymentAndBillingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentAndBillingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //card list
        val cardList = arrayListOf<com.example.ddaatapp.model.responseDatamodel.AtmCardDataModel>(
            com.example.ddaatapp.model.responseDatamodel.AtmCardDataModel(
                R.color.blue_bg,
                R.drawable.card_type,
                "**** **** **** 1293",
                "Anna Larsen",
                "06/25"
            ),
            com.example.ddaatapp.model.responseDatamodel.AtmCardDataModel(
                R.color.blue_bg,
                R.drawable.card_type,
                "**** **** **** 1293",
                "Anna Larsen",
                "06/25"
            ),
            com.example.ddaatapp.model.responseDatamodel.AtmCardDataModel(
                R.color.blue_bg,
                R.drawable.card_type,
                "**** **** **** 1293",
                "Anna Larsen",
                "06/25"
            )
        )
        //Setting adapter for card list
        val atmCardRecyclerView = binding.atmCardRecycler
        val cardAdapter = AtmCardAdapter(cardList,this)
        atmCardRecyclerView.adapter = cardAdapter
        //item spacing
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        atmCardRecyclerView.addItemDecoration(HorizontalListSpacingItemDecoration(spacing))


        //Transaction List
        val transList = arrayListOf<com.example.ddaatapp.model.responseDatamodel.AtmCardTransactionDataModel>(
            com.example.ddaatapp.model.responseDatamodel.AtmCardTransactionDataModel(
                R.drawable.review,
                "Subscription",
                "Subscription Renewal",
                "-$53.95",
                "July 14, 2022"
            ),
            com.example.ddaatapp.model.responseDatamodel.AtmCardTransactionDataModel(
                R.drawable.review,
                "Subscription",
                "Subscription Renewal",
                "-$53.95",
                "July 14, 2022"
            ),
            com.example.ddaatapp.model.responseDatamodel.AtmCardTransactionDataModel(
                R.drawable.review,
                "Subscription",
                "Subscription Renewal",
                "-$53.95",
                "July 14, 2022"
            ),
            com.example.ddaatapp.model.responseDatamodel.AtmCardTransactionDataModel(
                R.drawable.review,
                "Subscription",
                "Subscription Renewal",
                "-$53.95",
                "July 14, 2022"
            ),
            com.example.ddaatapp.model.responseDatamodel.AtmCardTransactionDataModel(
                R.drawable.review,
                "Subscription",
                "Subscription Renewal",
                "-$53.95",
                "July 14, 2022"
            ),
            com.example.ddaatapp.model.responseDatamodel.AtmCardTransactionDataModel(
                R.drawable.review,
                "Subscription",
                "Subscription Renewal",
                "-$53.95",
                "July 14, 2022"
            ),
            com.example.ddaatapp.model.responseDatamodel.AtmCardTransactionDataModel(
                R.drawable.review,
                "Subscription",
                "Subscription Renewal",
                "-$53.95",
                "July 14, 2022"
            ),
            com.example.ddaatapp.model.responseDatamodel.AtmCardTransactionDataModel(
                R.drawable.review,
                "Subscription",
                "Subscription Renewal",
                "-$53.95",
                "July 14, 2022"
            ),
            com.example.ddaatapp.model.responseDatamodel.AtmCardTransactionDataModel(
                R.drawable.review,
                "Subscription",
                "Subscription Renewal",
                "-$53.95",
                "July 14, 2022"
            ),
            com.example.ddaatapp.model.responseDatamodel.AtmCardTransactionDataModel(
                R.drawable.review,
                "Subscription",
                "Subscription Renewal",
                "-$53.95",
                "July 14, 2022"
            ),
        )
        //Adapter set
        val transactionView = binding.transHistoryRecycler
        val transAdapter = AtmCardTransactionAdapter(transList)
        transactionView.adapter = transAdapter
        //item spacing
        val transSpacing = resources.getDimensionPixelSize(R.dimen._15dp)
        atmCardRecyclerView.addItemDecoration(LinearListSpacingItemDecoration(transSpacing))


    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }
            binding.btnAddNew->{
                val operationFlow = Constants.ADD
                val intent = Intent(this, AddNewCardActivity::class.java)
                intent.putExtra("operation", operationFlow)
                startActivity(intent)
            }
        }
    }
}