package com.loud.mytestapplication.ui.poker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.loud.mytestapplication.R
import com.loud.mytestapplication.ui.common.AppBar

@Composable
fun PokerScreen(
    navController: NavController, viewModel: PokerViewModel = hiltViewModel()
) {
    val listUserState by viewModel.listUserState.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.handleIntent(PokerIntent.LoadUserData)
    }
    PokerScreenContent(
        backClick = { navController.popBackStack() }
    )
}

@Preview
@Composable
fun PokerScreenContent(
    backClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AppBar(stringResource(R.string.poker), backClick = backClick)
    }
}