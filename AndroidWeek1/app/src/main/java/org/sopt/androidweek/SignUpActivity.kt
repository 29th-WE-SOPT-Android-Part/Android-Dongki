package org.sopt.androidweek

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.sopt.androidweek.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private val binding: ActivitySignUpBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            btnRegisterComplete.setOnClickListener {
                if (etId.text.isNotEmpty() && etName.text.isNotEmpty() && etPassword.text.isNotEmpty()
                ) {
                    val intent = Intent(this@SignUpActivity, SignInActivity::class.java).apply {
                        putExtra("id", etId.text.toString())
                        putExtra("password", etPassword.text.toString())
                    }
                    setResult(RESULT_OK, intent)
                    if(!isFinishing)finish()
                } else {
                    Toast.makeText(this@SignUpActivity, "입력되지 않은 정보가 있습니다", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }
}