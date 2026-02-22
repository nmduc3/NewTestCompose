package com.loud.mytestapplication.graph

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.loud.mytestapplication.route.AppRoutes
import com.loud.mytestapplication.ui.analytics.AnalyticsScreen
import com.loud.mytestapplication.ui.home.HomeScreen
import com.loud.mytestapplication.ui.poker.PokerScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppRoutes.Home.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        composable(AppRoutes.Home.route) {
            HomeScreen(navController)
        }
        composable(AppRoutes.Poker.route) {
            PokerScreen(navController)
        }
        composable(AppRoutes.Analytics.route) {
            AnalyticsScreen()
        }
    }
}