package com.frogobox.recycler.core.viewbinding

import androidx.viewbinding.ViewBinding
import com.frogobox.recycler.core.CoreFrogoRecyclerViewHolder

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
abstract class FrogoRecyclerViewHolderBinding<T, V : ViewBinding>(viewBinding: V) :
    CoreFrogoRecyclerViewHolder<T>(viewBinding.root) {

}