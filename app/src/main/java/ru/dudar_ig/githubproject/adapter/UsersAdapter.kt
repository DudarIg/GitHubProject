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
import ru.dudar_ig.githubproject.domain.Users

class UsersAdapter: RecyclerView.Adapter<UsersAdapter.UserHolder>() {
    private var homeData = ArrayList<Users>()

    class UserHolder(itemView: View, val holderContext : Context): RecyclerView.ViewHolder(itemView) {
        val login : TextView = itemView.findViewById(R.id.text_view)
        val avatar: ImageView = itemView.findViewById(R.id.image_view)
        fun setData(user: Users) {
            Glide.with(holderContext)
                .load(user.avatar_url)
                .into(avatar)
            login.text = user.login
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_user_item, parent, false), parent.context)
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val home = homeData[position]

        holder.setData(home)
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