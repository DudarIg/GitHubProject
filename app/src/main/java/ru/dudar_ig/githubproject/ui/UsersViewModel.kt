package ru.dudar_ig.githubproject.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import ru.dudar_ig.githubproject.RepoObserver.repoUsers
import ru.dudar_ig.githubproject.data.ApiDataImpl
import ru.dudar_ig.githubproject.data.ApiDataRx
import ru.dudar_ig.githubproject.data.ApiUsers

class UsersViewModel: ViewModel() {

    //val items: LiveData<List<ApiUsers>>
    //val itemsRx: Observable<List<ApiUsers>>
    val itemsRxx : Observable<List<ApiUsers>>
    init {
  //      items = ApiDataImpl().loadUsers()
  //      itemsRx = ApiDataRx.create().getUsers()

      //  Log.d("@@@", "$repoUsers")
        itemsRxx = ApiDataImpl().loadUsersRx()
    }






}