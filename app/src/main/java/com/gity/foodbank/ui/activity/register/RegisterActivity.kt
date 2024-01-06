package com.gity.foodbank.ui.activity.register

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.gity.foodbank.R
import com.gity.foodbank.databinding.ActivityRegisterBinding
import com.gity.foodbank.di.Injection
import com.gity.foodbank.factory.ViewModelFactory
import com.gity.foodbank.ui.activity.login.LoginActivity
import com.gity.foodbank.utils.CommonUtils
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel
    private val context = this@RegisterActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val injection = Injection.provideRepository()
        val factory = ViewModelFactory(injection)
        viewModel = ViewModelProvider(context, factory)[RegisterViewModel::class.java]

        binding.apply {
            navigationToLogin.setOnClickListener {
                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                finish()
            }

            btnRegister.setOnClickListener {
                register()
            }

            btnLogin.setOnClickListener {
                startActivity(Intent(context, LoginActivity::class.java))
                finish()
            }

//            Text Watcher for auto change text to UpperCase
            edtFullnameInput.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    edtFullnameInput.removeTextChangedListener(this)
                    val updatedText = s.toString().uppercase()
                    edtFullnameInput.setText(updatedText)
                    edtFullnameInput.setSelection(updatedText.length)
                    edtFullnameInput.addTextChangedListener(this)
                }

                override fun afterTextChanged(s: Editable?) {}

            })


        }

    }

    private fun register() {
        binding.apply {
            val edtEmail = edtEmailInput.text.toString()
            val edtPassword = edtPasswordInput.text.toString()
            val edtFullname = edtFullnameInput.text.toString().uppercase()
            val edtNik = edtNikInput.text.toString()

//            Check if user contain a number
            val numberRegex = Regex("\\d")

            when {
                edtEmail.isEmpty() -> {
                    CommonUtils.showToast(context, resources.getString(R.string.empty_all))
                }

                edtPassword.isEmpty() -> {
                    CommonUtils.showToast(context, resources.getString(R.string.empty_all))
                }

                edtPassword.length <= 6 -> {
                    CommonUtils.showToast(
                        context,
                        resources.getString(R.string.password_length_error)
                    )
                }

//                edtNik.isEmpty() -> {
//                    CommonUtils.showToast(context, resources.getString(R.string.empty_all))
//                }
//
//                edtNik.length <= 15 -> {
//                    CommonUtils.showToast(context, resources.getString(R.string.nik_length_error))
//                }

                edtFullname.isEmpty() -> {
                    CommonUtils.showToast(context, resources.getString(R.string.empty_all))
                }

                !CommonUtils.isValidEmail(edtEmail) -> {
                    CommonUtils.showToast(context, resources.getString(R.string.email_format_error))
                }

                numberRegex.containsMatchIn(edtFullname) -> {
                    CommonUtils.showToast(
                        context,
                        resources.getString(R.string.full_names_error_contain_number)
                    )
                }

                else -> {
                    lifecycleScope.launch {
                        try {
                            viewModel.register(edtFullname, edtEmail, edtPassword)
                            onSuccessfulRegister()
                            startActivity(Intent(context, LoginActivity::class.java))
                            finish()
                        } catch (e: Exception) {
                            onFailedRegister()
                        }
                    }
                }

            }

        }
    }

    private fun onSuccessfulRegister() {
        CommonUtils.showToast(context, resources.getString(R.string.successful_register))
    }

    private fun onFailedRegister() {
        CommonUtils.showToast(context, "Login Failed, Account is Already exist or Server is error")
    }


}