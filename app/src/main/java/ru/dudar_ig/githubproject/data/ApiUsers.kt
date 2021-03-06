package ru.dudar_ig.githubproject.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ApiUsers(
    @SerializedName("login") val login : String,
    @SerializedName("id") val id : Int,
    @SerializedName("avatar_url") val avatar_url : String
) : Serializable