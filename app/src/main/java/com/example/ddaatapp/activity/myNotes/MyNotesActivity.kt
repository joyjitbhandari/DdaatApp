package com.example.ddaatapp.activity.myNotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ddaatapp.activity.BaseActivity
import com.example.ddaatapp.adapter.MyNotesAdapter
import com.example.ddaatapp.databinding.ActivityMyNotesBinding
import com.example.ddaatapp.model.responseDatamodel.MyNotesModel

class MyNotesActivity : BaseActivity() {
    private lateinit var binding: ActivityMyNotesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val noteList = arrayListOf<com.example.ddaatapp.model.responseDatamodel.MyNotesModel>(
            com.example.ddaatapp.model.responseDatamodel.MyNotesModel(
                "Notes Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",
                "15 Dec 2023"
            ),
            com.example.ddaatapp.model.responseDatamodel.MyNotesModel(
                "Notes Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",
                "15 Dec 2023"
            ),
            com.example.ddaatapp.model.responseDatamodel.MyNotesModel(
                "Notes Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",
                "15 Dec 2023"
            ),
            com.example.ddaatapp.model.responseDatamodel.MyNotesModel(
                "Notes Title",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",
                "15 Dec 2023"
            )
        )

        //setting up the list view adapter
        val myNotesRecycler = binding.myNotesRecyclerView
        val myNotesAdapter = MyNotesAdapter(noteList,true,this)
        myNotesRecycler.adapter = myNotesAdapter

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

    }
}