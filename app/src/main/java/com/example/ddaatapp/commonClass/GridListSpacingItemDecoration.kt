package com.example.ddaatapp.commonClass

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridListSpacingItemDecoration(
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

        // for other item
        outRect.top = spacing

        // If it's the first item, don't add top spacing
        if (position == 0 || position == 1) {
            outRect.top = 70
        }
        // If it's the last item, don't add bottom spacing
        if (position == itemCount - 1 || position == itemCount - 2) {
            outRect.top = spacing
            outRect.bottom = 70
        }
    }


}