package com.frogobox.recycler.core


/*
 * Created by faisalamir on 11/12/21
 * FrogoRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */

interface FrogoRecyclerNotifyListener<T> {

    // Notify Data List
    fun frogoNotifyData() : MutableList<T>

    // Notify Data Set Changed
    fun frogoNotifyDataSetChanged()

    // Notify Data Item Changed
    fun frogoNotifyItemChanged(data: T, position: Int, payload: Any)

    // Notify Data Item Changed
    fun frogoNotifyItemChanged(data: T, position: Int)

    // Notify Data Item Inserted
    fun frogoNotifyItemInserted(data: T, position: Int)

    // Notify Data Item Moved
    fun frogoNotifyItemMoved(data: T, fromPosition: Int, toPosition: Int)

    // Notify Data Item Range Changed
    fun frogoNotifyItemRangeChanged(data: List<T>, positionStart: Int, payload: Any)

    // Notify Data Item Range Changed
    fun frogoNotifyItemRangeChanged(data: List<T>, positionStart: Int)

    // Notify Data Item Range Inserted
    fun frogoNotifyItemRangeInserted(data: List<T>, positionStart: Int)

    // Notify Data Item Range Removed
    fun frogoNotifyItemRangeRemoved(positionStart: Int, itemCount: Int)

    // Notify Data Item Removed
    fun frogoNotifyItemRemoved(position: Int)
    
}