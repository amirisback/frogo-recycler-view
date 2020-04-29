package com.frogobox.recycler.util

import android.content.Context
import android.view.LayoutInflater
import com.frogobox.recycler.databinding.FrogoRvEmptyViewBinding
import com.frogobox.recycler.databinding.FrogoRvListType1Binding
import com.frogobox.recycler.databinding.FrogoRvListType2Binding

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
object FrogoRvViewBinding {

    fun frogoLayoutInflater(context: Context): LayoutInflater = LayoutInflater.from(context)

    fun frogoRvListType1(context: Context): FrogoRvListType1Binding =
        FrogoRvListType1Binding.inflate(frogoLayoutInflater(context))

    fun frogoRvListType2(context: Context): FrogoRvListType2Binding =
        FrogoRvListType2Binding.inflate(frogoLayoutInflater(context))

    fun frogoRvEmptyView(context: Context): FrogoRvEmptyViewBinding =
        FrogoRvEmptyViewBinding.inflate(frogoLayoutInflater(context))

}