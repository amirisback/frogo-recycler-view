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


abstract class CoreFrogoRecyclerViewAdapter<T, VH : CoreFrogoRecyclerViewHolder<T>> :
    RecyclerView.Adapter<VH>(), FrogoRecyclerNotifyListener<T> {

    /**
     * Base Of Core FrogoRecyclerViewHolder
     */

    protected val listData = mutableListOf<T>()

    protected var notifyListener = this

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
    override fun frogoNotifyData(): MutableList<T> {
        return listData
    }

    // Notify Data Set Changed
    override fun frogoNotifyDataSetChanged() {
        notifyDataSetChanged()
    }

    // Notify Data Item Changed
    override fun frogoNotifyItemChanged(data: T, position: Int, payload: Any) {
        listData[position] = data
        notifyItemChanged(position, payload)
        asyncListDiffer.submitList(listData)
    }

    // Notify Data Item Changed
    override fun frogoNotifyItemChanged(data: T, position: Int) {
        listData[position] = data
        notifyItemChanged(position)
        asyncListDiffer.submitList(listData)
    }

    // Notify Data Item Inserted
    override fun frogoNotifyItemInserted(data: T, position: Int) {
        listData.add(position, data)
        notifyItemInserted(position)
        asyncListDiffer.submitList(listData)
    }

    // Notify Data Item Moved
    override fun frogoNotifyItemMoved(data: T, fromPosition: Int, toPosition: Int) {
        listData.removeAt(fromPosition)
        listData.add(toPosition, data)
        notifyItemMoved(fromPosition, toPosition)
        asyncListDiffer.submitList(listData)
    }

    // Notify Data Item Range Changed
    override fun frogoNotifyItemRangeChanged(data: List<T>, positionStart: Int, payload: Any) {
        listData.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size, payload)
        asyncListDiffer.submitList(listData)
    }

    // Notify Data Item Range Changed
    override fun frogoNotifyItemRangeChanged(data: List<T>, positionStart: Int) {
        listData.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size)
        asyncListDiffer.submitList(listData)
    }

    // Notify Data Item Range Inserted
    override fun frogoNotifyItemRangeInserted(data: List<T>, positionStart: Int) {
        listData.addAll(positionStart, data)
        notifyItemRangeChanged(positionStart, data.size)
        asyncListDiffer.submitList(listData)
    }

    // Notify Data Item Range Removed
    override fun frogoNotifyItemRangeRemoved(positionStart: Int, itemCount: Int) {
        listData.subList(positionStart, (positionStart + itemCount)).clear()
        notifyItemRangeRemoved(positionStart, itemCount)
        asyncListDiffer.submitList(listData)
    }

    // Notify Data Item Removed
    override fun frogoNotifyItemRemoved(item: T) {
        val index = listData.indexOf(item)
        listData.remove(item)
        notifyItemRemoved(index)
        asyncListDiffer.submitList(listData)
    }

}