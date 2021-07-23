package com.frogobox.recycler.widget

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.*
import androidx.viewbinding.ViewBinding
import com.frogobox.recycler.core.*


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
class FrogoRecyclerView : RecyclerView,
    IFrogoRecyclerView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    @Deprecated(FrogoRvConstant.Deprecated.isViewLinearVertical)
    override fun isViewLinearVertical(dividerItem: Boolean) {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        if (dividerItem) {
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }
    }

    @Deprecated(FrogoRvConstant.Deprecated.isViewLinearHorizontal)
    override fun isViewLinearHorizontal(dividerItem: Boolean) {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        if (dividerItem) {
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.HORIZONTAL))
        }
    }

    @Deprecated(FrogoRvConstant.Deprecated.isViewStaggeredGrid)
    override fun isViewStaggeredGrid(spanCount: Int) {
        layoutManager = StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL)
    }

    @Deprecated(FrogoRvConstant.Deprecated.isViewGrid)
    override fun isViewGrid(spanCount: Int) {
        layoutManager = GridLayoutManager(context, spanCount)
    }

    override fun <T> injector(): FrogoSingleRv<T> =
        FrogoSingleRv<T>().initSingleton(this)

    override fun <T, VB : ViewBinding> injectorBinding(): FrogoSingleRvBinding<T, VB> {
        return FrogoSingleRvBinding<T, VB>().initSingleton(this)
    }

    override fun <T> builder(listener: FrogoBuilderRvListener<T>) {
        return FrogoBuilderRv<T>().initBuilder(this).builder(listener)
    }

}