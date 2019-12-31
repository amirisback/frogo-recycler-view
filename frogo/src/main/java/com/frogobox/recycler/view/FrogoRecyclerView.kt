package com.frogobox.recycler.view

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.*


/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * frogo-recycler-view-adapter
 * Copyright (C) 30/12/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogoviewadapter.view
 *
 */
class FrogoRecyclerView : RecyclerView, FrogoView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun isViewLinearVertical(dividerItem: Boolean) {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        if (dividerItem) {
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }
    }

    override fun isViewLinearHorizontal(dividerItem: Boolean) {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        if (dividerItem) {
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.HORIZONTAL))
        }
    }

    override fun isViewStaggeredGrid(spanCount: Int) {
        layoutManager = StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL)
    }

    override fun isViewGrid(spanCount: Int) {
        layoutManager = GridLayoutManager(context, spanCount)
    }

}