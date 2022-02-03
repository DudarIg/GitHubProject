package ru.dudar_ig.githubproject.data

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASEURL = "https://api.github.com"

interface ApiDataRx {
    @GET("/users")
    fun getUsers(): Observable<List<ApiUsers>>

    @GET("/users/{user}/repos")
    fun getRepos(@Path("user") user: String ): Observable<List<ApiRepozitories>>

    companion object Factory {
        fun create(): ApiDataRx {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASEURL)
                .build()

            return retrofit.create(ApiDataRx::class.java);
        }
    }

}

