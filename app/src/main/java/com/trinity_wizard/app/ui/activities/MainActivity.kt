package com.trinity_wizard.app.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.trinity_wizard.app.data.model.Contact
import com.trinity_wizard.app.databinding.ActivityMainBinding
import com.trinity_wizard.app.ui.adapters.ContactsAdapter
import com.trinity_wizard.app.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ContactsAdapter.OnItemClickedListener {

    private lateinit var binding: ActivityMainBinding
    private val viewModel:MainViewModel by viewModels()
    private val contactAdapter by lazy { ContactsAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.contactToolbar)

        setupUi()
        setupObserver()
        viewModel.getContacts()
    }

    private fun setupObserver(){
        viewModel.contactsLiveData.observe(this){
            binding.contactSwipeLayout.isRefreshing = false
            if(it.isNotEmpty()){
                contactAdapter.contacts = it as ArrayList<Contact>
            }
        }
    }

    private fun setupUi(){
        binding.contactSwipeLayout.setOnRefreshListener {
            binding.contactSwipeLayout.isRefreshing = true
            viewModel.getContacts()
        }
        binding.contactRv.adapter = contactAdapter
    }

    override fun details(contact: Contact) {
        startActivity(Intent(this, InformationActivity::class.java).apply {
            putExtra("contact", contact)
        })
    }


}