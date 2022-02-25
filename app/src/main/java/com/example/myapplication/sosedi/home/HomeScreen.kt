package com.example.myapplication.sosedi.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.myapplication.sosedi.home.components.Pager
import com.example.myapplication.sosedi.home.components.TopBar
import com.example.myapplication.ui.theme.NewslineBackground
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(
    systemUiController: SystemUiController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NewslineBackground),
    ) {

        val pageState = rememberPagerState()

        systemUiController.setStatusBarColor(color = Color.White)

        TopBar(
            pageState
        )

        Pager(pageState)
    }
}