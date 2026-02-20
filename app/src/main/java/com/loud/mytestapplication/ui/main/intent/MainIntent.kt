package com.loud.mytestapplication.ui.main.intent

sealed interface MainIntent {
    data object LoadUserData : MainIntent
    data object NavigateToAnalyticsScreen : MainIntent
}