package org.sopt.androidweek.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import org.sopt.androidweek.R
import org.sopt.androidweek.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var homeActivityViewpagerAdapter: HomeActivityViewpagerAdapter
    private val binding: ActivityHomeBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_home)
    }
    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@HomeActivity
        }
        initViewPager()
        initBottomNavigation()
    }

    private fun initViewPager() {
        val fragmentList = listOf(ProfileFragment(), HomeFragment())

        homeActivityViewpagerAdapter = HomeActivityViewpagerAdapter(this)
        homeActivityViewpagerAdapter.fragmentList.addAll(fragmentList)
        binding.viewpagerHome.adapter = homeActivityViewpagerAdapter
    }

    private fun initBottomNavigation() {
        binding.apply {
            viewpagerHome.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    bottomNavHome.menu.getItem(position).isChecked = true
                }
            })
            bottomNavHome.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.navigation_menu_profile -> {
                        viewpagerHome.currentItem = FIRST_FRAGMENT
                        true
                    }
                    R.id.navigation_menu_home -> {
                        viewpagerHome.currentItem = SECOND_FRAGMENT
                        true
                    }

                    else -> {
                        true
                    }
                }
            }
        }
    }

    companion object {
        const val FIRST_FRAGMENT = 0
        const val SECOND_FRAGMENT = 1
    }

}