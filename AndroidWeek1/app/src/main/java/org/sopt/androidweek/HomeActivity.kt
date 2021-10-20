package org.sopt.androidweek

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.sopt.androidweek.databinding.ActivityHomeBinding
import org.sopt.androidweek.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {
    private val binding: ActivityHomeBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_home)
    }
    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@HomeActivity
            this.homeViewModel = this@HomeActivity.homeViewModel
            btnGit.setOnClickListener {
                startGit()
            }
        }
    }

    fun startGit(){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/rkdmf1026"))
        startActivity(intent)
    }
}