package com.example.ddaatapp.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HorizontalListSpacingItemDecoration(
    private val spacing: Int,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        val itemCount = state.itemCount

        // Add equal spacing to top, bottom, left and right of each item
        outRect.left = spacing

        // If it's the first item, don't add top spacing
        if (position == 0) {
            outRect.left = 60
        }

        // If it's the last item, don't add bottom spacing
        if (position == itemCount - 1) {
            outRect.left = spacing
            outRect.right = 60
        }
    }


}