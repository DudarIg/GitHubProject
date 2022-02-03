package ru.dudar_ig.githubproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Observable
import ru.dudar_ig.githubproject.data.ApiDataImpl
import ru.dudar_ig.githubproject.data.ApiDataRx
import ru.dudar_ig.githubproject.data.ApiUsers

class UsersViewModel: ViewModel() {

    val items: LiveData<List<ApiUsers>>
    val itemsRx: Observable<List<ApiUsers>>
    init {
        items = ApiDataImpl().loadUsers()
        itemsRx = ApiDataRx.create().getUsers()
    }






}