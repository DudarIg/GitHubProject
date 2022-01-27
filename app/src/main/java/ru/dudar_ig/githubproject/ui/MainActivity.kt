package ru.dudar_ig.githubproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.dudar_ig.githubproject.R
import ru.dudar_ig.githubproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}