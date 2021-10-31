package org.sopt.androidweek.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import org.sopt.androidweek.R
import org.sopt.androidweek.databinding.FragmentHomeBinding
import org.sopt.androidweek.util.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private lateinit var homeViewpagerAdapter: HomeViewpagerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        initAdapter()
        initTab()
        return binding.root
    }

    private fun initAdapter(){
        val fragmentList = listOf(EmptyFragment(),EmptyFragment())

        homeViewpagerAdapter = HomeViewpagerAdapter(this)
        homeViewpagerAdapter.fragmentList.addAll(fragmentList)

        binding.viewpagerHomeTab.adapter = homeViewpagerAdapter
    }

    private fun initTab(){
        val tabLabel = listOf("팔로잉", "팔로워")

        TabLayoutMediator(binding.tlHome, binding.viewpagerHomeTab) { tab, position ->
            tab.text = tabLabel[position]
        }.attach()
    }





}