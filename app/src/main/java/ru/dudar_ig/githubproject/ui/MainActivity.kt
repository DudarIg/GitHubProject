package ru.dudar_ig.githubproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.dudar_ig.githubproject.R
import ru.dudar_ig.githubproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit private var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (userFragment == null) {
            val fragment = UsersFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }
    }

}