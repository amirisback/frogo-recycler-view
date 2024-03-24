package com.frogobox.recycler.core

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


abstract class BaseRecyclerViewAdapter<T, VH : BaseRecyclerViewHolder<T>> : RecyclerView.Adapter<VH>() {

    /**
     * Base Of Core FrogoRecyclerViewHolder
     */

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
        return asyncListDiffer.currentList
    }

    // Notify Data Set Changed
    fun innerFrogoNotifyDataSetChanged() {
        notifyDataSetChanged()
    }

    // Notify Data Item Changed
    fun innerFrogoNotifyItemChanged(data: T, position: Int, payload: Any) {
        asyncListDiffer.currentList[position] = data
        notifyItemChanged(position, payload)
    }

    // Notify Data Item Changed
    fun innerFrogoNotifyItemChanged(data: T, position: Int) {
        asyncListDiffer.currentList[position] = data
        notifyItemChanged(position)
    }

    // Notify Data Item Inserted
    fun innerFrogoNotifyItemInserted(data: T, position: Int) {
        asyncListDiffer.currentList.add(position, data)
        notifyItemInserted(position)
    }

    // Notify Data Item Moved
    fun innerFrogoNotifyItemMoved(data: T, fromPosition: Int, toPosition: Int) {
        asyncListDiffer.currentList.removeAt(fromPosition)
        asyncListDiffer.currentList.add(toPosition, data)
        notifyItemMoved(fromPosition, toPosition)
    }

    // Notify Data Item Range Changed
    fun innerFrogoNotifyItemRangeChanged(data: List<T>, positionStart: Int, payload: Any) {
        asyncListDiffer.currentList.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size, payload)
    }

    // Notify Data Item Range Changed
    fun innerFrogoNotifyItemRangeChanged(data: List<T>, positionStart: Int) {
        asyncListDiffer.currentList.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size)
    }

    // Notify Data Item Range Inserted
    fun innerFrogoNotifyItemRangeInserted(data: List<T>, positionStart: Int) {
        asyncListDiffer.currentList.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size)
    }

    // Notify Data Item Range Removed
    fun innerFrogoNotifyItemRangeRemoved(positionStart: Int, itemCount: Int) {
        asyncListDiffer.currentList.subList(positionStart, (positionStart + itemCount)).clear()
        notifyItemRangeRemoved(positionStart, itemCount)
    }

    // Notify Data Item Removed
    fun innerFrogoNotifyItemRemoved(position: Int) {
        asyncListDiffer.currentList.removeAt(position)
        notifyItemRemoved(position)
    }

}