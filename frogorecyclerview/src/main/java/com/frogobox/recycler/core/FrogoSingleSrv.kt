package com.frogobox.recycler.core

import android.view.View

/**
 * Created by Faisal Amir on 04/06/2020
 * FrogoRecyclerView Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2020 FrogoBox Inc.      
 * All rights reserved
 *
 */

class FrogoSingleSrv : FrogoSingleRv<String>() {

    protected lateinit var srvFrogoAdapterCallback: IFrogoViewAdapter<String>
    protected lateinit var srvFrogoViewAdapter: FrogoViewAdapter<String>

    protected var srvSumListItem: Int = 2
    protected var srvCustomViewInt: Int = 0

    fun addShimmerViewPlaceHolder(customViewInt: Int): FrogoSingleSrv {
        srvCustomViewInt = customViewInt
        return this
    }

    fun addShimmerSumOfItemLoading(sumItem: Int): FrogoSingleSrv {
        srvSumListItem = sumItem
        return this
    }

    private fun srvListData(): MutableList<String> {
        for (i in 1..srvSumListItem) {
            listData.add("place-holder-shimmer")
        }
        return listData
    }

    override fun createAdapter() {
        optionAdapter = FrogoRvConstant.FROGO_ADAPTER_R_CLASS

        srvFrogoAdapterCallback = object : IFrogoViewAdapter<String> {
            override fun setupInitComponent(
                view: View,
                data: String,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<String>
            ) {
            }

            override fun onItemClicked(
                view: View,
                data: String,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<String>
            ) {
            }

            override fun onItemLongClicked(
                view: View,
                data: String,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<String>
            ) {
            }

            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }
        }

        srvFrogoViewAdapter = FrogoViewAdapter()
        srvFrogoViewAdapter.setCallback(object : IFrogoViewHolder<String> {
            override fun setupInitComponent(
                view: View,
                data: String,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<String>
            ) {
                srvFrogoAdapterCallback.setupInitComponent(view, data, position, notifyListener)
            }
        })
        srvFrogoViewAdapter.setupRequirement(srvCustomViewInt, srvListData(),
            object :
                FrogoRecyclerViewListener<String> {
                override fun onItemClicked(
                    view: View,
                    data: String,
                    position: Int,
                    notifyListener: FrogoRecyclerNotifyListener<String>
                ) {
                    srvFrogoAdapterCallback.onItemClicked(view, data, position, notifyListener)
                }

                override fun onItemLongClicked(
                    view: View,
                    data: String,
                    position: Int,
                    notifyListener: FrogoRecyclerNotifyListener<String>
                ) {
                    srvFrogoAdapterCallback.onItemLongClicked(view, data, position, notifyListener)
                }

                override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                    return oldItem.hashCode() == newItem.hashCode()
                }

                override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                    return oldItem == newItem
                }
            })

        srvFrogoViewAdapter.setupEmptyView(emptyViewId)
    }

    override fun setupInnerAdapter() {
        frogoRecycleView.adapter = srvFrogoViewAdapter
    }

    override fun frogoNotifyData(): MutableList<String> {
        return srvFrogoViewAdapter.frogoNotifyData()
    }

    override fun frogoNotifyDataSetChanged() {
        srvFrogoViewAdapter.frogoNotifyDataSetChanged()
    }

    override fun frogoNotifyItemChanged(data: String, position: Int, payload: Any) {
        srvFrogoViewAdapter.frogoNotifyItemChanged(data, position, payload)
    }

    override fun frogoNotifyItemChanged(data: String, position: Int) {
        srvFrogoViewAdapter.frogoNotifyItemChanged(data, position)
    }

    override fun frogoNotifyItemInserted(data: String, position: Int) {
        srvFrogoViewAdapter.frogoNotifyItemInserted(data, position)
    }

    override fun frogoNotifyItemMoved(data: String, fromPosition: Int, toPosition: Int) {
        srvFrogoViewAdapter.frogoNotifyItemMoved(data, fromPosition, toPosition)
    }

    override fun frogoNotifyItemRangeChanged(data: List<String>, positionStart: Int, payload: Any) {
        srvFrogoViewAdapter.frogoNotifyItemRangeChanged(data, positionStart, payload)
    }

    override fun frogoNotifyItemRangeChanged(data: List<String>, positionStart: Int) {
        srvFrogoViewAdapter.frogoNotifyItemRangeChanged(data, positionStart)
    }

    override fun frogoNotifyItemRangeInserted(data: List<String>, positionStart: Int) {
        srvFrogoViewAdapter.frogoNotifyItemRangeInserted(data, positionStart)
    }

    override fun frogoNotifyItemRangeRemoved(positionStart: Int, itemCount: Int) {
        srvFrogoViewAdapter.frogoNotifyItemRangeRemoved(positionStart, itemCount)
    }

    override fun frogoNotifyItemRemoved(item: String) {
        srvFrogoViewAdapter.frogoNotifyItemRemoved(item)
    }

}