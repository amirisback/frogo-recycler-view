package com.frogobox.apprecycler.util

import com.frogobox.apprecycler.model.ExampleModel

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * FrogoRecyclerViewAdapter
 * Copyright (C) 01/04/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.frogobox.recycler
 *
 */

object Constant {

    const val FULL_NAME = "Muhammad Faisal Amir"
    const val NICK_NAME = "Faisal Amir"

    fun dummyData(cons : String): MutableList<ExampleModel> {
        val listString = mutableListOf<ExampleModel>()
        for (i in 0..5) {
            listString.add(ExampleModel("$cons - $i"))
        }
        return listString
    }

}