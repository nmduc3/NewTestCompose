package com.loud.mytestapplication.ui.home

sealed interface HomeIntent {
    data object OnClickGoToPokerScreen : HomeIntent
    data object OnClickGoToAnalyticsScreen : HomeIntent
}