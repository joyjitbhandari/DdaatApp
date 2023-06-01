package com.example.ddaatapp.activity.forgot

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.login.LoginActivity
import com.example.ddaatapp.commonClass.validateConfPass
import com.example.ddaatapp.databinding.ActivityChangePwdBinding
import com.example.ddaatapp.`object`.Constants
import com.example.ddaatapp.requestDatamodel.ChangePwdRequest
import com.example.ddaatapp.viewModel.UserViewModel

class ChangePwdActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityChangePwdBinding
    private lateinit var operationFlow: String
    private lateinit var viewModel : UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePwdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        operationFlow = intent.getStringExtra("operation").toString()
        if(operationFlow==Constants.UPDATE){
            binding.toolTitle.visibility = View.VISIBLE
            binding.changePwdTextCard.visibility = View.GONE
            binding.oldPasswordCard.visibility = View.VISIBLE
            binding.btnSetPwd.text = "Update"

        }

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnSetPwd->{
                when(operationFlow){
                    Constants.UPDATE-> {
                        if(doValidations(false)){
                            val oldPwd = binding.etOldPwd.text.toString()
                            val newPwd = binding.etNewPwd.text.toString()
                            val cnfPwd = binding.etCnfPwd.text.toString()

                            viewModel.changePwd(ChangePwdRequest(oldPwd ,newPwd,cnfPwd))
                            updateResponse()
                        }
                    }
                    Constants.FORGOT->{
                        if(doValidations(true)){
                            val newPwd = binding.etNewPwd.text.toString()
                            val cnfPwd = binding.etCnfPwd.text.toString()

//                            val sharedPref = getSharedPreferences(getString(R.string.Preference_file), MODE_PRIVATE)
//                            val oldPwd = sharedPref.getString("old_pwd", null).toString()
//                        Log.d("oldPwd", "$oldPwd ")

                                viewModel.changePwd(ChangePwdRequest("oldPwd" ,newPwd,cnfPwd))
                                changePwdResponse()
                        }else{
                            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
            binding.btnBack->{
                onBackPressed()
            }
        }
    }

    private fun doValidations(isForgotPwd:Boolean): Boolean {
        val oldPwd = binding.etOldPwd
        val newPwd = binding.etNewPwd
        val cnfPwd = binding.etCnfPwd

        val isOldPwdEmpty = oldPwd.text.toString().isEmpty()
        val isNewPwdEmpty = newPwd.text.toString().isEmpty()
        val isCnfPwdEmpty = cnfPwd.text.toString().isEmpty()

        newPwd.error = if (isForgotPwd && isNewPwdEmpty || (!isForgotPwd && isNewPwdEmpty)) "This Field Is Required" else null
        cnfPwd.error = if (isForgotPwd && isCnfPwdEmpty || (!isForgotPwd && isCnfPwdEmpty)) "This Field Is Required" else null
        cnfPwd.error = if(!isNewPwdEmpty && !isCnfPwdEmpty && !validateConfPass(newPwd.text.toString(),cnfPwd.text.toString())) "Password Did not match" else null
        oldPwd.error = if (!isForgotPwd && isOldPwdEmpty) "This Field Is Required" else null

        return if(isForgotPwd && !isNewPwdEmpty && !isCnfPwdEmpty && validateConfPass(newPwd.text.toString(),cnfPwd.text.toString())){
            true
        }else !isForgotPwd && !isOldPwdEmpty && !isNewPwdEmpty && !isCnfPwdEmpty && validateConfPass(newPwd.text.toString(),cnfPwd.text.toString())
    }


    private fun updateResponse(){
        viewModel.changePwdData.observe(this){changePwdData->
            val success = changePwdData?.success
            val message = changePwdData?.message
            Log.d("get", "updatePwdResponse: $success,$message")
            if(success == true){
                Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
                onBackPressed()
            }else{
                Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun changePwdResponse(){
        viewModel.changePwdData.observe(this){changePwdData->
            val success = changePwdData?.success
            val message = changePwdData?.message
            Log.d("get", "changePwdResponse: $success,$message")
            if(success == true){
                Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "$message", Toast.LENGTH_SHORT).show()
            }
        }

    }
}