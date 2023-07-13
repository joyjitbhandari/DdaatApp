package com.example.ddaatapp.activity.forgot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.ddaatapp.activity.login.LoginActivity
import com.example.ddaatapp.databinding.ActivityChangePwdBinding
import com.example.ddaatapp.network.RetrofitClient
import com.example.ddaatapp.`object`.Constants
import com.example.ddaatapp.`object`.Constants.FORGOT
import com.example.ddaatapp.`object`.Constants.UPDATE
import com.example.ddaatapp.requestDatamodel.ChangePwdRequest
import com.example.ddaatapp.utils.*
import com.example.ddaatapp.viewModel.PasswordViewModel
import com.example.ddaatapp.viewModel.ViewModelFactory
import com.flynaut.healthtag.util.EventObserver

class ChangePwdActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityChangePwdBinding
    private lateinit var operationFlow: String
    private lateinit var viewModel : PasswordViewModel



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

        viewModel = ViewModelProvider(this,ViewModelFactory(RetrofitClient().apiService))[PasswordViewModel::class.java]

        initObserver(operationFlow)
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnSetPwd->{

                when(operationFlow){
                    UPDATE-> {
                        if(doValidations(false)){
                            val oldPwd = binding.etOldPwd.text.toString().trim()
                            val newPwd = binding.etNewPwd.text.toString().trim()
                            val cnfPwd = binding.etCnfPwd.text.toString().trim()
                            showProgressDialog(this)
                            viewModel.changePwd(ChangePwdRequest(oldPwd ,newPwd,cnfPwd))
                        }
                    }
                    FORGOT->{
                        if(doValidations(true)){
                            val newPwd = binding.etNewPwd.text.toString().trim()
                            val cPwd = binding.etCnfPwd.text.toString().trim()
                            showProgressDialog(this)
                            viewModel.changePwd(ChangePwdRequest("",newPwd,cPwd))
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

    private fun initObserver(operationFlow: String) {
        hideProgressDialog()
        viewModel.baseResponse.observe(this){
            if(operationFlow == FORGOT){
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            }else{
                onBackPressed()
            }
            this.showToast(it?.message.toString())
        }

        viewModel.toastMsg.observe(this, EventObserver {
            hideProgressDialog()
            this.showToast( it, Toast.LENGTH_SHORT)
        })
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
}