package com.frogobox.recycler.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.frogobox.recycler.databinding.*

/*
 * Created by Faisal Amir
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 19/04/2020.      
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
abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var activityMainBinding: ActivityMainBinding
    protected lateinit var activityFrogoRvGridBinding: ActivityFrogoRvGridBinding
    protected lateinit var activityFrogoRvListBinding: ActivityFrogoRvListBinding
    protected lateinit var activityMainDevBinding: ActivityMainDevBinding
    protected lateinit var activityKotlinShimmerBinding: ActivityKotlinShimmerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewBinding()
    }

    protected fun setupDetailActivity(title: String) {
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    protected fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
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