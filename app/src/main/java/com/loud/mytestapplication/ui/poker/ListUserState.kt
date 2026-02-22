package com.loud.mytestapplication.ui.poker

data class ListUserState(
    val users: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)