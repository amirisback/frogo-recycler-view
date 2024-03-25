package com.frogobox.recycler.core

import android.util.Log
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by faisalamircs on 25/03/2024
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


abstract class CoreFrogoRecyclerViewAdapter<T, VH : CoreFrogoRecyclerViewHolder<T>> : RecyclerView.Adapter<VH>() {

    /**
     * Base Of Core FrogoRecyclerViewHolder
     */
    
    protected val listData = mutableListOf<T>()

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

        override fun frogoNotifyItemRemoved(item: T) {
            innerFrogoNotifyItemRemoved(item)
        }

    }

    protected val asyncListDiffer = AsyncListDiffer(this, object : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
            return adapterAreItemsTheSame(oldItem, newItem)
        }

        override fun areContentsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
            return adapterAreContentsTheSame(oldItem, newItem)
        }
    })

    open fun adapterAreItemsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
        return false
    }

    open fun adapterAreContentsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
        return false
    }

    // Notify Data List
    fun innerFrogoNotifyData(): MutableList<T> {
        return listData
    }

    // Notify Data Set Changed
    fun innerFrogoNotifyDataSetChanged() {
        notifyDataSetChanged()
    }

    // Notify Data Item Changed
    fun innerFrogoNotifyItemChanged(data: T, position: Int, payload: Any) {
        listData[position] = data
        notifyItemChanged(position, payload)
        asyncListDiffer.submitList(listData)
    }

    // Notify Data Item Changed
    fun innerFrogoNotifyItemChanged(data: T, position: Int) {
        listData[position] = data
        notifyItemChanged(position)
        asyncListDiffer.submitList(listData)
    }

    // Notify Data Item Inserted
    fun innerFrogoNotifyItemInserted(data: T, position: Int) {
        listData.add(position, data)
        notifyItemInserted(position)
        asyncListDiffer.submitList(listData)
    }

    // Notify Data Item Moved
    fun innerFrogoNotifyItemMoved(data: T, fromPosition: Int, toPosition: Int) {
        listData.removeAt(fromPosition)
        listData.add(toPosition, data)
        notifyItemMoved(fromPosition, toPosition)
        asyncListDiffer.submitList(listData)
    }

    // Notify Data Item Range Changed
    fun innerFrogoNotifyItemRangeChanged(data: List<T>, positionStart: Int, payload: Any) {
        listData.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size, payload)
        asyncListDiffer.submitList(listData)
    }

    // Notify Data Item Range Changed
    fun innerFrogoNotifyItemRangeChanged(data: List<T>, positionStart: Int) {
        listData.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size)
        asyncListDiffer.submitList(listData)
    }

    // Notify Data Item Range Inserted
    fun innerFrogoNotifyItemRangeInserted(data: List<T>, positionStart: Int) {
        listData.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size)
        asyncListDiffer.submitList(listData)
    }

    // Notify Data Item Range Removed
    fun innerFrogoNotifyItemRangeRemoved(positionStart: Int, itemCount: Int) {
        listData.subList(positionStart, (positionStart + itemCount)).clear()
        notifyItemRangeRemoved(positionStart, itemCount)
        asyncListDiffer.submitList(listData)
    }

    // Notify Data Item Removed
    fun innerFrogoNotifyItemRemoved(item : T) {
        val index = listData.indexOf(item)
        listData.remove(item)
        notifyItemRemoved(index)
        asyncListDiffer.submitList(listData)
    }

}