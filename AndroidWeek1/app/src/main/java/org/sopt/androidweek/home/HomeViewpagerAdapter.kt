package org.sopt.androidweek.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeViewpagerAdapter (fragment:Fragment) :
    FragmentStateAdapter(fragment){

    val fragmentList = mutableListOf<Fragment>()
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}