package com.example.ddaatapp.activity.paymentAndBilling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.enableSavedStateHandles
import com.example.ddaatapp.databinding.ActivityAddNewCardBinding
import com.example.ddaatapp.utils.Constants

class AddNewCardActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding:ActivityAddNewCardBinding
    private lateinit var operationFlow: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        operationFlow = intent.getStringExtra("operation").toString()
        when(operationFlow){
            Constants.ADD->{
                binding.toolTitle.text = "Add New Card"
            }
            Constants.EDIT->{
                binding.toolTitle.text = "Edit Card"
            }
        }
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }
            binding.btnSaveCard->{
                finish()
            }
        }
    }
}