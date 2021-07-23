package com.frogobox.recycler.core

import android.view.View
import com.frogobox.recycler.R
import com.frogobox.recycler.widget.FrogoRecyclerView

/*
 * Created by faisalamir on 23/07/21
 * FrogoRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
class FrogoBuilderRv<T> {

    protected lateinit var mFrogoRecyclerView: FrogoRecyclerView
    protected lateinit var frogoViewAdapter: FrogoViewAdapter<T>

    protected var emptyViewId: Int = R.layout.frogo_container_empty_view

    protected var optionAdapter = ""
    protected var customViewId: Int = 0

    protected val listDataFH = mutableListOf<FrogoHolder<T>>()
    protected val listData = mutableListOf<T>()

    fun initBuilder(frogoRecyclerView: FrogoRecyclerView): FrogoBuilderRv<T> {
        mFrogoRecyclerView = frogoRecyclerView
        frogoViewAdapter = FrogoViewAdapter()
        return this
    }

    fun builder(listener: FrogoBuilderRvListener<T>) {

        listData.addAll(listener.setupData())

        optionAdapter = FrogoRvConstant.FROGO_ADAPTER_R_CLASS
        frogoViewAdapter.setCallback(object : IFrogoViewHolder<T> {
            override fun setupInitComponent(view: View, data: T) {
                listener.setupInitComponent(view, data)
            }
        })

        frogoViewAdapter.setupEmptyView(listener.setupEmptyView())

        frogoViewAdapter.setupRequirement(
            customViewId,
            listData,
            object : FrogoRecyclerViewListener<T> {
                override fun onItemClicked(data: T) {
                    listener.onItemClicked(data)
                }

                override fun onItemLongClicked(data: T) {
                    listener.onItemLongClicked(data)
                }
            })
        frogoViewAdapter.setupEmptyView(emptyViewId)

        mFrogoRecyclerView.layoutManager = listener.setupLayoutManager(mFrogoRecyclerView.context)

    }

}