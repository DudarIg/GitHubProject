package ru.dudar_ig.githubproject.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.dudar_ig.githubproject.domain.Users

class UsersViewModel: ViewModel() {

    val usersViewModel: LiveData<List<Users>>
    init {
        usersViewModel = ApiDataImpl().loadUsers()
    }

}