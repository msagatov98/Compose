package com.example.myapplication.sosedi.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.myapplication.sosedi.home.components.Pager
import com.example.myapplication.sosedi.home.components.TopBar
import com.example.myapplication.ui.theme.NewslineBackground
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.SystemUiController

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    systemUiController: SystemUiController
) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )

    systemUiController.setStatusBarColor(color = Color.White)

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Box(modifier = Modifier.fillMaxSize().background(Color.Yellow))
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(NewslineBackground),
        ) {
            val pageState = rememberPagerState()
            TopBar(pageState, bottomSheetScaffoldState)
            Pager(pageState)
        }
    }
}