package org.sopt.androidweek.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.androidweek.R

class HomeViewModel() : ViewModel() {
    private val _name = MutableLiveData<String>(DONGGI_NAME)
    val name: LiveData<String>
        get() = _name

    private val _id = MutableLiveData<String>(DONGGI_ID)
    val id: LiveData<String>
        get() = _id

    private val _pr = MutableLiveData<String>(DONGGI_PR)
    val pr: LiveData<String>
        get() = _pr


    private val _image = MutableLiveData<Int>(R.drawable.profile)
    val image: LiveData<Int>
        get() = _image

    companion object {
        private val DONGGI_NAME = "이동기"
        private val DONGGI_ID = "rkdmf1026"
        private val DONGGI_PR = "안녕 날 소개하지 이름은 이동기 직"
    }
}