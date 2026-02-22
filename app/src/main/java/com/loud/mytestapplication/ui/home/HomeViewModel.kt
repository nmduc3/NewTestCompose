package com.loud.mytestapplication.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loud.mytestapplication.effect.Effect
import com.loud.mytestapplication.route.AppRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _effect = Channel<Effect>()
    val effect = _effect.receiveAsFlow()

    fun handleIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.OnClickGoToPokerScreen -> viewModelScope.launch {
                _effect.send(Effect.Navigate(AppRoutes.Poker.route))
            }

            HomeIntent.OnClickGoToAnalyticsScreen -> viewModelScope.launch {
                _effect.send(Effect.Navigate(AppRoutes.Analytics.route))
            }
        }
    }
}