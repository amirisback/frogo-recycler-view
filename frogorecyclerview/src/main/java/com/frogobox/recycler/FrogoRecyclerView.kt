package com.frogobox.recycler

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.*
import com.frogobox.recycler.base.listener.FrogoRecyclerViewListener
import com.frogobox.recycler.boilerplate.adapter.FrogoViewAdapter
import com.frogobox.recycler.boilerplate.adapter.FrogoViewMultiAdapter
import com.frogobox.recycler.boilerplate.adapter.callback.FrogoAdapterCallback
import com.frogobox.recycler.boilerplate.adapter.callback.FrogoMultiAdapterCallback
import com.frogobox.recycler.boilerplate.holder.callback.FrogoHolderCallback
import com.frogobox.recycler.util.FrogoRvConstant
import com.frogobox.recycler.util.FrogoRvSingleton


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
class FrogoRecyclerView : RecyclerView, FrogoRecyclerViewInterface {

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

    @Deprecated(FrogoRvConstant.Deprecated.injectAdapter)
    override fun <T> injectAdapter(
        customView: Int,
        listData: List<T>?,
        emptyView: Int?,
        frogoAdapterCallback: FrogoAdapterCallback<T>
    ) {

        val frogoViewAdapter = FrogoViewAdapter(object : FrogoHolderCallback<T> {
            override fun setupInitComponent(view: View, data: T) {
                frogoAdapterCallback.setupInitComponent(view, data)
            }
        })

        frogoViewAdapter.setupRequirement(
            customView,
            listData,
            object : FrogoRecyclerViewListener<T> {
                override fun onItemClicked(data: T) {
                    frogoAdapterCallback.onItemClicked(data)
                }

                override fun onItemLongClicked(data: T) {
                    frogoAdapterCallback.onItemLongClicked(data)
                }
            })

        frogoViewAdapter.setupEmptyView(emptyView)
        adapter = frogoViewAdapter

    }

    override fun <T> injectMultiAdapter(
        listData: List<T>?,
        multiCustomView: List<Int>,
        multiOptionHolder: List<Int>,
        emptyView: Int?,
        callback: FrogoMultiAdapterCallback<T>
    ) {

        val frogoMultiViewAdapter = FrogoViewMultiAdapter(object : FrogoHolderCallback<T> {
            override fun setupInitComponent(view: View, data: T) {
                callback.setupFirstInitComponent(view, data)
            }
        }, object : FrogoHolderCallback<T> {
            override fun setupInitComponent(view: View, data: T) {
                callback.setupSecondInitComponent(view, data)
            }
        })

        frogoMultiViewAdapter.setupRequirement(
            listData,
            multiCustomView,
            multiOptionHolder,
            object : FrogoRecyclerViewListener<T> {
                override fun onItemClicked(data: T) {
                    callback.onFirstItemClicked(data)
                }

                override fun onItemLongClicked(data: T) {
                    callback.onFirstItemLongClicked(data)
                }
            },
            object : FrogoRecyclerViewListener<T> {
                override fun onItemClicked(data: T) {
                    callback.onSecondItemClicked(data)
                }

                override fun onItemLongClicked(data: T) {
                    callback.onSecondItemLongClicked(data)
                }
            }
        )
        frogoMultiViewAdapter.setupEmptyView(emptyView)
        adapter = frogoMultiViewAdapter

    }

    override fun <T> injector() = FrogoRvSingleton<T>().initSingleton(this)

}