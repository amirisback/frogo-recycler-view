package com.frogobox.recycler.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

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

    fun initBuilder(frogoRecyclerView: RecyclerView): FrogoBuilderRv<T> {
        init(frogoRecyclerView)
        return this
    }

    fun builder(viewListener: IFrogoBuilderRv<T>) {

        optionAdapter = FrogoRvConstant.FROGO_ADAPTER_R_CLASS

        listData.addAll(viewListener.setupData())

        val frogoViewAdapter = FrogoViewAdapter<T>()

        frogoViewAdapter.setCallback(object : IFrogoViewHolder<T> {
            override fun setupInitComponent(
                view: View,
                data: T,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<T>
            ) {
                viewListener.setupInitComponent(view, data, position, notifyListener)
            }
        })

        frogoViewAdapter.setupRequirement(
            viewListener.setupCustomView(), listData,
            object : FrogoRecyclerViewListener<T> {
                override fun onItemClicked(
                    view: View,
                    data: T,
                    position: Int,
                    notifyListener: FrogoRecyclerNotifyListener<T>
                ) {
                    viewListener.onItemClicked(view, data, position, notifyListener)
                }

                override fun onItemLongClicked(
                    view: View,
                    data: T,
                    position: Int,
                    notifyListener: FrogoRecyclerNotifyListener<T>
                ) {
                    viewListener.onItemLongClicked(view, data, position, notifyListener)
                }
            })

        if (viewListener.setupEmptyView() != null) {
            frogoViewAdapter.setupEmptyView(viewListener.setupEmptyView())
        } else {
            frogoViewAdapter.setupEmptyView(emptyViewId)
        }

        frogoRecyclerView.adapter = frogoViewAdapter
        frogoRecyclerView.layoutManager = viewListener.setupLayoutManager(frogoRecyclerView.context)

    }

}