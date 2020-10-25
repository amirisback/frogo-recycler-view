package com.frogobox.recycler.util

import android.content.Context
import android.view.LayoutInflater
import com.frogobox.frogodesignkit.databinding.FrogoEmptyViewBinding
import com.frogobox.frogodesignkit.databinding.FrogoRvListType1Binding
import com.frogobox.frogodesignkit.databinding.FrogoRvListType2Binding

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
 * com.frogobox.recycler.util
 * 
 */
interface FrogoRvViewBindingInterface {

    fun frogoLayoutInflater(context: Context): LayoutInflater

    fun frogoRvListType1(context: Context): FrogoRvListType1Binding

    fun frogoRvListType2(context: Context): FrogoRvListType2Binding

    fun frogoRvEmptyView(context: Context): FrogoEmptyViewBinding

}