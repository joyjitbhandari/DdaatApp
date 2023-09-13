package com.example.ddaatapp.activity.session

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.databinding.ActivityJoinSessionBinding

class JoinSessionActivity : BaseActivity() , View.OnClickListener {
    private lateinit var binding: ActivityJoinSessionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJoinSessionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }
            binding.btnJoinSession->{
                startActivity(Intent(this,WatingAreaActivity::class.java))
            }
        }
    }
}