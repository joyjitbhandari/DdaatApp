package com.example.ddaatapp.activity.superPower

import android.os.Bundle
import android.view.View
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.adapter.SurveyResultAdapter
import com.example.ddaatapp.databinding.ActivityMySuperPowerBinding
import com.example.ddaatapp.model.responseDatamodel.SurveyResultDataModel
import com.example.ddaatapp.utils.Utils.isSurveyDone

class SurveyResultActivity : BaseActivity() , View.OnClickListener {
    private lateinit var binding:ActivityMySuperPowerBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMySuperPowerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        isSurveyDone = true
        val resultList = arrayListOf<com.example.ddaatapp.model.responseDatamodel.SurveyResultDataModel>(
            com.example.ddaatapp.model.responseDatamodel.SurveyResultDataModel(
                50,
                "Results vs. Relationships",
                "Results focused and rationally takes quick action"
            ),
            com.example.ddaatapp.model.responseDatamodel.SurveyResultDataModel(
                96,
                "Daring vs. Careful",
                "Confidently takes risks and tolerant of losses "
            ),
            com.example.ddaatapp.model.responseDatamodel.SurveyResultDataModel(
                73,
                "Abstract vs. Concrete",
                "Works with known pathways forward"
            ),
            com.example.ddaatapp.model.responseDatamodel.SurveyResultDataModel(
                66,
                "Systematic vs. Flexible",
                "Able to balance completing tasks and responding on the spot"
            ),
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