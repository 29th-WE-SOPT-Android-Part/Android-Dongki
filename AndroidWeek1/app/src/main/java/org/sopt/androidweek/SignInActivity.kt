package org.sopt.androidweek

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.sopt.androidweek.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private val binding: ActivitySignInBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var getIntent = intent

        binding.apply {
            etId.setText(getIntent.getStringExtra("id"))
            etPassword.setText(getIntent.getStringExtra("password"))

            btnLogin.setOnClickListener {
                if (etId.text.toString().isNotEmpty() && etPassword.text.toString().isNotEmpty()) {
                    val homeIntent = Intent(this@SignInActivity, HomeActivity::class.java)
                    startActivity(homeIntent)
                } else {
                    Toast.makeText(this@SignInActivity, "로그인 실패", Toast.LENGTH_LONG).show()
                }
            }
            btnRegister.setOnClickListener {
                val signUpIntent = Intent(this@SignInActivity, SignUpActivity::class.java)
                startActivity(signUpIntent)
            }
        }
    }
}