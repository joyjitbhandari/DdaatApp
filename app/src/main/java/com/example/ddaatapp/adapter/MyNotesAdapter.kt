package com.example.ddaatapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.activity.myNotes.ShowNotesActivity
import com.example.ddaatapp.databinding.MyNotesItemBinding
import com.example.ddaatapp.responseDatamodel.MyNotesModel

class MyNotesAdapter(val noteList: ArrayList<com.example.ddaatapp.responseDatamodel.MyNotesModel>, var fromActivity:Boolean, var context: Context) :
    RecyclerView.Adapter<MyNotesAdapter.ViewHolder>() {

    class ViewHolder(var binding:MyNotesItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(notesModel: com.example.ddaatapp.responseDatamodel.MyNotesModel, fromActivity: Boolean, mContext:AppCompatActivity, context: Context){

            if(fromActivity){
                binding.myNotesCardItem.visibility = View.GONE
                binding.myNotesActivityItem.visibility = View.VISIBLE
                binding.txtNoteTitleItem2.text = notesModel.title
                binding.txtNoteContentItem2.text = notesModel.content
                binding.txtDateItem2.text = notesModel.date

            }else{
                binding.myNotesCardItem.visibility = View.VISIBLE
                binding.myNotesActivityItem.visibility = View.GONE
                binding.txtNoteTitle.text = notesModel.title
                binding.txtNoteContent.text = notesModel.content
                binding.txtDate.text = notesModel.date
            }

            binding.myNotesCardItem.setOnClickListener {
                val intent = Intent(context,ShowNotesActivity::class.java)
                intent.putExtra("Title", notesModel.title)
                intent.putExtra("Content", notesModel.content)
                intent.putExtra("Date", notesModel.date)
                mContext.startActivity(intent)
            }

            binding.myNotesActivityItem.setOnClickListener {
                val intent = Intent(context,ShowNotesActivity::class.java)
                intent.putExtra("Title", notesModel.title)
                intent.putExtra("Content", notesModel.content)
                intent.putExtra("Date", notesModel.date)
                mContext.startActivity(intent)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MyNotesItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(noteList[position], fromActivity, context as AppCompatActivity, context )

    }
}