package com.example.ab7.navigation

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ab7.screens.AuthScreen
import com.example.ab7.screens.ProfileScreen

@Composable
fun NavGraph(sharedPreferences: SharedPreferences) {
    val navController = rememberNavController()

    var name by remember { mutableStateOf(sharedPreferences.getString("username", "Default User") ?: "Default User") }

    var startScreen = "profile"
    if (name === "Default User") startScreen = "auth"

    NavHost(navController = navController, startDestination = startScreen ) {
        composable("profile") { ProfileScreen(navController, sharedPreferences) }
        composable("auth") { AuthScreen(navController, sharedPreferences) }
    }
}