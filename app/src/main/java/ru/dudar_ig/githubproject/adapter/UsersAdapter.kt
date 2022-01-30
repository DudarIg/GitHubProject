package ru.dudar_ig.githubproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import ru.dudar_ig.githubproject.R
import ru.dudar_ig.githubproject.domain.Users

class UsersAdapter: RecyclerView.Adapter<UsersAdapter.UserHolder>() {
    private var homeData = ArrayList<Users>()

    class UserHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val login : TextView = itemView.findViewById(R.id.text_view)
        val avatar: ImageView = itemView.findViewById(R.id.image_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_user_item, parent, false))
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val home = homeData[position]
        holder.avatar.load(home.avatar_url)
        holder.login.text = home.login
    }

    override fun getItemCount(): Int {
        return homeData.size
    }
    fun updateHomeAdapter(dataList: List<Users>) {
        homeData.clear()
        homeData.addAll(dataList)
        notifyDataSetChanged()
    }
}