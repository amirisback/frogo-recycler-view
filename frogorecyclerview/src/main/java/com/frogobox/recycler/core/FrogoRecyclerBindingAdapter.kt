package com.frogobox.recycler.core

import androidx.viewbinding.ViewBinding

/**
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 29/04/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler.base
 *
 */

abstract class FrogoRecyclerBindingAdapter<T, VB : ViewBinding> :
    CoreFrogoRecyclerViewAdapter<T, FrogoRecyclerBindingHolder<T, VB>>() {

    protected var listener: FrogoRecyclerBindingListener<T, VB>? = null

    override fun adapterAreContentsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
        return listener?.areContentsTheSame(oldItem, newItem) ?: false
    }

    override fun adapterAreItemsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
        return listener?.areItemsTheSame(oldItem, newItem) ?: false
    }


    override fun getItemCount(): Int {
        return asyncListDiffer.currentList.size
    }

    override fun onBindViewHolder(holder: FrogoRecyclerBindingHolder<T, VB>, position: Int) {
        holder.bindItem(
            data = asyncListDiffer.currentList[position],
            position = position,
            bindingListener = listener,
            notifylistener = this
        )
    }

    open fun setupData(data: List<T>?) {
        this.asyncListDiffer.currentList.clear()

        if (data != null) {
            listData.addAll(data)
            this.asyncListDiffer.submitList(listData)
        }
    }

    open fun setupListener(bindingListener: FrogoRecyclerBindingListener<T, VB>?) {
        if (bindingListener != null) {
            this.listener = bindingListener
        }
    }

    open fun setupRequirement(
        data: List<T>?,
        bindingListener: FrogoRecyclerBindingListener<T, VB>?
    ) {
        setupListener(bindingListener)
        setupData(data)
    }

}