package com.loud.mytestapplication.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.loud.mytestapplication.effect.Effect

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is Effect.Navigate -> {
                    navController.navigate(effect.route)
                }
            }
        }
    }

    HomeScreenContent(
        onPokerClick = { viewModel.handleIntent(HomeIntent.OnClickGoToPokerScreen) },
        onAnalyticsClick = { viewModel.handleIntent(HomeIntent.OnClickGoToAnalyticsScreen) }
    )
}

@Preview
@Composable
fun HomeScreenContent(
    onPokerClick: () -> Unit = {},
    onAnalyticsClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onPokerClick) {
            Text(text = "Poker")
        }
        Button(onAnalyticsClick) {
            Text(text = "Analytics")
        }
    }
}