package com.frogobox.recycler.core

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
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

    fun initBuilder(frogoRecyclerView: RecyclerView): FrogoBuilderRvBinding<T, VB> {
        init(frogoRecyclerView)
        return this
    }

    fun builder(bindingListener: IFrogoBuilderRvBinding<T, VB>) {

        optionAdapter = FrogoRvConstant.FROGO_ADAPTER_VIEW_BINDING

        listData.addAll(bindingListener.setupData())

        val frogoBindingAdapter = FrogoBindingAdapter<T, VB>()

        frogoBindingAdapter.setCallback(object : IFrogoBindingHolder<T, VB> {
            override fun setViewBinding(parent: ViewGroup): VB {
                return bindingListener.setViewBinding(parent)
            }

            override fun setupInitComponent(
                binding: VB,
                data: T,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<T>
            ) {
                return bindingListener.setupInitComponent(binding, data, position, notifyListener)
            }
        })

        frogoBindingAdapter.setupRequirement(
            listData,
            object : FrogoRecyclerBindingListener<T, VB> {
                override fun onItemClicked(
                    binding: VB,
                    data: T,
                    position: Int,
                    notifyListener: FrogoRecyclerNotifyListener<T>
                ) {
                    bindingListener.onItemClicked(binding, data, position, notifyListener)
                }

                override fun onItemLongClicked(
                    binding: VB,
                    data: T,
                    position: Int,
                    notifyListener: FrogoRecyclerNotifyListener<T>
                ) {
                    bindingListener.onItemLongClicked(binding, data, position, notifyListener)
                }

                override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
                    return bindingListener.areItemsTheSame(oldItem, newItem)
                }

                override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
                    return bindingListener.areContentsTheSame(oldItem, newItem)
                }
            })

        frogoRecyclerView.adapter = frogoBindingAdapter
        frogoRecyclerView.layoutManager =
            bindingListener.setupLayoutManager(frogoRecyclerView.context)

    }

}