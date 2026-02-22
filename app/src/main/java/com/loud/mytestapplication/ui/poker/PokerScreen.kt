package com.loud.mytestapplication.ui.poker

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController

@Composable
fun PokerScreen(
    navController: NavController,
    viewModel: PokerViewModel = hiltViewModel()
) {
    val listUserState by viewModel.listUserState.collectAsStateWithLifecycle()
    Log.wtf("okMAPPP -->", "PokerScreen: ${listUserState.joinToString()}")
    LaunchedEffect(Unit) {
        viewModel.handleIntent(PokerIntent.LoadUserData)
    }
    PokerScreenContent()
}

@Preview
@Composable
fun PokerScreenContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Poker Screen Content", color = Color.White)
    }
}