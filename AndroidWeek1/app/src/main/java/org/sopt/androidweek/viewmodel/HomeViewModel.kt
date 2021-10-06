package org.sopt.androidweek.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sopt.androidweek.R

class HomeViewModel() : ViewModel() {
    val name = MutableLiveData<String>()
    val age = MutableLiveData<String>()
    val mbti = MutableLiveData<String>()
    val pr = MutableLiveData<String>()
    val image = MutableLiveData<Int>()

    init {
        textSetting()
    }

    fun textSetting() {
        name.value = DONGGI_NAME
        age.value = DONGGI_AGE
        mbti.value = DONGGI_MBTI
        pr.value = DONGGI_PR
        image.value = getImageresource()

    }

    fun getImageresource(): Int {
        return R.drawable.profile
    }

    companion object {
        private val DONGGI_NAME = "이동기"
        private val DONGGI_AGE = "26"
        private val DONGGI_MBTI = "ISFP"
        private val DONGGI_PR = "안녕 날 소개하지 이름은 이동기 직"
    }
}