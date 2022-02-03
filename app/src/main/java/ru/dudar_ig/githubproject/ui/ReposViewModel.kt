package ru.dudar_ig.githubproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Observable
import ru.dudar_ig.githubproject.TekLogin
import ru.dudar_ig.githubproject.data.ApiDataImpl
import ru.dudar_ig.githubproject.data.ApiDataRx
import ru.dudar_ig.githubproject.data.ApiRepozitories
import ru.dudar_ig.githubproject.domain.Repozitories

class ReposViewModel: ViewModel() {

    val items: LiveData<List<ApiRepozitories>>?
    val itemsRx: Observable<List<ApiRepozitories>>
    init {
        items = ApiDataImpl().loadRepos(TekLogin.login)
        itemsRx = ApiDataRx.create().getRepos(TekLogin.login)
    }
}