package com.tanmay.bloggingapp.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.tanmay.bloggingapp.AuthViewModel
import com.tanmay.bloggingapp.databinding.FragmentLoginSignupBinding

class SignupFragment : Fragment(){

    private var _binding : FragmentLoginSignupBinding ?= null
    val authViewModel : AuthViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginSignupBinding.inflate(inflater,container,false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.apply {
            submitButton.setOnClickListener {
                authViewModel.signup(
                        usernameEditText.text.toString(),
                        emailEditText.text.toString(),
                        passwordEditText.text.toString()
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}