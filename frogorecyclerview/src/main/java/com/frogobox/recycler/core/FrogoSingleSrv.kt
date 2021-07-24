package com.frogobox.recycler.core

import android.view.View
import com.frogobox.frogolog.FLog

/*
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
        FLog.d("injector-shimmerView : $srvCustomViewInt")
        return this
    }

    fun addShimmerSumOfItemLoading(sumItem: Int): FrogoSingleSrv {
        srvSumListItem = sumItem
        FLog.d("injector-sumItem : $srvSumListItem")
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
            override fun setupInitComponent(view: View, data: String) {}
            override fun onItemClicked(data: String) {}
            override fun onItemLongClicked(data: String) {}
        }

        srvFrogoViewAdapter = FrogoViewAdapter()
        srvFrogoViewAdapter.setCallback(object : IFrogoViewHolder<String> {
            override fun setupInitComponent(view: View, data: String) {
                srvFrogoAdapterCallback.setupInitComponent(view, data)
            }
        })
        srvFrogoViewAdapter.setupRequirement(srvCustomViewInt, srvListData(),
            object :
                FrogoRecyclerViewListener<String> {
                override fun onItemClicked(data: String) {
                    srvFrogoAdapterCallback.onItemClicked(data)
                }

                override fun onItemLongClicked(data: String) {
                    srvFrogoAdapterCallback.onItemLongClicked(data)
                }
            })

        srvFrogoViewAdapter.setupEmptyView(emptyViewId)
    }

    override fun setupInnerAdapter() {
        FLog.d("injector-optionAdapter : $optionAdapter")
        frogoRecycleView.adapter = srvFrogoViewAdapter
    }

}