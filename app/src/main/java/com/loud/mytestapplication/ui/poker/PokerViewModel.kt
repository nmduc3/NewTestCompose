package com.loud.mytestapplication.ui.poker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loud.mytestapplication.effect.Effect
import com.loud.mytestapplication.model.User
import com.loud.mytestapplication.repository.UserRepository
import com.loud.mytestapplication.route.AppRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokerViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {
    private val _listUserState = MutableStateFlow<List<User>>(emptyList())
    val listUserState: StateFlow<List<User>> = _listUserState

    private val _effect = Channel<Effect>()
    val effect = _effect.receiveAsFlow()

    fun handleIntent(intent: PokerIntent) {
        when (intent) {
            PokerIntent.LoadUserData -> loadData()
            PokerIntent.NavigateToAnalyticsScreen -> viewModelScope.launch {
                _effect.send(Effect.Navigate(AppRoutes.Analytics.route))
            }
        }
    }

    private fun loadData() {
        viewModelScope.launch {
            _listUserState.value = userRepository.getUser()
        }
    }
}