package com.frogobox.recycler.util

import android.content.Context

/*
 * Created by Faisal Amir on 14/02/2021
 * LogCat Source Code
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */
interface IFLog {

    // Function Log Simple Debug without message params
    fun d()

    // Function Log Simple Debug without message params with Toast
    fun d(context: Context)

    // Function Log Debug
    fun d(msg: String?)

    // Function Log Debug with Toast
    fun d(msg: String?, context: Context)

    // Function Log Simple Verbose without message params
    fun v()

    // Function Log Simple Verbose without message params with Toast
    fun v(context: Context)

    // Function Log Verbose
    fun v(msg: String?)

    // Function Log Verbose with Toast
    fun v(msg: String?, context: Context)

    // Function Log Simple Info without message params
    fun i()

    // Function Log Simple Info without message params with Toast
    fun i(context: Context)

    // Function Log Info
    fun i(msg: String?)

    // Function Log Info with Toast
    fun i(msg: String?, context: Context)

    // Function Log Simple Warn without message params
    fun w()

    // Function Log Simple Warn without message params with Toast
    fun w(context: Context)

    // Function Log Warn
    fun w(msg: String?)

    // Function Log Warn with Toast
    fun w(msg: String?, context: Context)

    // Function Log Warn
    fun w(e: Throwable?)

    // Function Log Warn with Toast
    fun w(e: Throwable?, context: Context)

    // Function Log Warn
    fun w(e: Exception?)

    // Function Log Warn with Toast
    fun w(e: Exception?, context: Context)

    // Function Log Simple Error without message params
    fun e()

    // Function Log Simple Error without message params with Toast
    fun e(context: Context)

    // Function Log Error
    fun e(msg: String?)

    // Function Log Error with Toast
    fun e(msg: String?, context: Context)

}