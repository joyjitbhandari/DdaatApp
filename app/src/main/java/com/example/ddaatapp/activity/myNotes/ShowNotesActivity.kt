package com.example.ddaatapp.activity.myNotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ddaatapp.databinding.ActivityShowNotesBinding
import com.example.ddaatapp.datamodel.MyNotesModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ShowNotesActivity : AppCompatActivity() {
    private lateinit var binding : ActivityShowNotesBinding

    var note = ArrayList<MyNotesModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //getting data from My notes
        val noteTitle = intent.getStringExtra("Title")
        val noteContent = intent.getStringExtra("Content")
        val noteDate = intent.getStringExtra("Date")




        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}