package com.frogobox.recycler.base.parent

import androidx.recyclerview.widget.RecyclerView

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
abstract class ParentFrogoRecyclerViewAdapter<T> :
    RecyclerView.Adapter<ParentFrogoRecyclerViewHolder<T>>() {

    protected var mFrogoRecyclerViewListener: FrogoRecyclerViewListener<T>? = null
    protected var hasEmptyView = false

    protected val mListData = mutableListOf<T>()
    protected var listCount = 0

    override fun getItemCount(): Int {
        return if (hasEmptyView) {
            listCount = if (mListData.size == 0) {
                1
            } else {
                mListData.size
            }
            listCount
        } else {
            mListData.size
        }
    }

    override fun onBindViewHolder(holder: ParentFrogoRecyclerViewHolder<T>, position: Int) {
        if (hasEmptyView) {
            if (mListData.size != 0) {
                holder.bindItem(mListData[position], mFrogoRecyclerViewListener)
            }
        } else {
            holder.bindItem(mListData[position], mFrogoRecyclerViewListener)
        }
    }


}