package com.frogobox.recycler

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.*
import com.frogobox.recycler.boilerplate.adapter.FrogoViewAdapter
import com.frogobox.recycler.base.listener.FrogoRecyclerViewListener
import com.frogobox.recycler.boilerplate.adapter.callback.FrogoAdapterCallback
import com.frogobox.recycler.boilerplate.holder.callback.FrogoHolderCallback


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
    FrogoLayoutView {


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

    override fun <T> injectAdapter(
        layoutItem: Int,
        dataList: List<T>?,
        emptyView: Int?,
        callback: FrogoAdapterCallback<T>
    ) {

        val frogoViewAdapter =
            FrogoViewAdapter(object :
                FrogoHolderCallback<T> {
                override fun setupInitComponent(view: View, data: T) {
                    callback.setupInitComponent(view, data)
                }
            })

        frogoViewAdapter.setupRequirement(
            layoutItem,
            dataList,
            object :
                FrogoRecyclerViewListener<T> {
                override fun onItemClicked(data: T) {
                    callback.onItemClicked(data)
                }

                override fun onItemLongClicked(data: T) {
                    callback.onItemLongClicked(data)
                }
            })

        frogoViewAdapter.setupEmptyView(emptyView)
        adapter = frogoViewAdapter

    }


}