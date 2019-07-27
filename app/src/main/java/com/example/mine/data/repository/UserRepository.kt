package com.example.mine.data.repository

import com.example.mine.data.db.entities.AppDatabase
import com.example.mine.data.db.entities.entites.User
import com.example.mine.data.network.MyApi
import com.example.mine.data.network.SafeApiRequest
import com.example.mine.data.network.responses.AuthResponse

class UserRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
    }

    suspend fun userSignup(
        name: String,
        email: String,
        password: String
    ) : AuthResponse {
        return apiRequest{ api.userSignup(name, email, password)}
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getuser()

}