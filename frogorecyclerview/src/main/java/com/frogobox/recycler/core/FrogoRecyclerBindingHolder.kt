package com.frogobox.recycler.core

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 20/12/2019.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.frogoviewadapter
 *
 */
abstract class FrogoRecyclerBindingHolder<T, VB : ViewBinding>(private val binding: VB) :
    CoreFrogoRecyclerViewHolder<T>(binding.root) {

    abstract fun initComponent(
        binding: VB,
        data: T,
        position: Int,
        notifyListener: FrogoRecyclerNotifyListener<T>
    ) // component view

    fun getLinearLayoutManager(recyclerView: RecyclerView): LinearLayoutManager {
        return recyclerView.layoutManager as LinearLayoutManager
    }

    fun bindItem(
        data: T?,
        position: Int,
        bindingListener: FrogoRecyclerBindingListener<T, VB>?,
        notifylistener: FrogoRecyclerNotifyListener<T>
    ) {
        if (data != null) {
            onItemViewClicked(data, position, bindingListener, notifylistener)
            initComponent(binding, data, position, notifylistener)
        }
    }

    private fun onItemViewClicked(
        data: T?,
        position: Int,
        bindingListener: FrogoRecyclerBindingListener<T, VB>?,
        notifylistener: FrogoRecyclerNotifyListener<T>
    ) {
        binding.root.setOnClickListener {
            if (data != null) {
                bindingListener?.onItemClicked(binding, data, position, notifylistener)
            }
        }
        binding.root.setOnLongClickListener {
            if (data != null) {
                bindingListener?.onItemLongClicked(binding, data, position, notifylistener)
            }
            true
        }
    }

}