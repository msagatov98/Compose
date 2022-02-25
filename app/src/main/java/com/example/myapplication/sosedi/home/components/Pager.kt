package com.example.myapplication.sosedi.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Pager(
    pageState: PagerState
) {



    val pages = listOf(
        Place("Feed"),
        Place("Marketplace")
    )

    HorizontalPager(
        count = 2,
        state = pageState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        PagerUi(place = pages[page])
    }
}

@Composable
fun PagerUi(place: Place) {
    Row(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = place.name)
    }
}