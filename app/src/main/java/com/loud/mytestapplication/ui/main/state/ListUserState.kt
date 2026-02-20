package com.loud.mytestapplication.ui.main.state

data class ListUserState(
    val users: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)