package com.frogobox.recycler.compose

import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.frogobox.recycler.core.FrogoRvConstant.FROGO_RV_COMPOSE_TAG
import com.frogobox.recycler.util.FLog

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
    data: List<T>,
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    reverseLayout: Boolean = false,
    verticalArrangement: Arrangement.Vertical =
        if (!reverseLayout) Arrangement.Top else Arrangement.Bottom,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    flingBehavior: FlingBehavior = ScrollableDefaults.flingBehavior(),
    content: @Composable() LazyItemScope.(data: T) -> Unit

) {
    FLog.d("$FROGO_RV_COMPOSE_TAG - FrogoLazyColumn")
    FLog.d("$FROGO_RV_COMPOSE_TAG - sum data : ${data.size}")
    LazyColumn(
        modifier = modifier,
        state = state,
        contentPadding = contentPadding,
        flingBehavior = flingBehavior,
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = verticalArrangement,
        reverseLayout = reverseLayout
    ) {
        items(data.size) { index ->
            FLog.d("$FROGO_RV_COMPOSE_TAG - list data $index : ${data[index]}")
            content(data[index])
        }
    }
}

@Composable
fun <T> FrogoLazyRow(
    data: List<T>,
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
    contentPadding: PaddingValues = PaddingValues(0.dp),
    reverseLayout: Boolean = false,
    horizontalArrangement: Arrangement.Horizontal =
        if (!reverseLayout) Arrangement.Start else Arrangement.End,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    flingBehavior: FlingBehavior = ScrollableDefaults.flingBehavior(),
    content: @Composable() LazyItemScope.(data: T) -> Unit
) {
    FLog.d("$FROGO_RV_COMPOSE_TAG - FrogoLazyRow")
    FLog.d("$FROGO_RV_COMPOSE_TAG - sum data : ${data.size}")
    LazyRow(
        modifier = modifier,
        state = state,
        contentPadding = contentPadding,
        verticalAlignment = verticalAlignment,
        horizontalArrangement = horizontalArrangement,
        flingBehavior = flingBehavior,
        reverseLayout = reverseLayout
    ) {
        items(data.size) { index ->
            FLog.d("$FROGO_RV_COMPOSE_TAG - list data : ${data[index]}")
            content(data[index])
        }
    }
}

//@ExperimentalFoundationApi
//@Composable
//fun <T> FrogoLazyFixedGrid(
//    data: List<T>,
//    spanCount: Int,
//    modifier: Modifier = Modifier,
//    state: LazyListState = rememberLazyListState(),
//    contentPadding: PaddingValues = PaddingValues(0.dp),
//    content: @Composable() LazyGridScope.(data: T) -> Unit
//) {
//    FLog.d("$FROGO_RV_COMPOSE_TAG - FrogoLazyFixedGrid")
//    FLog.d("$FROGO_RV_COMPOSE_TAG - sum data : ${data.size}")
//    LazyVerticalGrid(
//        modifier = modifier,
//        contentPadding = contentPadding,
//        state = state,
//        cells = GridCells.Fixed(spanCount),
//    ) {
//        items(data.size) { index ->
//            FLog.d("$FROGO_RV_COMPOSE_TAG - list data : ${data[index]}")
//            this@LazyVerticalGrid.content(data[index])
//        }
//    }
//}
//
//@ExperimentalFoundationApi
//@Composable
//fun <T> FrogoLazyAdaptiveGrid(
//    data: List<T>,
//    minSize: Dp,
//    modifier: Modifier = Modifier,
//    state: LazyListState = rememberLazyListState(),
//    contentPadding: PaddingValues = PaddingValues(0.dp),
//    content: @Composable() LazyGridScope.(data: T) -> Unit
//) {
//    FLog.d("$FROGO_RV_COMPOSE_TAG - FrogoLazyAdaptiveGrid")
//    FLog.d("$FROGO_RV_COMPOSE_TAG - sum data : ${data.size}")
//
//    LazyVerticalGrid(
//        modifier = modifier,
//        contentPadding = contentPadding,
//        state = state,
//        cells = GridCells.Adaptive(minSize),
//    ) {
//        items(data.size) { index ->
//            FLog.d("$FROGO_RV_COMPOSE_TAG - list data : ${data[index]}")
//            this@LazyVerticalGrid.content(data[index])
//        }
//    }
//
//}