package org.sopt.androidweek.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.sopt.androidweek.R
import org.sopt.androidweek.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private var position = FOLLOWER_POSITION
    private val binding: ActivityHomeBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_home)
    }
    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@HomeActivity
            this.homeViewModel = this@HomeActivity.homeViewModel
            initTransactionEvent()
        }
    }

    private fun initTransactionEvent() {
        val followerFragment = FollowerFragment()
        val repositoryFragment = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.container_home, followerFragment)
            .commit()
        binding.btnFollower.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            when (position) {
                FOLLOWER_POSITION -> {
                }
                REPOSITORY_POSITION -> {
                    transaction.replace(R.id.container_home, followerFragment)
                    position = FOLLOWER_POSITION
                }
            }
            transaction.commit()
        }

        binding.btnRepository.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            when (position) {
                FOLLOWER_POSITION -> {
                    transaction.replace(R.id.container_home, repositoryFragment)
                    position = REPOSITORY_POSITION
                }
                REPOSITORY_POSITION -> {
                }
            }
            transaction.commit()
        }
    }

    companion object {
        const val FOLLOWER_POSITION = 1
        const val REPOSITORY_POSITION = 2
    }

}