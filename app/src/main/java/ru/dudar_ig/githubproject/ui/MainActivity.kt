package ru.dudar_ig.githubproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.dudar_ig.githubproject.adapter.UsersAdapter
import ru.dudar_ig.githubproject.data.UsersViewModel
import ru.dudar_ig.githubproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit private var binding: ActivityMainBinding
    private val usersViewModel by viewModels<UsersViewModel>()
    private val usersAdapter = UsersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycle.layoutManager = LinearLayoutManager(this)
        binding.recycle.adapter = usersAdapter

        usersViewModel.items.observe(this, Observer {
            usersAdapter.updateHomeAdapter(it)
        })

    }
}