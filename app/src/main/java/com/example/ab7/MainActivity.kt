package com.example.ab7


import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ab7.ui.theme.Ab7Theme
import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.compose.rememberNavController
import com.example.ab7.navigation.NavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ab7Theme {
                val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
                NavGraph(sharedPreferences)
            }
        }
    }
}

@Composable
fun MainScreen(sharedPreferences: SharedPreferences) {
    val navController = rememberNavController()
}

@Composable
fun ProfileScreen(sharedPreferences: SharedPreferences) {
    var name by remember { mutableStateOf(sharedPreferences.getString("username", "Default User") ?: "Default User") }
    var newName by remember { mutableStateOf(TextFieldValue()) }

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