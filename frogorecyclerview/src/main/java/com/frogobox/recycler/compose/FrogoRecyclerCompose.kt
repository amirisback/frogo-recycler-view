package com.frogobox.recycler.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.runtime.Composable

/*
 * Created by faisalamir on 21/08/21
 * FrogoRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.      
 * All rights reserved
 *
 */

@Composable
fun <T> FrogoRecyclerCompose(data: List<T>, listItem: @Composable() LazyItemScope.(data: T) -> Unit) {
    LazyColumn() {
        items(data.size) { index ->
            listItem(data[index])
        }
    }
}
