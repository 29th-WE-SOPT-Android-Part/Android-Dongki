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

class FollowerFragment : Fragment() {

    private val followerViewModel by viewModels<FollowerViewModel>()

    private val followerAdapter = FollowerAdapter() {
        // TODO: 클릭 시 followerDao 인자를 DetailActivity로 넘기기
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FollowerFragmentBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            followerViewModel = this@FollowerFragment.followerViewModel
            lifecycleOwner = this@FollowerFragment
            followerListRecyclerView.adapter = followerAdapter
        }
        return binding.root
    }

}