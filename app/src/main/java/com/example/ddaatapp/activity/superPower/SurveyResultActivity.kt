package com.example.ddaatapp.activity.superPower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.adapter.SurveyResultAdapter
import com.example.ddaatapp.databinding.ActivityMySuperPowerBinding
import com.example.ddaatapp.datamodel.SurveyResultDataModel

class SurveyResultActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding:ActivityMySuperPowerBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMySuperPowerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val resultList = arrayListOf<SurveyResultDataModel>(
            SurveyResultDataModel(50,"Results vs. Relationships","Results focused and rationally takes quick action"),
            SurveyResultDataModel(96,"Daring vs. Careful","Confidently takes risks and tolerant of losses "),
            SurveyResultDataModel(73,"Abstract vs. Concrete","Works with known pathways forward"),
            SurveyResultDataModel(66,"Systematic vs. Flexible","Able to balance completing tasks and responding on the spot"),
        )

        val resultRecyclerView = binding.resultRecycler
        val adapter = SurveyResultAdapter(resultList)
        resultRecyclerView.adapter = adapter
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }
            binding.btnDone->{
               finish()
            }
        }

    }
}