package com.example.ab7.screens

import android.content.SharedPreferences
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = "Hello, $name!", modifier = Modifier.padding(8.dp))

//            Surface(
//                modifier = Modifier.fillMaxWidth(),
//                shape = RoundedCornerShape(8.dp),
//                color = Color.LightGray
//            ) {
//                BasicTextField(
//                    value = newName,
//                    onValueChange = { newName = it },
//                    modifier = Modifier
//                        .padding(16.dp)
//                        .fillMaxWidth()
//                )
//            }
//
//            Button(onClick = {
//                sharedPreferences.edit().putString("username", newName.text).apply()
//                name = newName.text
//            }) {
//                Text("Save Name")
//            }


        }
    }
}