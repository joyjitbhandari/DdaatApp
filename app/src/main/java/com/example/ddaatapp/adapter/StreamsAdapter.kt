package com.example.ddaatapp.adapter

import android.content.Context
import android.content.Intent
import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.R
import com.example.ddaatapp.activity.playStreamAudio.StreamAudioPlayActivity
import com.example.ddaatapp.databinding.VideoLibraryListItemBinding
import com.example.ddaatapp.datamodel.StreamsDataModel
import com.example.ddaatapp.datamodel.VideoLibraryDataModel
import com.example.ddaatapp.`object`.Constants

class StreamsAdapter(val videoList: ArrayList<StreamsDataModel>, private val itemCount:Int, var isPodcast:Boolean, var context: Context) :
    RecyclerView.Adapter<StreamsAdapter.ViewHolder>() {
    class ViewHolder(var binding:VideoLibraryListItemBinding ): RecyclerView.ViewHolder(binding.root) {
        fun bind(streamsDataModel: StreamsDataModel, mContext: AppCompatActivity, context: Context, isPodcast: Boolean){
            binding.videoImage.setImageResource(streamsDataModel.drawable)
            binding.txtVideoName.text = streamsDataModel.name
            binding.txtVideoDesc.text = streamsDataModel.desc


          if(isPodcast){
              binding.root.setOnClickListener {
                  val operationFlow = Constants.PODCAST
                  val intent = Intent(context, StreamAudioPlayActivity::class.java)
                  intent.putExtra("operation", operationFlow)
                  mContext.startActivity(intent)
              }
          }else{
              binding.root.setOnClickListener {
                  val operationFlow = Constants.STREAM
                  val intent = Intent(context, StreamAudioPlayActivity::class.java)
                  intent.putExtra("operation", operationFlow)
                  mContext.startActivity(intent)
              }
          }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            VideoLibraryListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {

      return itemCount
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(videoList[position], context as AppCompatActivity, context, isPodcast)
    }
}