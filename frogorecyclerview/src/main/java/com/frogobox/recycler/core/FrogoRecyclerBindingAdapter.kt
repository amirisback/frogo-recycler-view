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

abstract class FrogoRecyclerBindingAdapter<T, VB : ViewBinding> : CoreFrogoRecyclerViewAdapter<T, FrogoRecyclerBindingHolder<T, VB>>() {

    protected var bindingListener: FrogoRecyclerBindingListener<T, VB>? = null

    override fun adapterAreContentsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
        return bindingListener?.areContentsTheSame(oldItem, newItem) ?: false
    }

    override fun adapterAreItemsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
        return bindingListener?.areItemsTheSame(oldItem, newItem) ?: false
    }


    override fun getItemCount(): Int {
        return asyncListDiffer.currentList.size
    }

    override fun onBindViewHolder(holder: FrogoRecyclerBindingHolder<T, VB>, position: Int) {
        holder.bindItem(asyncListDiffer.currentList[position], position, bindingListener, notifyListener)
    }

    fun setupData(data: List<T>?) {
        this.asyncListDiffer.currentList.clear()

        if (data != null) {
            this.asyncListDiffer.submitList(data)
        }
    }

    fun setupListener(bindingListener: FrogoRecyclerBindingListener<T, VB>?) {
        if (bindingListener != null) {
            this.bindingListener = bindingListener
        }
    }

    fun setupRequirement(
        data: List<T>?,
        bindingListener: FrogoRecyclerBindingListener<T, VB>?
    ) {

        if (bindingListener != null) {
            this.bindingListener = bindingListener
        }

        this.asyncListDiffer.currentList.clear()

        if (data != null) {
            this.asyncListDiffer.submitList(data)
        }
    }

}