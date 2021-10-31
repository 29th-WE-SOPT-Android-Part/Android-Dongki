package org.sopt.androidweek.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RepositoryViewModel : ViewModel() {
    private val _repositoryList = MutableLiveData<List<RepositoryDao>>()
    val repositoryList: LiveData<List<RepositoryDao>>
        get() = _repositoryList

    init {
        _repositoryList.value = loadRepository()
    }

    private fun loadRepository() : List<RepositoryDao>{
        val contentStr =
            "가나다라마바사아자차카타파하가나다라마바사아자차카타파하" +
                    "가나다라마바사아자차카타파하가나다라마바사아자차카타"
        return (1..9).map { i ->
            RepositoryDao(
                "레포지터리$i",
                contentStr+ contentStr
            )
        }
    }
}