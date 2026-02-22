package com.loud.mytestapplication.ui.poker

sealed interface PokerIntent {
    data object LoadUserData : PokerIntent
    data object NavigateToAnalyticsScreen : PokerIntent
}