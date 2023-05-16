package com.trinity_wizard.app.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trinity_wizard.app.data.model.Contact
import com.trinity_wizard.app.databinding.ActivityInformationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contact : Contact = intent.getSerializableExtra("contact") as Contact

        binding.firstNameEdittext.setText(contact.firstName)
        binding.lastNameEdittext.setText(contact.lastName)
        binding.emailEdittext.setText(contact.email)
        binding.dobEdittext.setText(contact.dob)
    }
}