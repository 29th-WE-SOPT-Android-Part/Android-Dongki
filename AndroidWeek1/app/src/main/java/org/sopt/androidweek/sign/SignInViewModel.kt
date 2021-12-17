package org.sopt.androidweek.sign

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.androidweek.repository.dto.request.SignInRequest
import org.sopt.androidweek.repository.network.SampleCreator
import org.sopt.androidweek.util.preference.Application

class SignInViewModel : ViewModel() {
    val loginStatus = MutableLiveData(false)
    val email = MutableLiveData("")
    val password = MutableLiveData("")

    init {
        checkLogin()
    }

    fun login() {
        viewModelScope.launch {
            try {
                val code = SampleCreator.sampleService.requestLogIn(
                    SignInRequest(
                        email.value.toString(),
                        password.value.toString()
                    )
                ).message
                Application.preferenceUtil.setString(EMAIL, email.value.toString())
                Application.preferenceUtil.setString(PASSWORD, password.value.toString())
                Log.d("1LogIn test Log", code.toString())

                loginStatus.postValue(true)
            } catch (e: Exception) {
                Log.d("2LogIn test Log",e.toString())
            }
        }
    }

    fun autoLogin() {
        viewModelScope.launch {
            try {
                val code = SampleCreator.sampleService.requestLogIn(
                    SignInRequest(
                        Application.preferenceUtil.getString(EMAIL,""),
                        Application.preferenceUtil.getString(PASSWORD,"")
                    )
                ).message
                loginStatus.postValue(true)
            } catch (e: Exception) {

            }
        }
    }

    private fun checkLogin(){
        if(Application.preferenceUtil.getString(EMAIL,"") != "")
            autoLogin()
    }

    companion object {
        private const val EMAIL = "email"
        private const val PASSWORD = "password"
    }
}