package ru.dudar_ig.githubproject.data

import com.google.gson.annotations.SerializedName

data class ApiRepozitories(
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String
)
