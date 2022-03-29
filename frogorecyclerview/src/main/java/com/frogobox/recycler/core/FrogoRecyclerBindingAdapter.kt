package com.frogobox.recycler.core

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.frogobox.log.FLog
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

    protected var bindingListener: FrogoRecyclerBindingListener<T, VB>? = null

    protected var notifyListener = object : FrogoRecyclerNotifyListener<T> {

        override fun frogoNotifyData(): MutableList<T> {
            return innerFrogoNotifyData()
        }

        override fun frogoNotifyDataSetChanged() {
            innerFrogoNotifyDataSetChanged()
        }

        override fun frogoNotifyItemChanged(data: T, position: Int, payload: Any) {
            innerFrogoNotifyItemChanged(data, position, payload)
        }

        override fun frogoNotifyItemChanged(data: T, position: Int) {
            innerFrogoNotifyItemChanged(data, position)
        }

        override fun frogoNotifyItemInserted(data: T, position: Int) {
            innerFrogoNotifyItemInserted(data, position)
        }

        override fun frogoNotifyItemMoved(data: T, fromPosition: Int, toPosition: Int) {
            innerFrogoNotifyItemMoved(data, fromPosition, toPosition)
        }

        override fun frogoNotifyItemRangeChanged(data: List<T>, positionStart: Int, payload: Any) {
            innerFrogoNotifyItemRangeChanged(data, positionStart, payload)
        }

        override fun frogoNotifyItemRangeChanged(data: List<T>, positionStart: Int) {
            innerFrogoNotifyItemRangeChanged(data, positionStart)
        }

        override fun frogoNotifyItemRangeInserted(data: List<T>, positionStart: Int) {
            innerFrogoNotifyItemRangeInserted(data, positionStart)
        }

        override fun frogoNotifyItemRangeRemoved(positionStart: Int, itemCount: Int) {
            innerFrogoNotifyItemRangeRemoved(positionStart, itemCount)
        }

        override fun frogoNotifyItemRemoved(position: Int) {
            innerFrogoNotifyItemRemoved(position)
        }

    }

    protected val listData = mutableListOf<T>()

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: FrogoRecyclerBindingHolder<T, VB>, position: Int) {
        FLog.d("$FROGO_RV_TAG - listData : ${listData.size}")
        holder.bindItem(listData[position], position, bindingListener, notifyListener)
    }


    // Notify Data List
    fun innerFrogoNotifyData(): MutableList<T> {
        return listData
    }

    // Notify Data Set Changed
    fun innerFrogoNotifyDataSetChanged() {
        notifyDataSetChanged()
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyDataSetChanged")
    }

    // Notify Data Item Changed
    fun innerFrogoNotifyItemChanged(data: T, position: Int, payload: Any) {
        listData[position] = data
        notifyItemChanged(position, payload)
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemChanged")
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemChanged : ${data.toString()}")
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemChanged : $position")
    }

    // Notify Data Item Changed
    fun innerFrogoNotifyItemChanged(data: T, position: Int) {
        listData[position] = data
        notifyItemChanged(position)
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemChanged")
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemChanged : ${data.toString()}")
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemChanged : $position")
    }

    // Notify Data Item Inserted
    fun innerFrogoNotifyItemInserted(data: T, position: Int) {
        listData.add(position, data)
        notifyItemInserted(position)
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemInserted")
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemInserted : ${data.toString()}")
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemInserted : $position")
    }

    // Notify Data Item Moved
    fun innerFrogoNotifyItemMoved(data: T, fromPosition: Int, toPosition: Int) {
        listData.removeAt(fromPosition)
        listData.add(toPosition, data)
        notifyItemMoved(fromPosition, toPosition)
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemMoved")
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemMoved : ${data.toString()}")
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemMoved : $fromPosition")
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemMoved : $toPosition")
    }

    // Notify Data Item Range Changed
    fun innerFrogoNotifyItemRangeChanged(data: List<T>, positionStart: Int, payload: Any) {
        listData.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size, payload)
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemRangeChanged")
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemRangeChanged : ${data.toString()}")
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemRangeChanged : $positionStart")
    }

    // Notify Data Item Range Changed
    fun innerFrogoNotifyItemRangeChanged(data: List<T>, positionStart: Int) {
        listData.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size)
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemRangeChanged")
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemRangeChanged : ${data.toString()}")
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemRangeChanged : $positionStart")
    }

    // Notify Data Item Range Inserted
    fun innerFrogoNotifyItemRangeInserted(data: List<T>, positionStart: Int) {
        listData.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size)
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemRangeInserted")
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemRangeChanged : ${data.toString()}")
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemRangeChanged : $positionStart")
    }

    // Notify Data Item Range Removed
    fun innerFrogoNotifyItemRangeRemoved(positionStart: Int, itemCount: Int) {
        listData.subList(positionStart, (positionStart + itemCount)).clear()
        notifyItemRangeRemoved(positionStart, itemCount)
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemRangeRemoved")
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemRangeRemoved : $positionStart")
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemRangeRemoved : $itemCount")
    }

    // Notify Data Item Removed
    fun innerFrogoNotifyItemRemoved(position: Int) {
        listData.removeAt(position)
        notifyItemRemoved(position)
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemRemoved")
        FLog.d("$FROGO_RV_TAG - FrogoNotifyListener : frogoNotifyItemRemoved : $position")
    }

    fun setupData(data: List<T>?) {
        this.listData.clear()

        if (data != null) {
            this.listData.addAll(data)
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

        this.listData.clear()

        if (data != null) {
            this.listData.addAll(data)
        }
    }

}