package com.gity.foodbank.ui.activity.auth

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.gity.foodbank.R
import com.gity.foodbank.databinding.ActivityLoginBinding
import com.gity.foodbank.ui.activity.main.MainActivity
import com.gity.foodbank.utils.CommonUtils

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var context = this@LoginActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            navigationToRegister.setOnClickListener {
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
                finish()
            }

            btnRegister.setOnClickListener {
                startActivity(Intent(context, RegisterActivity::class.java))
                finish()
            }

            btnLogin.setOnClickListener {
                login()
            }
        }


    }

    private fun login() {
        binding.apply {
            val edtEmail = edtEmailInput.text
            val edtPassword = edtPasswordInput.text

            when {
                edtEmail.isNullOrEmpty() || edtPassword.isNullOrEmpty() -> {
                    CommonUtils.showToast(context, resources.getString(R.string.empty_email_and_password))
                }

                !CommonUtils.isValidEmail(edtEmail) -> {
                    CommonUtils.showToast(context, resources.getString(R.string.email_format_error))
                }

                edtPassword.length <= 6 -> {
                    CommonUtils.showToast(context, resources.getString(R.string.password_length_error))
                }

                else -> {
                    onSuccessfulLogin()
                }
            }
        }
    }

    private fun onSuccessfulLogin() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finish()
    }
}