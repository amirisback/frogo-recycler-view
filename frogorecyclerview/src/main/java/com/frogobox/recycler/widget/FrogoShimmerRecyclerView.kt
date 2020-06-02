package com.frogobox.recycler.widget

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.frogobox.recycler.R
import kotlinx.android.synthetic.main.widget_frogo_shimmer_recyclerview.view.*

/*
 * Created by Faisal Amir on 02/06/2020
 * FrogoRecyclerView Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2020 FrogoBox Inc.      
 * All rights reserved
 *
 */

class FrogoShimmerRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : RelativeLayout(context, attrs, defStyle, defStyleRes) {

    init {
        setupViewEditor()
        setupAttribute(attrs)
    }

    private fun setupViewEditor() {
        LayoutInflater.from(context).inflate(R.layout.widget_frogo_shimmer_recyclerview, this, true)
    }

    private fun setupAttribute(attrs: AttributeSet?) {
        attrs?.let {
            val typedArray =
                context?.obtainStyledAttributes(it, R.styleable.frogo_shimmer_recycler_view, 0, 0)

            // setup inner component
            typedArray?.let { it1 -> setupComponentView(it1, widget_fsrv_frogo_rv) }
//            typedArray?.let { it1 -> setupComponentView(it1, widget_fsrv_shimmer_place_holder_rv) }

            typedArray?.recycle()
        }
    }

    private fun setupComponentView(typedArray: TypedArray, frogoRecyclerView: FrogoRecyclerView) {
        val attributePaddingTop =
            typedArray.getDimension(R.styleable.frogo_shimmer_recycler_view_rvPaddingTop, 0F)
        val attributePaddingRight =
            typedArray.getDimension(R.styleable.frogo_shimmer_recycler_view_rvPaddingRight, 0F)
        val attributePaddingBottom =
            typedArray.getDimension(R.styleable.frogo_shimmer_recycler_view_rvPaddingBottom, 0F)
        val attributePaddingLeft =
            typedArray.getDimension(R.styleable.frogo_shimmer_recycler_view_rvPaddingLeft, 0F)
        val attributeClipToPadding =
            typedArray.getBoolean(R.styleable.frogo_shimmer_recycler_view_clipToPadding, true)

        frogoRecyclerView.clipToPadding = attributeClipToPadding
        frogoRecyclerView.setPadding(
            attributePaddingLeft.toInt(),
            attributePaddingTop.toInt(),
            attributePaddingRight.toInt(),
            attributePaddingBottom.toInt()
        )

    }

    fun startShimmer() {
        widget_fsrv_shimmer.visibility = View.VISIBLE
        widget_fsrv_shimmer.startShimmer()
    }

    fun stopShimmer() {
        widget_fsrv_shimmer.visibility = View.GONE
        widget_fsrv_shimmer.stopShimmer()
    }

}