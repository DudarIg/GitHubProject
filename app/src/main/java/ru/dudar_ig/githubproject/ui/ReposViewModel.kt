package ru.dudar_ig.githubproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.dudar_ig.githubproject.TekLogin
import ru.dudar_ig.githubproject.data.ApiDataImpl
import ru.dudar_ig.githubproject.domain.Repozitories

class ReposViewModel: ViewModel() {

    val items: LiveData<List<Repozitories>>?
    init {
        items = ApiDataImpl().loadRepos(TekLogin.login)
    }
}