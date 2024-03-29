package com.gity.foodbank.ui.activity.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.gity.foodbank.R
import com.gity.foodbank.data.preferences.datastore.DataStore
import com.gity.foodbank.data.preferences.datastore.dataStore
import com.gity.foodbank.databinding.ActivityLoginBinding
import com.gity.foodbank.di.Injection
import com.gity.foodbank.factory.ViewModelFactory
import com.gity.foodbank.ui.activity.main.MainActivity
import com.gity.foodbank.ui.activity.register.RegisterActivity
import com.gity.foodbank.utils.Common
import kotlinx.coroutines.delay
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

            imageView.setOnClickListener {
                showLoading(true)
                lifecycleScope.launch {
                    delay(3000)
                    showLoading(false)
                }
            }
        }


    }

    private fun login() {
        binding.apply {
            val edtEmail = edtEmailInput.text.toString().trim()
            val edtPassword = edtPasswordInput.text.toString().trim()


            when {
                edtEmail.isEmpty() || edtPassword.isEmpty() -> {
                    Common.showToast(
                        context,
                        resources.getString(R.string.empty_email_and_password)
                    )
                }

                !Common.isValidEmail(edtEmail) -> {
                    Common.showToast(context, resources.getString(R.string.email_format_error))
                }

                edtPassword.length <= 6 -> {
                    Common.showToast(
                        context,
                        resources.getString(R.string.password_length_error)
                    )
                }

                else -> {
                    lifecycleScope.launch {
                        try {
                            showLoading(true)
                            val response = viewModel.login(edtEmail, edtPassword)
                            val token = response.body()?.token

                            val userEmail = response.body()?.data?.email
                            val userProfilePicture = response.body()?.data?.imageProfile
                            val userName = response.body()?.data?.username
                            val guid = response.body()?.data?.guid


                            context.startActivity(intent)
                            lifecycleScope.launch {
                                if (token != null && userEmail != null && userProfilePicture != null && userName != null && guid != null) {
                                    saveToken(token)
                                    saveDataUser(userEmail, userProfilePicture, userName, guid)
                                } else {
                                    Common.showToast(context, "Token is Null")
                                }
                            }
                            onSuccessfulLogin()
                            showLoading(false)
                            finish()
                        } catch (e: Exception) {
                            showLoading(false)
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
        Common.showToast(context, "Login Failed, Password or Email is Wrong")
    }

    private fun showLoading(state: Boolean) {
        Common.loading(binding.loading, state)
    }

    private suspend fun saveToken(token: String) {
        val dataStore = DataStore.getInstance(context.dataStore)
        dataStore.saveToken(token)
    }

    private suspend fun saveDataUser(email: String, profilePicture: String, username: String, guid: String) {
        val dataStore = DataStore.getInstance(context.dataStore)
        dataStore.saveEmail(email)
        dataStore.saveProfilePicture(profilePicture)
        dataStore.saveUsername(username)
        dataStore.saveGuidUser(guid)
    }

}