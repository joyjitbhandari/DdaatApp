package com.example.ddaatapp.activity.superPower

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.ddaatapp.adapter.SurveyQuestionAnswerAdapter
import com.example.ddaatapp.databinding.ActivitySurveyQuestionAnswerBinding
import com.example.ddaatapp.responseDatamodel.SurveyAnswerDataModel
import com.example.ddaatapp.responseDatamodel.SurveyQuestionDataModel

class SurveyQuestionAnswerActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySurveyQuestionAnswerBinding

    val answerList =  ArrayList<SurveyAnswerDataModel>()

    lateinit var questionList : ArrayList<SurveyQuestionDataModel>

    private var totalQuestionsSize = 0
    private var newQuestionsSize  = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveyQuestionAnswerBinding.inflate(layoutInflater)
        setContentView(binding.root)

            questionList = arrayListOf<SurveyQuestionDataModel>(
                SurveyQuestionDataModel("Provides Support","Assists others, provides others with hope, courage, or confidence"),
                SurveyQuestionDataModel("Consistent Approach","Assists others, provides others with hope, courage, or confidence"),
                SurveyQuestionDataModel("Aspiring","Assists others, provides others with hope, courage, or confidence"),
                SurveyQuestionDataModel("Expresses Optimism","Assists others, provides others with hope, courage, or confidence"),
                SurveyQuestionDataModel("Self-reliant","Assists others, provides others with hope, courage, or confidence"),
                SurveyQuestionDataModel("Lively imagination","Assists others, provides others with hope, courage, or confidence"),
                SurveyQuestionDataModel("Confidently Faces Danger","Assists others, provides others with hope, courage, or confidence"),
                SurveyQuestionDataModel("Interactive","Assists others, provides others with hope, courage, or confidence"),
                SurveyQuestionDataModel("Self-assured","Assists others, provides others with hope, courage, or confidence"),
                SurveyQuestionDataModel("Attentive","Assists others, provides others with hope, courage, or confidence"),
                SurveyQuestionDataModel("Thinks Quickly","Assists others, provides others with hope, courage, or confidence"),
                SurveyQuestionDataModel("Follows routines","Assists others, provides others with hope, courage, or confidence"),
                SurveyQuestionDataModel("Solution driven","Assists others, provides others with hope, courage, or confidence"),
                SurveyQuestionDataModel("Accurate","Assists others, provides others with hope, courage, or confidence"),
                SurveyQuestionDataModel("Excitable","Assists others, provides others with hope, courage, or confidence"),
                SurveyQuestionDataModel("Attentive","Assists others, provides others with hope, courage, or confidence"),
                SurveyQuestionDataModel("Thinks Quickly","Assists others, provides others with hope, courage, or confidence"),
                SurveyQuestionDataModel("Follows routines","Assists others, provides others with hope, courage, or confidence"),
                SurveyQuestionDataModel("Solution driven","Assists others, provides others with hope, courage, or confidence"),
                SurveyQuestionDataModel("Accurate","Assists others, provides others with hope, courage, or confidence"),
        )
        //total list count
        totalQuestionsSize = questionList.size
        // first count
        newQuestionsSize = 3
        // set data to view
        setQuestionProgress()

        // setting questions to view
        questionSetToAdapter()
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressedDispatcher
            }
            binding.btnNext->{
                if(questionList.size <=3 ){
                    newQuestionsSize += questionList.size

                    setQuestionProgress()
                    val intent = Intent(this,SurveyResultActivity::class.java)
                    finish()
                    startActivity(intent)

                }else{
                    newQuestionsSize += 3
                    setQuestionProgress()
                    questionSetToAdapter()
                }
            }
        }
    }

   private fun questionSetToAdapter(){
       Log.d("array", "${questionList.size}")
       if(questionList.size>=3){
           val questionRecycler = binding.questionRecycler
           val adapter = SurveyQuestionAnswerAdapter(questionList)
           questionRecycler.adapter = adapter
           for(i in 0 until 3){
               questionList.removeAt(i)
           }
           Log.d("array", "${questionList.size}")
       }else{
           val questionRecycler = binding.questionRecycler
           val adapter = SurveyQuestionAnswerAdapter(questionList)
           questionRecycler.adapter = adapter
       }
    }


    private fun setQuestionProgress(){
        val percentage = ((newQuestionsSize ).toFloat() / totalQuestionsSize) * 100
        val formattedPercentage = "%.0f".format(percentage)
        binding.txtQuestionProgress.text = "$formattedPercentage%"
        binding.txtQuestionCount.text = "Question $newQuestionsSize/$totalQuestionsSize"

    }

}