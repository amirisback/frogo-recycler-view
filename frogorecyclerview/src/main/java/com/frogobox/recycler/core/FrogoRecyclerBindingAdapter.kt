package com.frogobox.recycler.core

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.frogobox.frogolog.FLog
import com.frogobox.recycler.core.FrogoRvConstant.FROGO_RV_TAG

/*
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
    RecyclerView.Adapter<FrogoRecyclerBindingHolder<T, VB>>() {

    protected var viewListener: FrogoRecyclerViewListener<T>? = null
    protected val listData = mutableListOf<T>()

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: FrogoRecyclerBindingHolder<T, VB>, position: Int) {
        FLog.d("$FROGO_RV_TAG - listData : ${listData.size}")
        holder.bindItem(listData[position], viewListener)
    }

    fun setupData(data: List<T>?) {
        this.listData.clear()

        if (data != null) {
            this.listData.addAll(data)
        }
    }

    fun setupListener(listener: FrogoRecyclerViewListener<T>?) {
        if (listener != null) {
            viewListener = listener
        }
    }

    fun setupRequirement(
        data: List<T>?,
        listener: FrogoRecyclerViewListener<T>?
    ) {

        if (listener != null) {
            viewListener = listener
        }

        this.listData.clear()

        if (data != null) {
            this.listData.addAll(data)
        }
    }

}