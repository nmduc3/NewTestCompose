package com.loud.mytestapplication.route

sealed class AppRoutes(val route: String) {
    data object Home : AppRoutes("home")
    data object Analytics : AppRoutes("analytics")
    data object Poker : AppRoutes("poker")
}