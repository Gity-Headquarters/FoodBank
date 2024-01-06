package com.gity.foodbank.ui.activity.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.gity.foodbank.R
import com.gity.foodbank.databinding.ActivityLoginBinding
import com.gity.foodbank.di.Injection
import com.gity.foodbank.factory.ViewModelFactory
import com.gity.foodbank.ui.activity.main.MainActivity
import com.gity.foodbank.ui.activity.register.RegisterActivity
import com.gity.foodbank.utils.CommonUtils
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel
    private var context = this@LoginActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val injection = Injection.provideRepository()
        val factory = ViewModelFactory(injection)
        viewModel = ViewModelProvider(context, factory)[LoginViewModel::class.java]


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
            val edtEmail = edtEmailInput.text.toString().trim()
            val edtPassword = edtPasswordInput.text.toString().trim()


            when {
                edtEmail.isEmpty() || edtPassword.isEmpty() -> {
                    CommonUtils.showToast(
                        context,
                        resources.getString(R.string.empty_email_and_password)
                    )
                }

                !CommonUtils.isValidEmail(edtEmail) -> {
                    CommonUtils.showToast(context, resources.getString(R.string.email_format_error))
                }

                edtPassword.length <= 6 -> {
                    CommonUtils.showToast(
                        context,
                        resources.getString(R.string.password_length_error)
                    )
                }

                else -> {
                    lifecycleScope.launch {
                        try {
                            val response = viewModel.login(edtEmail, edtPassword)
                            val token = response.body()?.loginResult?.token
                            CommonUtils.showToast(context, "My Token : $token")
                            onSuccessfulLogin()
                        } catch (e: Exception) {
                            onFailedLogin()
                        }
                    }
                }
            }
        }
    }

    private fun onSuccessfulLogin() {
        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finish()
    }

    private fun onFailedLogin() {
        CommonUtils.showToast(context, "Login Failed, Password or Email is Wrong")
    }
}