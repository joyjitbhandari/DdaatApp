package com.example.ddaatapp.commonClass

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import com.example.ddaatapp.R
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ddaatapp.activity.myNotes.MyNotesActivity
import com.example.ddaatapp.activity.aboutDdaat.AboutActivity
import com.example.ddaatapp.activity.feedback.FeedBackActivity
import com.example.ddaatapp.activity.forgot.ChangePwdActivity
import com.example.ddaatapp.activity.myPurchase.MyPurchasedActivity
import com.example.ddaatapp.activity.paymentAndBilling.PaymentAndBillingActivity
import com.example.ddaatapp.activity.profile.MyProfileActivity
import com.example.ddaatapp.activity.reviewAndRating.ReviewAndRatingActivity
import com.example.ddaatapp.activity.subscription.SubscriptionActivity
import com.example.ddaatapp.activity.superPower.SurveyResultActivity
import com.google.android.material.navigation.NavigationView


class MyDrawerNavigationItemSelectedListener(var context: Context) : NavigationView.OnNavigationItemSelectedListener {

    private var mContext = (context as AppCompatActivity)
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here
        val id: Int = item.getItemId()

        when(id){
            R.id.drawerProfile ->{
                mContext.startActivity(Intent(context,MyProfileActivity::class.java))
                return true
            }
            R.id.drawerSubscription ->{
                mContext.startActivity(Intent(context,SubscriptionActivity::class.java))
                return true
            }
            R.id.drawerMyNotes ->{
                mContext.startActivity(Intent(context, MyNotesActivity::class.java))
                return true
            }
            R.id.drawerMySuperpower->{
                mContext.startActivity(Intent(context, SurveyResultActivity::class.java))
                return true
            }
            R.id.drawerMyPurchases->{
                mContext.startActivity(Intent(context, MyPurchasedActivity::class.java))
                return true
            }
            R.id.drawerReview->{
                mContext.startActivity(Intent(context, ReviewAndRatingActivity::class.java))
                return true
            }
            R.id.drawerPayment->{
                mContext.startActivity(Intent(context, PaymentAndBillingActivity::class.java))
                return true
            }
            R.id.drawerChangePwd ->{
                val operationFlow = "UPDATE"
                val intent = Intent(context, ChangePwdActivity::class.java)
                intent.putExtra("operation",operationFlow)
                mContext.startActivity(intent)
                return true
            }
            R.id.drawerFeedback->{
                mContext.startActivity(Intent(context, FeedBackActivity::class.java))
                return true
            }
            R.id.drawerAbout->{
                mContext.startActivity(Intent(context, AboutActivity::class.java))
                return true
            }
            R.id.drawerLogOut->{
                showLogOutDialog()
                return true
            }
        }
        return false
    }

    private fun showLogOutDialog() {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.dialog_log_out)

        dialog.window?.apply {
            setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setGravity(Gravity.CENTER)
            dialog.show()

            val logOut = dialog.findViewById<Button>(R.id.btnLogOut)
            val logOutCancel = dialog.findViewById<Button>(R.id.btnLogOutCancel)

            logOut.setOnClickListener {
                mContext.finish()
            }

            logOutCancel.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}
