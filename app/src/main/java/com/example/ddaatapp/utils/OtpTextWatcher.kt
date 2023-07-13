package com.example.ddaatapp.utils

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText


class OtpTextWatcher(private val currentView: View, private val nextView: View?) : TextWatcher {
    override fun afterTextChanged(s: Editable?) {}

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (count == 1 && nextView != null) {
            nextView.requestFocus()
        } else if (count == 0 && currentView is EditText) {
            val currentEditText = currentView as EditText
            if (currentEditText.text.isEmpty() && currentEditText.selectionStart == 0) {
                currentEditText.focusSearch(View.FOCUS_LEFT)?.requestFocus()
            }
        }
    }
}