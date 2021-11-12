package org.sopt.androidweek.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import org.sopt.androidweek.repository.network.GitCreator
import java.lang.Exception

class FollowerViewModel : ViewModel() {
    private val _followerList = MutableLiveData<List<FollowerDao>>()
    val followerList: LiveData<List<FollowerDao>>
        get() = _followerList

    init {
        loadFollowerApi()
    }

    private fun loadFollowerApi() {
        var list = emptyList<FollowerDao>()
        viewModelScope.launch {
            try {
                val copyList = mutableListOf<FollowerDao>()
                list = GitCreator.gitService.getGitHubFollowers("rkdmf1026")
                for (follower in list)
                    copyList.add(
                        FollowerDao(
                            follower.name,
                            GitCreator.gitService.getUserInfo(follower.name).introduction
                        )
                    )
                _followerList.postValue(copyList)
            } catch (e: Exception) {
            }
        }
    }
}