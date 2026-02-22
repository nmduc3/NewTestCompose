package com.loud.mytestapplication.ui.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.loud.mytestapplication.graph.AppNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // change status bar color
        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = false // Icon light
            isAppearanceLightNavigationBars = false // Navigation bar icon light
        }
        setContent {
            val navController = rememberNavController()
            AppNavGraph(navController = navController)
        }
    }
}