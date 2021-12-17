package org.sopt.androidweek.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import org.sopt.androidweek.R
import org.sopt.androidweek.databinding.RepositoryFragmentBinding
import org.sopt.androidweek.util.base.BaseFragment

class RepositoryFragment : BaseFragment<RepositoryFragmentBinding>(R.layout.repository_fragment) {
    private val repositoryViewModel by viewModels<RepositoryViewModel>()
    private val repositoryAdapter = RepositoryAdapter() {
        // TODO: 클릭 시 followerDao 인자를 DetailActivity로 넘기기
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.apply {
            repositoryViewModel = this@RepositoryFragment.repositoryViewModel
            repositoryListRecyclerView.adapter = repositoryAdapter
        }
        return binding.root
    }

}