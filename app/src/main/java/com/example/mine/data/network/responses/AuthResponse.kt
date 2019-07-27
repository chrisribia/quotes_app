package com.example.mine.data.network.responses

import com.example.mine.data.db.entities.entites.User

data class AuthResponse (
    val isSuccessful : Boolean?,
    val message: String?,
    val user: User?
)