package com.example.ddaatapp.commonClass

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import com.example.ddaatapp.R
import com.example.ddaatapp.databinding.DialogApplyFilterBinding
import com.example.ddaatapp.databinding.DialogSelectGenresBinding

class ShowDialog(var context: Context) {

    //Filter dialog
    fun showFilterDialog() {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.dialog_apply_filter)

        dialog.window?.apply {
            setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setGravity(Gravity.CENTER)
            dialog.show()

            val cancel = dialog.findViewById<Button>(R.id.btn_cancel)

            cancel.setOnClickListener {
                dialog.dismiss()
            }
        }
    }


    //Select Genres
    fun showSelectGenresDialog() {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.dialog_select_genres)

        dialog.window?.apply {
            setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setGravity(Gravity.CENTER)
            dialog.show()

            val cancel = dialog.findViewById<Button>(R.id.btn_cancel)
            cancel.setOnClickListener {
                dialog.dismiss()
            }
        }
    }


//Help Dialog

    fun showHelpDialog() {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.dialog_help_box)

        dialog.window?.apply {
            setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setGravity(Gravity.CENTER)
            dialog.show()

            val cancel = dialog.findViewById<Button>(R.id.btn_cancel)
            cancel.setOnClickListener {
                dialog.dismiss()
            }
        }
    }

    //Write Note Dialog

    fun showWriteNoteDialog() {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.dialog_write_note)

        dialog.window?.apply {
            setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setGravity(Gravity.CENTER)
            dialog.show()

            val cancel = dialog.findViewById<Button>(R.id.btn_cancel)
            cancel.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}