package com.frogobox.recycler.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import com.frogobox.frogolog.FLog
import com.frogobox.recycler.core.FrogoRvConstant.FROGO_RV_COMPOSE_TAG

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
fun <T> FrogoLazyColumn(
    listData: List<T>,
    listItem: @Composable() LazyItemScope.(data: T) -> Unit
) {
    FLog.d("$FROGO_RV_COMPOSE_TAG - list data : ${listData.size}")
    LazyColumn() {
        items(listData.size) { index ->
            FLog.d("$FROGO_RV_COMPOSE_TAG - list data : ${listData[index]}")
            listItem(listData[index])
        }
    }
}

@Composable
fun <T> FrogoLazyRow(
    listData: List<T>,
    listItem: @Composable() LazyItemScope.(data: T) -> Unit
) {
    FLog.d("$FROGO_RV_COMPOSE_TAG - list data : ${listData.size}")
    LazyRow() {
        items(listData.size) { index ->
            FLog.d("$FROGO_RV_COMPOSE_TAG - list data : ${listData[index]}")
            listItem(listData[index])
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun <T> FrogoLazyGrid(
    spanCount: Int,
    listData: List<T>,
    listItem: @Composable() LazyGridScope.(data: T) -> Unit
) {
    FLog.d("$FROGO_RV_COMPOSE_TAG - list data : ${listData.size}")
    LazyVerticalGrid(GridCells.Fixed(spanCount)) {
        items(listData.size) { index ->
            FLog.d("$FROGO_RV_COMPOSE_TAG - list data : ${listData[index]}")
            listItem(listData[index])
        }
    }
}