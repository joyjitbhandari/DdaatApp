package com.example.ddaatapp.adapter

import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ddaatapp.databinding.MyNotesItemBinding
import com.example.ddaatapp.datamodel.MyNotesModel

class MyNotesAdapter(val noteList: ArrayList<MyNotesModel>) :
    RecyclerView.Adapter<MyNotesAdapter.ViewHolder>() {
    class ViewHolder(var binding:MyNotesItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(notesModel: MyNotesModel){

            binding.txtNoteTitle.text = notesModel.title
            binding.txtNoteContent.text = notesModel.content
            binding.txtDate.text = notesModel.date
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
        holder.bind(noteList[position])
    }
}