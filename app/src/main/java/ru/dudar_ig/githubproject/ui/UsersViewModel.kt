package ru.dudar_ig.githubproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.dudar_ig.githubproject.data.ApiDataImpl
import ru.dudar_ig.githubproject.domain.User

class UsersViewModel: ViewModel() {

    val items: LiveData<List<User>>
    init {
        items = ApiDataImpl().loadUsers()
    }

}