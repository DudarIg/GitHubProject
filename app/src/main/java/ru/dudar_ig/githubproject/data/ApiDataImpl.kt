package ru.dudar_ig.githubproject.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import ru.dudar_ig.githubproject.domain.Repozitories
import ru.dudar_ig.githubproject.domain.User


private const val BASEURL = "https://api.github.com"

interface ApiData {
    @GET("/users")
    fun getUsers(): Call<List<ApiUsers>>

    @GET("/users/{user}/repos")
    fun getRepos(@Path("user") user: String ): Call<List<ApiRepozitories>>
}

class ApiDataImpl {

    private val api: ApiData
    init {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASEURL)
            .build()
        api = retrofit.create(ApiData::class.java)
    }

    fun loadUsers(): LiveData<List<ApiUsers>> {
        val resultLiveData: MutableLiveData<List<ApiUsers>> = MutableLiveData()
        api.getUsers().enqueue(object : Callback<List<ApiUsers>> {
            override fun onResponse(call: Call<List<ApiUsers>>, response: Response<List<ApiUsers>>) {
                val jsonUsers: List<ApiUsers>? = response.body()
                val usersList = mutableListOf<ApiUsers>()
                jsonUsers?.forEach {
                    val users = ApiUsers(it.login, it.id, it.avatar_url)
                    usersList.add(users)
                }
                resultLiveData.postValue(usersList)
            }
            override fun onFailure(call: Call<List<ApiUsers>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return resultLiveData
    }

    fun loadRepos(user: String): LiveData<List<Repozitories>> {
        val resultLiveData: MutableLiveData<List<Repozitories>> = MutableLiveData()
        api.getRepos(user).enqueue(object : Callback<List<ApiRepozitories>>{
            override fun onResponse(
                call: Call<List<ApiRepozitories>>,
                response: Response<List<ApiRepozitories>> ) {
                val jsonRepozitories: List<ApiRepozitories>? = response.body()
                val repozitories = mutableListOf<Repozitories>()
                jsonRepozitories?.forEach {
                    val repo = Repozitories()
                    repo.id = it.id
                    repo.name = it.name
                    //repo.private = it.private
                    repozitories.add(repo)
                }
                resultLiveData.postValue(repozitories)
            }
            override fun onFailure(call: Call<List<ApiRepozitories>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
        return resultLiveData
    }

}