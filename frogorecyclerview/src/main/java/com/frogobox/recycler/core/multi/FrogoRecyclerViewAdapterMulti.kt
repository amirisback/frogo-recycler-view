package com.frogobox.recycler.core.multi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.frogobox.recycler.core.CoreFrogoRecyclerViewAdapter
import com.frogobox.recycler.core.FrogoRecyclerViewHolder

/*
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 26/04/2020.      
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * FrogoBox Inc
 * com.frogobox.recycler.base.adapter
 * 
 */
abstract class FrogoRecyclerViewAdapterMulti<T> :
    CoreFrogoRecyclerViewAdapter<T>() {

    protected val frogoHolder = mutableListOf<FrogoHolder<T>>()

    fun setupRequirement(viewHolder: List<FrogoHolder<T>>) {
        frogoHolder.addAll(viewHolder)
        notifyDataSetChanged()
    }

    private fun multiLayoutHandling() {
        if (customLayoutRestId != 0) {
            layoutRv = if (frogoHolder.isNotEmpty()) {
                customLayoutRestId
            } else {
                emptyLayoutResId
            }
        }
    }

    fun viewLayout(parent: ViewGroup, layoutResId: Int): View {
        customLayoutRestId = layoutResId
        multiLayoutHandling()
        return LayoutInflater.from(parent.context).inflate(layoutRv, parent, false)
    }

    override fun getItemCount(): Int {
        return if (hasEmptyView) {
            listCount = if (frogoHolder.size == 0) {
                1
            } else {
                frogoHolder.size
            }
            listCount
        } else {
            frogoHolder.size
        }
    }

    override fun onBindViewHolder(holder: FrogoRecyclerViewHolder<T>, position: Int) {
        if (hasEmptyView) {
            if (frogoHolder.size != 0) {
                holder.bindItem(frogoHolder[position].data, frogoHolder[position].listener)
            }
        } else {
            holder.bindItem(frogoHolder[position].data, frogoHolder[position].listener)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (frogoHolder.size != 0) {
            frogoHolder[position].option
        } else {
            super.getItemViewType(position)
        }
    }

}