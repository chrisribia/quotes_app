package com.example.mine.ui

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mine.data.repository.UserRepository
import com.example.mine.utils.ApiException
import com.example.mine.utils.Coroutines
import com.example.mine.utils.NoInternetException

class AuthViewModel(
    private val repository: UserRepository
) : ViewModel(){
    var email : String? = null
    var password : String? = null

    var authListner :AuthListener? = null


    fun getLoggedInUser() = repository.getUser()

    fun userLogin(view : View){
        authListner?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListner?.onFailure("failed")
            return
        }
        Coroutines.main {
            try {
                val authResponse = repository.userLogin(email!!, password!!)
                authResponse.user?.let {
                    authListner?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }
                authListner?.onFailure(authResponse.message!!)
            }catch(e: ApiException){
                authListner?.onFailure(e.message!!)
            }catch (e: NoInternetException){
                authListner?.onFailure(e.message!!)
            }
        }
    }


}