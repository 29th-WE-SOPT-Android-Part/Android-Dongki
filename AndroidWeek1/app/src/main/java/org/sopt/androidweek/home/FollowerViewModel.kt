package org.sopt.androidweek.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FollowerViewModel : ViewModel() {
    private val _followerList = MutableLiveData<List<FollowerDao>>()
    val followerList: LiveData<List<FollowerDao>>
        get() = _followerList

    init {
        _followerList.value = loadFollower()
    }


    private fun loadFollower() : List<FollowerDao>{
        val contentStr =
            "가나다라마바사아자차카타파하가나다라마바사아자차카타파하" +
                    "가나다라마바사아자차카타파하가나다라마바사아자차카타"
        return (1..9).map { i ->
            FollowerDao(
                "이동기$i",
                contentStr+ contentStr
            )
        }
    }
}