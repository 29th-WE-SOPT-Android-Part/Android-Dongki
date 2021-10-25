package org.sopt.androidweek.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import org.sopt.androidweek.DetailActivity
import org.sopt.androidweek.R
import org.sopt.androidweek.databinding.FollowerFragmentBinding
import org.sopt.androidweek.util.BaseFragment
import org.sopt.androidweek.util.VerticalItemDecorator

class FollowerFragment : BaseFragment<FollowerFragmentBinding>(R.layout.follower_fragment) {
    private val followerViewModel by viewModels<FollowerViewModel>()
    private val followerAdapter = FollowerAdapter() { follower ->
        val intent = Intent(requireContext(),DetailActivity::class.java)
        intent.putExtra(FOLLOWER_DAO,follower)
        startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding.apply {
            followerViewModel = this@FollowerFragment.followerViewModel
            followerListRecyclerView.adapter = followerAdapter
            followerListRecyclerView.addItemDecoration(VerticalItemDecorator(10))
        }
        return binding.root
    }

    companion object{
        const val FOLLOWER_DAO = "followerDao"
    }
}