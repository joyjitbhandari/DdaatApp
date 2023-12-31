package com.example.ddaatapp.activity.showVideoContent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ddaatapp.R
import com.example.ddaatapp.adapter.MyFavoriteAdapter
import com.example.ddaatapp.utils.LinearListSpacingItemDecoration
import com.example.ddaatapp.utils.ShowDialog
import com.example.ddaatapp.databinding.ActivityMyFavoriteBinding

class MyFavoriteActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding: ActivityMyFavoriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding LogInData to recycler list view
        val watchList = arrayListOf<com.example.ddaatapp.model.responseDatamodel.VideoLibraryDataModel>(
            com.example.ddaatapp.model.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image2,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image3,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image3,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
            com.example.ddaatapp.model.responseDatamodel.VideoLibraryDataModel(
                R.drawable.video_sample_image,
                "Video Name",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been"
            ),
        )

        val myfavoriteRecyclerView= binding.myFavoriteRecycler
        val adapter = MyFavoriteAdapter(watchList,this)
        myfavoriteRecyclerView.adapter = adapter
        //List item Decoration
        val spacing = resources.getDimensionPixelSize(R.dimen._15dp)
        myfavoriteRecyclerView.addItemDecoration(LinearListSpacingItemDecoration(spacing))
    }

    override fun onClick(view: View?) {
        when(view){
            binding.btnBack->{
                onBackPressed()
            }
            binding.btnFilter->{
                ShowDialog(this).showFilterDialog()
            }
        }
    }
}