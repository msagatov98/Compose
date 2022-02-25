package com.example.myapplication.sosedi.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.sosedi.chat.ChatScreen
import com.example.myapplication.sosedi.createadvert.CreateAdvertScreen
import com.example.myapplication.sosedi.home.HomeScreen
import com.example.myapplication.sosedi.profile.ProfileScreen
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun Navigation(
    navController: NavHostController,
    systemUiController: SystemUiController
) {
    NavHost(
        navController = navController,
        startDestination = "home",
    ) {

        composable("home") {
            HomeScreen(systemUiController)
        }
        composable("create_advert") {
            CreateAdvertScreen()
        }
        composable("chat") {
            ChatScreen()
        }
        composable("profile") {
            ProfileScreen()
        }
    }
}
