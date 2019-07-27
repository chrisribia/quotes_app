package com.example.mine.ui

import com.example.mine.data.db.entities.entites.User

interface AuthListener {

    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}