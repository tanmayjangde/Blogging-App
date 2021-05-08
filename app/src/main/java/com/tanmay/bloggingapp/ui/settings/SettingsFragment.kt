package com.tanmay.bloggingapp.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.tanmay.bloggingapp.AuthViewModel
import com.tanmay.bloggingapp.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val authViewModel by activityViewModels<AuthViewModel>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)

        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewModel.user.observe({ lifecycle }) {
            _binding?.apply {
                bioEditText.setText(it?.bio ?: "")
                EmailEditText.setText(it?.email ?: "")
                userNameEditText.setText(it?.username ?: "")
                imageEditText.setText(it?.image ?: "")
            }
        }

        _binding?.apply {
            updateSettingsButton.setOnClickListener {
                authViewModel.update(
                        bio = bioEditText.text.toString(),
                        username = userNameEditText.text.toString().takeIf { it.isNotBlank() },
                        image = imageEditText.text.toString(),
                        email = EmailEditText.text.toString().takeIf { it.isNotBlank() },
                        password = passwordSettingEditText.text.toString().takeIf { it.isNotBlank() }
                )
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}