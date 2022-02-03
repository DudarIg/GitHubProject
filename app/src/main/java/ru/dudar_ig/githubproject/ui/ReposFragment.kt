package ru.dudar_ig.githubproject.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.dudar_ig.githubproject.R
import ru.dudar_ig.githubproject.TekLogin
import ru.dudar_ig.githubproject.ui.adapter.ReposAdapter
import ru.dudar_ig.githubproject.data.ApiUsers
import ru.dudar_ig.githubproject.databinding.FragmentReposBinding

private const val ARG_USER = "param"

class ReposFragment : Fragment(R.layout.fragment_repos) {

    private lateinit var user : ApiUsers

    private val reposAdapter = ReposAdapter()
    private var _binding: FragmentReposBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            user = it.getSerializable(ARG_USER) as ApiUsers
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentReposBinding.bind(view)

        TekLogin.login = user.login
        val reposViewModel by viewModels<ReposViewModel>()
        Glide.with(requireContext())
                .load(user.avatar_url)
                .into(binding.imageAvatar)
        binding.textLogin.text = user.login

        binding.recycle.layoutManager = LinearLayoutManager(context)
        binding.recycle.adapter = reposAdapter
//        reposViewModel.items?.observe(viewLifecycleOwner, Observer {
//            reposAdapter.updateAdapter(it)
//        } )

        reposViewModel.itemsRx
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                reposAdapter.updateAdapter(it)
            })

    }


    companion object {
        @JvmStatic
        fun newInstance(userParam: ApiUsers) =
            ReposFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_USER, userParam)
                }
            }
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}