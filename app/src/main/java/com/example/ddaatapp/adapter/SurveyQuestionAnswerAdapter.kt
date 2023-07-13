package com.example.ddaatapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.superPower.SurveyQuestionAnswerActivity
import com.example.ddaatapp.databinding.SurveyQuestionItemsBinding
import com.example.ddaatapp.model.responseDatamodel.SurveyAnswerDataModel
import com.example.ddaatapp.model.responseDatamodel.SurveyQuestionDataModel

class SurveyQuestionAnswerAdapter(val questionList: ArrayList<com.example.ddaatapp.model.responseDatamodel.SurveyQuestionDataModel>) :
    RecyclerView.Adapter<SurveyQuestionAnswerAdapter.ViewHolder>() {
    class ViewHolder(var binding:SurveyQuestionItemsBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(surveyQuestionDataModel: com.example.ddaatapp.model.responseDatamodel.SurveyQuestionDataModel, position: Int){
            binding.questionKeyWord.text = surveyQuestionDataModel.keyword
            binding.questionSummery.text = surveyQuestionDataModel.desc



            binding.choiceAnswerGroup.setOnCheckedChangeListener { group, checkedId ->
                var answer = ""
                when(checkedId){
                    R.id.btnMost->{
                       answer = "Most"
                    }
                    R.id.btnLeast->{
                        answer = "Least"
                    }
                }
                SurveyQuestionAnswerActivity().answerList.add(
                    com.example.ddaatapp.model.responseDatamodel.SurveyAnswerDataModel(
                        surveyQuestionDataModel.keyword,
                        answer
                    )
                )
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SurveyQuestionItemsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return if(questionList.size>=3){
            3
        }else{
            questionList.size
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(questionList[position],position)
    }
}