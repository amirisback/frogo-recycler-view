package com.frogobox.recycler.base.viewbinding

import androidx.viewbinding.ViewBinding
import com.frogobox.recycler.base.parent.ParentFrogoRecyclerViewHolder

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
abstract class FrogoRecylcerViewHolderBinding<T>(viewBinding: ViewBinding) :
    ParentFrogoRecyclerViewHolder<T>(viewBinding.root) {

}