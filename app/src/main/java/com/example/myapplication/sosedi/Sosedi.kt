package com.example.myapplication.sosedi

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.sosedi.bottomnavigation.BottomNavItem
import com.example.myapplication.sosedi.bottomnavigation.BottomNavigationScreen
import com.example.myapplication.sosedi.bottomnavigation.Navigation
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun Sosedi() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationScreen(
                items = listOf(
                    BottomNavItem(
                        name = "Home",
                        route = "home",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_home_new)
                    ),
                    BottomNavItem(
                        name = "Create advert",
                        route = "create_advert",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_create_new)
                    ),
                    BottomNavItem(
                        name = "Chat",
                        route = "chat",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_message_new)
                    ),
                    BottomNavItem(
                        name = "Profile",
                        route = "profile",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_user_new)
                    ),
                ),
                navController = navController,
                onItemClick = {
                    Log.v("qwer", it.route)
                    navController.navigate(it.route)
                }
            )
        }
    ) {

        val rememberSystemUiController = rememberSystemUiController()

        Navigation(navController = navController, systemUiController = rememberSystemUiController)
    }
}
