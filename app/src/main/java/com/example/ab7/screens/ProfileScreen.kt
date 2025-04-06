package com.example.ab7.screens

import android.content.SharedPreferences
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController, sharedPreferences: SharedPreferences) {
    var name by remember { mutableStateOf(sharedPreferences.getString("username", "Default User") ?: "Default User") }
    var password by remember { mutableStateOf(sharedPreferences.getString("password", "Default Password") ?: "Default Password") }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = "Hello, $name!", modifier = Modifier.padding(8.dp))
            Text(text = "This is your password: $password", modifier = Modifier.padding(8.dp))

            Button(onClick = {
                sharedPreferences.edit().remove("username").apply()
                sharedPreferences.edit().remove("password").apply()
                navController.navigate("auth")
            }) {
                Text("Logout")
            }
        }
    }
}