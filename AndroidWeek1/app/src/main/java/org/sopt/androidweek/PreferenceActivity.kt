package org.sopt.androidweek

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.sopt.androidweek.databinding.ActivityPreferenceBinding
import org.sopt.androidweek.util.preference.Application

class PreferenceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPreferenceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreferenceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cancelAutoLogin()
    }

    private fun cancelAutoLogin() {
        binding.btnCancel.setOnClickListener {
            Toast.makeText(this, "자동로그인이 해제되었습니다.", Toast.LENGTH_LONG).show()
            Application.preferenceUtil.setString(EMAIL, "")
            Application.preferenceUtil.setString(PASSWORD, "")
        }
    }

    companion object {
        private const val EMAIL = "email"
        private const val PASSWORD = "password"
    }
}