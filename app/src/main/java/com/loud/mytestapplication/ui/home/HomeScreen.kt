package com.loud.mytestapplication.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.loud.mytestapplication.R
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
        Button(
            onPokerClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 2.dp
            )
        ) {
            Image(
                painter = painterResource(R.drawable.ic_game),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(R.string.poker), fontSize = 14.sp)
        }
        Button(
            onAnalyticsClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 2.dp
            )
        ) {
            Image(
                painter = painterResource(R.drawable.ic_chart),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(R.string.analytics), fontSize = 14.sp)
        }
    }
}