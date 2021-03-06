package org.sopt.androidweek.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.androidweek.databinding.ListItemRepositoryBinding
import org.sopt.androidweek.util.BindingRecyclerViewAdapter

class RepositoryAdapter(private val clickListener: (RepositoryDao) -> Unit) :
    ListAdapter<RepositoryDao, RepositoryAdapter.ViewHolder>(RepositoryAdapter.diffUtil),
    BindingRecyclerViewAdapter<List<RepositoryDao>> {
    private var repositoryList = emptyList<RepositoryDao>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)

    override fun getItemCount(): Int = repositoryList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repositoryDao = repositoryList[position]
        holder.bind(repositoryDao, clickListener)
    }

    class ViewHolder(private val dataBinding: ListItemRepositoryBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {
        fun bind(repositoryDao: RepositoryDao, clickListener: (RepositoryDao) -> Unit) {
            dataBinding.apply {
                repository = repositoryDao
                root.setOnClickListener {
                    clickListener(repositoryDao)
                }
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val dataBinding = ListItemRepositoryBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
                return ViewHolder(dataBinding)
            }
        }
    }

    override fun setData(data: List<RepositoryDao>) {
        repositoryList = data
        submitList(data)
    }

    companion object {
        val diffUtil = object: DiffUtil.ItemCallback<RepositoryDao>() {
            override fun areContentsTheSame(oldItem: RepositoryDao, newItem: RepositoryDao) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: RepositoryDao, newItem: RepositoryDao) =
                oldItem.title == newItem.title
        }
    }
}