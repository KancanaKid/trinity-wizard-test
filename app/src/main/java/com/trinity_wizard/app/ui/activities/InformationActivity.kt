package com.trinity_wizard.app.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.trinity_wizard.app.data.model.Contact
import com.trinity_wizard.app.databinding.ActivityInformationBinding
import com.trinity_wizard.app.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInformationBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contact : Contact = intent.getSerializableExtra("contact") as Contact
        setupUi(contact)
        setupObserver()
    }

    private fun setupUi(contact:Contact){
        binding.firstNameEdittext.setText(contact.firstName)
        binding.lastNameEdittext.setText(contact.lastName)
        binding.emailEdittext.setText(contact.email)
        binding.dobEdittext.setText(contact.dob)

        binding.saveText.setOnClickListener {
            viewModel.updateContact(
                contact.id,
                binding.firstNameEdittext.text.toString(),
                binding.lastNameEdittext.text.toString(),
                binding.emailEdittext.text.toString(),
                binding.dobEdittext.text.toString()
            )
        }
    }

    private fun setupObserver(){
        viewModel.updateContactsLiveData.observe(this){
            Log.i("result","$it")
            if(it) finish()
        }
    }
}