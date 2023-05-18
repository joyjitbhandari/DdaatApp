package com.example.ddaatapp.activity.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ddaatapp.subscriptionScreen.HomeActivity
import com.example.ddaatapp.R
import com.example.ddaatapp.`object`.Constants
import com.example.ddaatapp.unsubscribeScreen.UnsubscribeHomeActivity

class ProfileCreatedActivity : AppCompatActivity() {

    private lateinit var operationFlow : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_created)

        operationFlow = intent.getStringExtra("operation").toString()

        val start = this.findViewById<Button>(R.id.btn_getStart)

        start.setOnClickListener{
            if(operationFlow == Constants.UNSUBSCRIBE){
                val intent = Intent(this, UnsubscribeHomeActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}