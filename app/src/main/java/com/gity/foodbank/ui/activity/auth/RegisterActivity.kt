package com.gity.foodbank.ui.activity.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gity.foodbank.R
import com.gity.foodbank.databinding.ActivityRegisterBinding
import com.gity.foodbank.utils.CommonUtils

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val context = this@RegisterActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        }
    }

    private fun register() {
        binding.apply {
            val edtEmail = edtEmailInput.text
            val edtPassword = edtPasswordInput.text
            val edtFullname = edtFullnameInput.text
            val edtNik = edtNikInput.text

//            Check if user contain a number
            val numberRegex = Regex("\\d")

            when {
                edtEmail.isNullOrEmpty() -> {
                    CommonUtils.showToast(context, resources.getString(R.string.empty_all))
                }

                edtPassword.isNullOrEmpty() -> {
                    CommonUtils.showToast(context, resources.getString(R.string.empty_all))
                }

                edtPassword.length <= 6 -> {
                    CommonUtils.showToast(
                        context,
                        resources.getString(R.string.password_length_error)
                    )
                }

                edtNik.isNullOrEmpty() -> {
                    CommonUtils.showToast(context, resources.getString(R.string.empty_all))
                }

                edtFullname.isNullOrEmpty() -> {
                    CommonUtils.showToast(context, resources.getString(R.string.empty_all))
                }

                !CommonUtils.isValidEmail(edtEmail) -> {
                    CommonUtils.showToast(context, resources.getString(R.string.email_format_error))
                }

                numberRegex.containsMatchIn(edtFullname.toString()) -> {
                    CommonUtils.showToast(
                        context,
                        resources.getString(R.string.full_names_error_contain_number)
                    )
                }

                else -> {
                    onSuccessfulRegister()
                }

            }

        }
    }

    private fun onSuccessfulRegister() {
        CommonUtils.showToast(context, resources.getString(R.string.successful_register))
    }


}