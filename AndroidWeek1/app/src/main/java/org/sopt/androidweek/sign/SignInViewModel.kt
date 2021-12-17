package org.sopt.androidweek.sign

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.androidweek.repository.dto.request.SignInRequest
import org.sopt.androidweek.repository.network.SampleCreator

class SignInViewModel : ViewModel() {
    val loginStatus = MutableLiveData(false)
    val email = MutableLiveData("")
    val password = MutableLiveData("")

    fun login() {
        viewModelScope.launch {
            try {
                val code = SampleCreator.sampleService.requestLogIn(
                    SignInRequest(
                        email.value.toString(),
                        password.value.toString()
                    )
                ).message
                Log.d("1LogIn test Log", code.toString())

                loginStatus.postValue(true)
            } catch (e: Exception) {
                Log.d("2LogIn test Log",e.toString())
            }
        }
    }
}