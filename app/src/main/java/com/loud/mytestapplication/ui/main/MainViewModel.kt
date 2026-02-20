package com.loud.mytestapplication.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loud.mytestapplication.model.User
import com.loud.mytestapplication.repository.UserRepository
import com.loud.mytestapplication.route.Route
import com.loud.mytestapplication.ui.main.effect.MainEffect
import com.loud.mytestapplication.ui.main.intent.MainIntent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _listUserState = MutableStateFlow<List<User>>(emptyList())
    val listUserState: StateFlow<List<User>> = _listUserState

    private val _effect = Channel<MainEffect>()

    fun handleIntent(intent: MainIntent) {
        when (intent) {
            MainIntent.LoadUserData -> loadData()
            MainIntent.NavigateToAnalyticsScreen -> viewModelScope.launch {
                _effect.send(MainEffect.Navigate(Route.ANALYTICS.path))
            }
        }
    }

    private fun loadData() {
        viewModelScope.launch {
            _listUserState.value = userRepository.getUser()
        }
    }
}