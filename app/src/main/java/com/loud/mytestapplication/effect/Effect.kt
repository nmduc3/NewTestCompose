package com.loud.mytestapplication.effect


sealed interface Effect {
    data class Navigate(val route: String) : Effect
}