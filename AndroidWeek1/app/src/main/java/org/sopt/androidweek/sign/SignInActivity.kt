package org.sopt.androidweek.sign

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import org.sopt.androidweek.R
import org.sopt.androidweek.databinding.ActivitySignInBinding
import org.sopt.androidweek.home.HomeActivity

class SignInActivity : AppCompatActivity() {
    private val binding: ActivitySignInBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
    }
    private val viewModel: SignInViewModel by lazy {
        ViewModelProvider(this).get(SignInViewModel::class.java)
    }
    private lateinit var getResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            lifecycleOwner = this@SignInActivity
            this.signInViewModel = viewModel
            getResult = registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ) { result ->
                if (result.resultCode == RESULT_OK) {
                    etId.setText(result.data?.getStringExtra("id"))
                    etPassword.setText(result.data?.getStringExtra("password"))
                }
            }

            viewModel.loginStatus.observe(this@SignInActivity){
                logInBtnListener(it)
            }

            btnRegister.setOnClickListener {
                val signUpIntent = Intent(this@SignInActivity, SignUpActivity::class.java)
                getResult.launch(signUpIntent)
            }
        }
    }

    private fun logInBtnListener(tf : Boolean){
        if(tf){
            val homeIntent = Intent(this@SignInActivity, HomeActivity::class.java)
            startActivity(homeIntent)
            Toast.makeText(this@SignInActivity, "이동기님 환영합니다", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this@SignInActivity, "로그인 실패", Toast.LENGTH_LONG).show()
        }
    }
}