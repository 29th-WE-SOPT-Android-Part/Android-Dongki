package org.sopt.androidweek.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import org.sopt.androidweek.R
import org.sopt.androidweek.databinding.FollowerFragmentBinding
import org.sopt.androidweek.databinding.RepositoryFragmentBinding

class RepositoryFragment : Fragment() {
    private val repositoryViewModel by viewModels<RepositoryViewModel>()

    private val repositoryAdapter = RepositoryAdapter() {
        // TODO: 클릭 시 followerDao 인자를 DetailActivity로 넘기기
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = RepositoryFragmentBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            repositoryViewModel = this@RepositoryFragment.repositoryViewModel
            lifecycleOwner = this@RepositoryFragment
            repositoryListRecyclerView.adapter = repositoryAdapter
        }
        return binding.root
    }


}