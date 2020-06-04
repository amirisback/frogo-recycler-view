package com.frogobox.recycler.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.recycler.databinding.*

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
    protected lateinit var activityMainDevBinding: ActivityMainDevBinding
    protected lateinit var activityKotlinShimmerBinding: ActivityKotlinShimmerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewBinding()
    }

    private fun setupViewBinding(){
        // genereate view binding
        activityMainBinding = ActivityMainBinding.inflate(baseLayoutInflater())
        activityFrogoRvGridBinding = ActivityFrogoRvGridBinding.inflate(baseLayoutInflater())
        activityFrogoRvListBinding = ActivityFrogoRvListBinding.inflate(baseLayoutInflater())
        activityMainDevBinding = ActivityMainDevBinding.inflate(baseLayoutInflater())
        activityKotlinShimmerBinding = ActivityKotlinShimmerBinding.inflate(baseLayoutInflater())
    }

    private fun baseLayoutInflater() : LayoutInflater {
        return LayoutInflater.from(this)
    }

}