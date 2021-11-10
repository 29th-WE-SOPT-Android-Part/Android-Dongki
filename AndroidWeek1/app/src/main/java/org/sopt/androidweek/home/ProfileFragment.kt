package org.sopt.androidweek.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import org.sopt.androidweek.R
import org.sopt.androidweek.databinding.FragmentProfileBinding
import org.sopt.androidweek.util.BaseFragment
import org.sopt.androidweek.util.setImage


class ProfileFragment : BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {
    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        binding.homeViewModel = homeViewModel
        initClickListener()
        return binding.root
    }

    private fun initClickListener(){
        childFragmentManager.beginTransaction()
            .replace(R.id.container_profile, FollowerFragment())
            .commit()

        binding.btnFollower.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.container_profile, FollowerFragment())
                .commit()
        }

        binding.btnRepository.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.container_profile, RepositoryFragment())
                .commit()
        }


    }

}