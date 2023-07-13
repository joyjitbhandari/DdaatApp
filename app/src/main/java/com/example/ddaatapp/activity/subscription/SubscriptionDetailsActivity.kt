package com.example.ddaatapp.activity.subscription

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
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.activity.signup.ProfileCreatedActivity
import com.example.ddaatapp.databinding.ActivitySubscriptionDetailsBinding

class SubscriptionDetailsActivity : BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySubscriptionDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubscriptionDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.btnBack -> {
                onBackPressed()
            }
            binding.btnUnsubscribe -> {
                showUnsubscribeAlertDialog()
            }

        }
    }

    private fun showUnsubscribeAlertDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_unsubscribe_alert)

        dialog.window?.apply {
            setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setGravity(Gravity.CENTER)
            dialog.show()

            val yes = dialog.findViewById<Button>(R.id.btnYes)
            val cancel = dialog.findViewById<Button>(R.id.btnCancel)

            yes.setOnClickListener {
                    //Other operation
            }

            cancel.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}