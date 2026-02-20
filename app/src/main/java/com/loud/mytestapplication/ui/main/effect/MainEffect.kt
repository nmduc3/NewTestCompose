package com.loud.mytestapplication.ui.main.effect

sealed interface MainEffect {
    data class Navigate(val route: String): MainEffect
}