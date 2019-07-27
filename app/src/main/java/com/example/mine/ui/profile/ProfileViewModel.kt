package com.example.mine.ui.profile

import androidx.lifecycle.ViewModel;
import com.example.mine.data.repository.UserRepository


class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()

}