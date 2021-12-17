package org.sopt.androidweek.sign

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.sopt.androidweek.repository.dto.request.SignUpRequest
import org.sopt.androidweek.repository.network.SampleCreator

class SignUpViewModel : ViewModel() {
    val signUpStatus = MutableLiveData(false)
    val editStatus = MutableLiveData(false)
    val email = MutableLiveData("")
    val name = MutableLiveData("")
    val password = MutableLiveData("")

    private fun signUp() {
        viewModelScope.launch {
            try {
                val code = SampleCreator.sampleService.requestSignUp(
                    SignUpRequest(
                        email.value.toString(),
                        name.value.toString(),
                        password.value.toString()
                    )
                ).message
                Log.d("SignUp test Log", code.toString())
                signUpStatus.postValue(true)
            } catch (e: Exception) {

            }
        }
    }

    fun checkEdit() {
        val emailValue = email.value ?: ""
        val nameValue = name.value ?: ""
        val passwordValue = password.value ?: ""

        if (emailValue == "" || passwordValue == "" || nameValue == "") {
            editStatus.postValue(true)
        } else {
            signUp()
        }
    }
}