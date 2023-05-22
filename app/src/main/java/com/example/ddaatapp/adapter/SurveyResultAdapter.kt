package com.example.ddaatapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.databinding.SurveyResultItemBinding
import com.example.ddaatapp.responseDatamodel.SurveyResultDataModel

class SurveyResultAdapter(val resultList: ArrayList<SurveyResultDataModel>) :
    RecyclerView.Adapter<SurveyResultAdapter.ViewHolder>() {
    class ViewHolder(var binding:SurveyResultItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(surveyResultDataModel: SurveyResultDataModel){

            binding.progress.progress = surveyResultDataModel.score
            binding.score.text = surveyResultDataModel.score.toString()
            binding.resultHeading.text = surveyResultDataModel.resulKey
            binding.resultBody.text = surveyResultDataModel.restDesc

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            SurveyResultItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {

      return resultList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(resultList[position])
    }
}