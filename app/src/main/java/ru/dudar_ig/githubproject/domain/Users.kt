package ru.dudar_ig.githubproject.domain

import com.google.gson.annotations.SerializedName

data class Users(
    var login : String="",
    var id : Int = 0,
    var avatar_url : String =""
    )
