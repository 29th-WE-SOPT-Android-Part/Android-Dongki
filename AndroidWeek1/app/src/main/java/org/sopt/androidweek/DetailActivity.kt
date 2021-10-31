package org.sopt.androidweek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import org.sopt.androidweek.databinding.ActivityDetailBinding
import org.sopt.androidweek.databinding.ActivityHomeBinding
import org.sopt.androidweek.home.FollowerDao

class DetailActivity : AppCompatActivity() {
    private val binding: ActivityDetailBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_detail)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        getInfo()
    }

    private fun getInfo(){
        val getIntent = intent
        if (getIntent != null) {
            val follower = getIntent.getSerializableExtra(FOLLOWER_DAO) as FollowerDao
            binding.tvName.text = follower.name
            binding.tvDetailContent.text = follower.introduction
        }
    }

    companion object{
        const val FOLLOWER_DAO = "followerDao"
    }
}