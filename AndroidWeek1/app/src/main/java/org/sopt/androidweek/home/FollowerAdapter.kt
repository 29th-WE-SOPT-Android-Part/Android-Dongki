package org.sopt.androidweek.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidweek.databinding.ListItemFollwerBinding
import org.sopt.androidweek.util.BindingRecyclerViewAdapter

class FollowerAdapter(private val clickListener: (FollowerDao) -> Unit) :
    ListAdapter<FollowerDao,FollowerAdapter.ViewHolder>(diffUtil),
    BindingRecyclerViewAdapter<List<FollowerDao>> {
    private var followerList = emptyList<FollowerDao>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)

    override fun getItemCount(): Int = followerList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val followerDao = followerList[position]
        holder.bind(followerDao, clickListener)
    }

    class ViewHolder(private val dataBinding: ListItemFollwerBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {
        fun bind(followerDao: FollowerDao, clickListener: (FollowerDao) -> Unit) {
            dataBinding.apply {
                follower = followerDao
                root.setOnClickListener {
                    clickListener(followerDao)
                }
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val dataBinding = ListItemFollwerBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
                return ViewHolder(dataBinding)
            }
        }
    }

    override fun setData(data: List<FollowerDao>) {
        followerList = data
        submitList(data)
    }
    companion object {
        val diffUtil = object: DiffUtil.ItemCallback<FollowerDao>() {
            override fun areContentsTheSame(oldItem: FollowerDao, newItem: FollowerDao) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: FollowerDao, newItem: FollowerDao) =
                oldItem.name == newItem.name
        }
    }

}