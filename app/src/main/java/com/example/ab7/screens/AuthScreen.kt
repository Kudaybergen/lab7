package com.example.ab7.screens

import android.content.SharedPreferences
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AuthScreen(navController: NavController, sharedPreferences: SharedPreferences) {
    var nameToLogin by remember { mutableStateOf(TextFieldValue()) }
    var passwordToLogin by remember { mutableStateOf(TextFieldValue()) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(text = "Hello, please enter your name", modifier = Modifier.padding(8.dp))
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                color = Color.LightGray
            ) {
                BasicTextField(
                    value = nameToLogin,
                    onValueChange = { nameToLogin = it },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
            }

            Text(text = "Enter your password", modifier = Modifier.padding(8.dp))
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                color = Color.LightGray
            ) {
                BasicTextField(
                    value = passwordToLogin,
                    onValueChange = { passwordToLogin = it },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
            }

            Button(onClick = {
                if (nameToLogin.text.isNotEmpty() && passwordToLogin.text.isNotEmpty()) {
                    sharedPreferences.edit().putString("username", nameToLogin.text).apply()
                    sharedPreferences.edit().putString("password", passwordToLogin.text).apply()
                    navController.navigate("profile")
                }
            }) {
                Text("Login")
            }
        }
    }
}