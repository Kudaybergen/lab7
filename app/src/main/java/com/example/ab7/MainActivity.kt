package com.example.ab7


import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ab7.ui.theme.Ab7Theme
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