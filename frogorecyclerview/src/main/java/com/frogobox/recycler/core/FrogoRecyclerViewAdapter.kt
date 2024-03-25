package com.frogobox.recycler.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.frogobox.recycler.R

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

abstract class FrogoRecyclerViewAdapter<T> :
    CoreFrogoRecyclerViewAdapter<T, FrogoRecyclerViewHolder<T>>() {

    var hasEmptyView = false
    var hasMultiHolder = false
    var hasNestedView = false

    protected var listener: FrogoRecyclerViewListener<T>? = null

    protected val listPosition = HashMap<Int, Int>()
    protected val sharedPool = RecyclerView.RecycledViewPool()

    protected val frogoHolder = mutableListOf<FrogoHolder<T>>()

    protected val listDataNested = mutableListOf<MutableList<T>>()
    protected var listCount = 0

    protected var layoutRv: Int = 0
    protected var customLayoutRestId: Int = 0
    protected var emptyLayoutResId: Int = R.layout.frogo_rv_container_empty_view

    override fun adapterAreContentsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
        return listener?.areContentsTheSame(oldItem, newItem) ?: false
    }

    override fun adapterAreItemsTheSame(oldItem: T & Any, newItem: T & Any): Boolean {
        return listener?.areItemsTheSame(oldItem, newItem) ?: false
    }

    fun bindNestedHolder() {

    } // component view

    override fun getItemCount(): Int {

        return if (hasNestedView) {
            listDataNested.size
        } else {
            if (hasMultiHolder) {
                if (hasEmptyView) {
                    listCount = if (frogoHolder.size == 0) {
                        1
                    } else {
                        frogoHolder.size
                    }
                    listCount
                } else {
                    frogoHolder.size
                }
            } else {
                if (hasEmptyView) {
                    listCount = if (asyncListDiffer.currentList.size == 0) {
                        1
                    } else {
                        asyncListDiffer.currentList.size
                    }
                    listCount
                } else {
                    asyncListDiffer.currentList.size
                }
            }
        }
    }

    override fun onBindViewHolder(holder: FrogoRecyclerViewHolder<T>, position: Int) {
        if (hasNestedView) {
            bindNestedHolder()
        } else {
            if (hasMultiHolder) {
                if (hasEmptyView) {
                    if (frogoHolder.size != 0) {
                        holder.bindItem(
                            data = frogoHolder[position].data,
                            position = position,
                            viewListener = frogoHolder[position].viewListener,
                            notifyListener = this
                        )
                    }
                } else {
                    holder.bindItem(
                        data = frogoHolder[position].data,
                        position = position,
                        viewListener = frogoHolder[position].viewListener,
                        notifyListener = this
                    )
                }
            } else {
                if (hasEmptyView) {
                    if (asyncListDiffer.currentList.size != 0) {
                        holder.bindItem(
                            data = asyncListDiffer.currentList[position],
                            position = position,
                            viewListener = listener,
                            notifyListener = this
                        )
                    }
                } else {
                    holder.bindItem(
                        data = asyncListDiffer.currentList[position],
                        position = position,
                        viewListener = listener,
                        notifyListener = this
                    )
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (hasMultiHolder) {
            if (frogoHolder.size != 0) {
                frogoHolder[position].option
            } else {
                super.getItemViewType(position)
            }
        } else {
            super.getItemViewType(position)
        }
    }

    override fun onViewRecycled(holder: FrogoRecyclerViewHolder<T>) {
        if (hasNestedView) {
            val position = holder.absoluteAdapterPosition
            val nestedHolder = holder as FrogoNestedHolder<T>
            listPosition[position] =
                nestedHolder.getLinearLayoutManager().findFirstVisibleItemPosition()
        }
        super.onViewRecycled(holder)
    }

    open fun layoutHandling() {
        if (hasMultiHolder) {
            if (customLayoutRestId != 0) {
                layoutRv = if (frogoHolder.isNotEmpty()) {
                    customLayoutRestId
                } else {
                    emptyLayoutResId
                }
            }
        } else {
            if (customLayoutRestId != 0) {
                layoutRv = if (asyncListDiffer.currentList.isNotEmpty()) {
                    customLayoutRestId
                } else {
                    emptyLayoutResId
                }
            }
        }
    }

    open fun viewLayout(parent: ViewGroup): View {
        return LayoutInflater.from(parent.context).inflate(layoutRv, parent, false)
    }

    open fun viewLayout(parent: ViewGroup, layoutResId: Int): View {
        customLayoutRestId = layoutResId
        layoutHandling()
        return LayoutInflater.from(parent.context).inflate(layoutRv, parent, false)
    }

    open fun setupNestedView() {
        hasNestedView = true
    }

    open fun setupMultiHolder() {
        hasMultiHolder = true
    }

    open fun setupEmptyView(emptyView: Int?) {
        hasEmptyView = true
        if (emptyView != null) {
            emptyLayoutResId = emptyView
        }
        layoutHandling()
    }

    open fun setupDataNested(data: List<MutableList<T>>?) {
        this.listDataNested.clear()

        if (data != null) {
            this.listDataNested.addAll(data)
        }
    }

    open fun setupData(data: List<T>?) {
        this.asyncListDiffer.currentList.clear()

        if (data != null) {
            listData.addAll(data)
            this.asyncListDiffer.submitList(listData)
        }
    }

    open fun setupListener(listener: FrogoRecyclerViewListener<T>?) {
        if (listener != null) {
            this.listener = listener
        }
    }

    open fun setupCustomLayout(customViewId: Int) {
        customLayoutRestId = customViewId
    }

    open fun setupRequirement(
        customViewId: Int,
        data: List<T>?,
        listener: FrogoRecyclerViewListener<T>?
    ) {
        setupListener(listener)
        setupData(data)
        setupCustomLayout(customViewId)
        layoutHandling()
    }

    open fun setupRequirement(viewHolder: List<FrogoHolder<T>>) {
        frogoHolder.addAll(viewHolder)
    }

}