package com.frogobox.recycler.core.multi

import android.util.Log
import android.view.ViewGroup
import com.frogobox.recycler.core.FrogoRecyclerViewHolder
import com.frogobox.recycler.core.FrogoRvConstant.OPTION_HOLDER_FIRST
import com.frogobox.recycler.core.FrogoRvConstant.OPTION_HOLDER_SECOND
import com.frogobox.recycler.core.FrogoViewHolder
import com.frogobox.recycler.core.IFrogoViewHolder

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
 * com.frogobox.recycler.adapter
 * 
 */
class FrogoViewAdapterMulti<T> : FrogoRecyclerViewAdapterMulti<T>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FrogoRecyclerViewHolder<T> {

        Log.d("adapterMulti", "data : ${frogoHolder[viewType].data}")
        Log.d("adapterMulti", "layout id : ${frogoHolder[viewType].layoutResId}")
        Log.d("adapterMulti", "callback  : ${frogoHolder[viewType].callback}")
        Log.d("adapterMulti", "option  : ${frogoHolder[viewType].option}")
        Log.d("adapterMulti", "listener  : ${frogoHolder[viewType].listener}")

        return FrogoViewHolder(
            viewLayout(parent, frogoHolder[viewType].layoutResId),
            frogoHolder[viewType].callback
        )
    }

}