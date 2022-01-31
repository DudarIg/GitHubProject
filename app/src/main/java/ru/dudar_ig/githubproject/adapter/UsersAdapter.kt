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
import ru.dudar_ig.githubproject.data.ApiUsers
import ru.dudar_ig.githubproject.domain.User

class UsersAdapter: RecyclerView.Adapter<UsersAdapter.UserHolder>() {
    private var usersData = ArrayList<ApiUsers>()

    var funUserClick: ((ApiUsers) -> Unit)? = null

    class UserHolder(itemView: View, val holderContext : Context): RecyclerView.ViewHolder(itemView) {
        val login : TextView = itemView.findViewById(R.id.text_view)
        val avatar: ImageView = itemView.findViewById(R.id.image_view)
        val itemview = itemView

        fun setData(user: ApiUsers) {
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
        holder.setData(usersData[position])
        holder.itemview.setOnClickListener {
            funUserClick?.invoke(usersData[position])
        }
    }

    override fun getItemCount(): Int {
        return usersData.size
    }
    fun updateAdapter(dataList: List<ApiUsers>) {
        usersData.clear()
        usersData.addAll(dataList)
        notifyDataSetChanged()
    }
}