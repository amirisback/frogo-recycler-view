package com.frogobox.recycler.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.recycler.databinding.ActivityFrogoRvGridBinding
import com.frogobox.recycler.databinding.ActivityFrogoRvListBinding
import com.frogobox.recycler.databinding.ActivityMainBinding

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
abstract class BaseActivityViewBinding : AppCompatActivity() {

    protected lateinit var activityMainBinding: ActivityMainBinding
    protected lateinit var activityFrogoRvGridBinding: ActivityFrogoRvGridBinding
    protected lateinit var activityFrogoRvListBinding: ActivityFrogoRvListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        activityFrogoRvGridBinding = ActivityFrogoRvGridBinding.inflate(LayoutInflater.from(this))
        activityFrogoRvListBinding = ActivityFrogoRvListBinding.inflate(LayoutInflater.from(this))
    }


}