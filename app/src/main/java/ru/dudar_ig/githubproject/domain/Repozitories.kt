package ru.dudar_ig.githubproject.domain

import com.google.gson.annotations.SerializedName

data class Repozitories(
   var id : Int = 0,
   var name : String ="",
   var private : Boolean = false
    )
