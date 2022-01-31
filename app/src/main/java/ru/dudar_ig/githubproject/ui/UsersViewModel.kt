package ru.dudar_ig.githubproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.dudar_ig.githubproject.data.ApiDataImpl
import ru.dudar_ig.githubproject.domain.Users

class UsersViewModel: ViewModel() {

    val items: LiveData<List<Users>>
    init {
        items = ApiDataImpl().loadUsers()
    }

}