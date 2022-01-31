package ru.dudar_ig.githubproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.dudar_ig.githubproject.data.ApiDataImpl
import ru.dudar_ig.githubproject.data.ApiUsers
import ru.dudar_ig.githubproject.domain.User

class UsersViewModel: ViewModel() {
    val items: LiveData<List<ApiUsers>>
    init {
        items = ApiDataImpl().loadUsers()
    }

}