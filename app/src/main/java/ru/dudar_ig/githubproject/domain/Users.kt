package ru.dudar_ig.githubproject.domain

import java.io.Serializable

data class Users(
    var login : String="",
    var id : Int = 0,
    var avatar_url : String =""
    ) : Serializable
