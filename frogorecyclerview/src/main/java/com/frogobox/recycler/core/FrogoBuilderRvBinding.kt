package com.frogobox.recycler.core

import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.frogobox.recycler.widget.FrogoRecyclerView

/*
 * Created by faisalamir on 24/07/21
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
class FrogoBuilderRvBinding<T, VB : ViewBinding> : FrogoBuilderRvBase<T>() {

    fun initBuilder(frogoRecyclerView: FrogoRecyclerView): FrogoBuilderRvBinding<T, VB> {
        init(frogoRecyclerView)
        return this
    }

    fun builder(listener: IFrogoBuilderRvBinding<T, VB>) {

        optionAdapter = FrogoRvConstant.FROGO_ADAPTER_VIEW_BINDING

        listData.addAll(listener.setupData())

        val frogoBindingAdapter = FrogoBindingAdapter<T, VB>()

        frogoBindingAdapter.setCallback(object : IFrogoBindingHolder<T, VB> {
            override fun setViewBinding(parent: ViewGroup): VB {
                return listener.setViewBinding(parent)
            }

            override fun setupInitComponent(binding: VB, data: T) {
                return listener.setupInitComponent(binding, data)
            }
        })

        frogoBindingAdapter.setupRequirement(listData, object : FrogoRecyclerViewListener<T> {
            override fun onItemClicked(data: T) {
                listener.onItemClicked(data)
            }

            override fun onItemLongClicked(data: T) {
                listener.onItemLongClicked(data)
            }
        })

        frogoRecyclerView.adapter = frogoBindingAdapter
        frogoRecyclerView.layoutManager = listener.setupLayoutManager(frogoRecyclerView.context)

    }

}