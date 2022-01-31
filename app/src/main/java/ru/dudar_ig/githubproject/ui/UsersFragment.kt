package ru.dudar_ig.githubproject.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import ru.dudar_ig.githubproject.R
import ru.dudar_ig.githubproject.adapter.UsersAdapter
import ru.dudar_ig.githubproject.databinding.UsersFragmentBinding

class UsersFragment : Fragment(R.layout.users_fragment) {

    private val usersViewModel by viewModels<UsersViewModel>()
    private val usersAdapter = UsersAdapter()
    private var _binding: UsersFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = UsersFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = UsersFragmentBinding.bind(view)

        binding.recycle.layoutManager = LinearLayoutManager(context)
        binding.recycle.adapter = usersAdapter

        usersViewModel.items.observe(this, Observer {
            usersAdapter.updateAdapter(it)
        })

        usersAdapter.funUserClick = {
            val fragment = ReposFragment.newInstance(it)
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container,
                fragment)?.addToBackStack(null)?.commit()
        }

    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
