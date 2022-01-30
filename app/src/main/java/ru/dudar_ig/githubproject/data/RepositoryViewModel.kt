package ru.dudar_ig.githubproject.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.dudar_ig.githubproject.domain.Repozitories

class RepositoryViewModel(user: String): ViewModel() {
    val repositoryViewModel: LiveData<List<Repozitories>>
    init {
        repositoryViewModel = ApiDataImpl().loadRepos(user)
    }
}