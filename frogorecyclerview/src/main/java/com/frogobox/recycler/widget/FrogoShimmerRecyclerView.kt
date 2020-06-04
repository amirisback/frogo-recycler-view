package com.frogobox.recycler.widget

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.frogobox.recycler.R
import com.frogobox.recycler.boilerplate.shimmerrclass.FrogoSrvSingleton
import com.frogobox.recycler.boilerplate.shimmerrclass.FrogoSrvSingletonRecycler
import com.frogobox.recycler.boilerplate.shimmerrclass.FrogoSrvSingletonShimmer
import com.frogobox.recycler.view.FrogoShimmerRecyclerViewInterface
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
) : RelativeLayout(context, attrs, defStyle, defStyleRes), FrogoShimmerRecyclerViewInterface {

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
            typedArray?.let { it1 -> setupComponentView(it1, widget_fsrv_recyclerview) }
            typedArray?.let { it1 -> setupComponentView(it1, widget_fsrv_shimmer_recyclerview) }

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
            typedArray.getBoolean(R.styleable.frogo_shimmer_recycler_view_rvClipToPadding, true)

        frogoRecyclerView.clipToPadding = attributeClipToPadding
        frogoRecyclerView.setPadding(
            attributePaddingLeft.toInt(),
            attributePaddingTop.toInt(),
            attributePaddingRight.toInt(),
            attributePaddingBottom.toInt()
        )

    }

    override fun startShimmer() {
        widget_fsrv_shimmer.visibility = View.VISIBLE
        widget_fsrv_shimmer.startShimmer()
    }

    override fun stopShimmer() {
        widget_fsrv_shimmer.visibility = View.GONE
        widget_fsrv_shimmer.stopShimmer()
    }

    override fun <T> injector(): FrogoSrvSingleton<T> {
        return FrogoSrvSingleton<T>().initSingleton(
            widget_fsrv_recyclerview,
            widget_fsrv_shimmer_recyclerview
        )
    }

    override fun defineShimmerView(): FrogoSrvSingletonShimmer {
        return FrogoSrvSingletonShimmer().initSingleton(widget_fsrv_shimmer_recyclerview)
    }

    override fun <T> defineRecyclerView(): FrogoSrvSingletonRecycler<T> {
        return FrogoSrvSingletonRecycler<T>().initSingleton(widget_fsrv_recyclerview)
    }

}