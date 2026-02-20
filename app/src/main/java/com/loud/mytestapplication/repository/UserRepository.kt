package com.loud.mytestapplication.repository

import com.loud.mytestapplication.di.IODispatcher
import com.loud.mytestapplication.model.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface UserRepository {
    suspend fun getUser(): List<User>
}

class UserRepositoryImpl @Inject constructor(
    @param:IODispatcher private val dispatcher: CoroutineDispatcher
) : UserRepository {
    override suspend fun getUser(): List<User> = withContext(dispatcher) {
        listOf(
            User(1, "Duc"),
            User(2, "Khoa"),
            User(3, "Nguyen"),
            User(4, "Phuong"),
            User(5, "Son"),
            User(6, "Vuong"),
            User(7, "Lam"),
            User(8, "Trung"),
            User(9, "Quan"),
        )
    }
}