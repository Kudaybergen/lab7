package com.example.ab7.navigation

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ab7.screens.ProfileScreen

@Composable
fun NavGraph(sharedPreferences: SharedPreferences) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "profile") {
        composable("profile") { ProfileScreen(navController, sharedPreferences) }
//        composable("details") { DetailScreen(navController) }
    }
}