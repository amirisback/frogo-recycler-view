package com.frogobox.recycler.widget

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.frogobox.recycler.R
import kotlinx.android.synthetic.main.widget_frogo_shimmer_recyclerview.view.*

/*
 * Created by Faisal Amir on 17/02/2021
 * FrogoRecyclerView Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
class FrogoProgressRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
)  : RelativeLayout(context, attrs, defStyle, defStyleRes) {

    init {
        setupViewEditor()
        setupAttribute(attrs)
    }

    private fun setupViewEditor() {
        LayoutInflater.from(context).inflate(R.layout.widget_frogo_progress_recyclerview, this, true)
    }

    private fun setupAttribute(attrs: AttributeSet?) {
        attrs?.let {
            val typedArray =
                context?.obtainStyledAttributes(it, R.styleable.frogo_shimmer_recycler_view, 0, 0)

            // setup inner component
            typedArray?.let { it1 -> setupComponentView(it1, widget_fsrv_recyclerview) }
            typedArray?.let { it1 -> setupComponentView(it1, widget_fsrv_shimmer_recyclerview) }

            typedArray?.recycle()
        }
    }

    private fun setupComponentView(typedArray: TypedArray, frogoRecyclerView: FrogoRecyclerView) {
        val attributePaddingTop =
            typedArray.getDimension(R.styleable.frogo_shimmer_recycler_view_frvPaddingTop, 0F)
        val attributePaddingRight =
            typedArray.getDimension(R.styleable.frogo_shimmer_recycler_view_frvPaddingRight, 0F)
        val attributePaddingBottom =
            typedArray.getDimension(R.styleable.frogo_shimmer_recycler_view_frvPaddingBottom, 0F)
        val attributePaddingLeft =
            typedArray.getDimension(R.styleable.frogo_shimmer_recycler_view_frvPaddingLeft, 0F)
        val attributeClipToPadding =
            typedArray.getBoolean(R.styleable.frogo_shimmer_recycler_view_frvClipToPadding, true)

        frogoRecyclerView.clipToPadding = attributeClipToPadding
        frogoRecyclerView.setPadding(
            attributePaddingLeft.toInt(),
            attributePaddingTop.toInt(),
            attributePaddingRight.toInt(),
            attributePaddingBottom.toInt()
        )

    }


}