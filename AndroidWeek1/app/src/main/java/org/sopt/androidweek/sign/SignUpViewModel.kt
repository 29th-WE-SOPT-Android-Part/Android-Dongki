package org.sopt.androidweek.sign

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.androidweek.repository.dto.request.SignUpRequest
import org.sopt.androidweek.repository.network.SampleCreator

class SignUpViewModel : ViewModel() {
    val loginStatus = MutableLiveData(false)
    val loginCheck = MutableLiveData(false)
    val email = MutableLiveData("")
    val name = MutableLiveData("")
    val password = MutableLiveData("")

    private fun login() {
        viewModelScope.launch {
            try {
                SampleCreator.sampleService.requestSignUp(
                    SignUpRequest(
                        email.value.toString(),
                        name.value.toString(),
                        password.value.toString()
                    )
                )
                loginStatus.postValue(true)
            } catch (e: Exception) {
                Log.d("testtt",e.toString())
            }
        }
    }

    fun checkLogin() {
        val emailValue = email.value ?: ""
        val nameValue = name.value ?: ""
        val passwordValue = password.value ?: ""

        if (emailValue == "" || passwordValue == "" || nameValue == "") {
            loginCheck.postValue(true)
        } else {
            login()
        }
    }

}