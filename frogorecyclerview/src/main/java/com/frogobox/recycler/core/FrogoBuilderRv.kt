package com.frogobox.recycler.core

import android.view.View
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
class FrogoBuilderRv<T> : FrogoBuilderRvBase<T>() {

    fun initBuilder(frogoRecyclerView: FrogoRecyclerView): FrogoBuilderRv<T> {
        init(frogoRecyclerView)
        return this
    }

    fun builder(listener: IFrogoBuilderRv<T>) {

        optionAdapter = FrogoRvConstant.FROGO_ADAPTER_R_CLASS

        listData.addAll(listener.setupData())

        val frogoViewAdapter = FrogoViewAdapter<T>()

        frogoViewAdapter.setCallback(object : IFrogoViewHolder<T> {
            override fun setupInitComponent(view: View, data: T) {
                listener.setupInitComponent(view, data)
            }
        })

        frogoViewAdapter.setupRequirement(
            listener.setupCustomView(), listData,
            object : FrogoRecyclerViewListener<T> {
                override fun onItemClicked(data: T) {
                    listener.onItemClicked(data)
                }

                override fun onItemLongClicked(data: T) {
                    listener.onItemLongClicked(data)
                }
            })

        if (listener.setupEmptyView() != null) {
            frogoViewAdapter.setupEmptyView(listener.setupEmptyView())
        } else {
            frogoViewAdapter.setupEmptyView(emptyViewId)
        }

        frogoRecyclerView.adapter = frogoViewAdapter
        frogoRecyclerView.layoutManager = listener.setupLayoutManager(frogoRecyclerView.context)

    }

}