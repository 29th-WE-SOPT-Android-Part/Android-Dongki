package org.sopt.androidweek.sign

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.*
import org.sopt.androidweek.R
import org.sopt.androidweek.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private val binding: ActivitySignUpBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
    }
    private val viewModel: SignUpViewModel by lazy {
        ViewModelProvider(this).get(SignUpViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@SignUpActivity
            this.signUpViewModel = viewModel

            viewModel.editStatus.observe(this@SignUpActivity) {
                if (it)
                    Toast.makeText(this@SignUpActivity, "입력되지 않은 정보가 있습니다", Toast.LENGTH_LONG)
                        .show()
            }
            viewModel.signUpStatus.observe(this@SignUpActivity) {
                if (it) {
                    val intent = Intent(this@SignUpActivity, SignInActivity::class.java).apply {
                        putExtra("id", viewModel.email.value)
                        putExtra("password", viewModel.password.value)
                    }
                    setResult(RESULT_OK, intent)
                    if (!isFinishing) finish()
                }
            }
        }
    }
    companion object{
        const val SUCCESS = "success"
        const val FAILURE = "failure"
    }

}