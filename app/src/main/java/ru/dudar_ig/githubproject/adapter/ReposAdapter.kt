package ru.dudar_ig.githubproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.dudar_ig.githubproject.R
import ru.dudar_ig.githubproject.domain.Repozitories
import ru.dudar_ig.githubproject.domain.User

class ReposAdapter: RecyclerView.Adapter<ReposAdapter.RepoHolder>() {
    private var repoData = ArrayList<Repozitories>()


    class RepoHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val names = itemView.findViewById<TextView>(R.id.namerepo_textview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoHolder {
        return RepoHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_repo_item, parent, false))
    }

    override fun onBindViewHolder(holder: RepoHolder, position: Int) {
        val repo = repoData[position]
        holder.names.text = repo.name
    }

    override fun getItemCount(): Int {
        return repoData.size
    }
    fun updateAdapter(dataList: List<Repozitories>) {
        repoData.clear()
        repoData.addAll(dataList)
        notifyDataSetChanged()
    }
}