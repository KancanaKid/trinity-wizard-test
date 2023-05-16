package com.trinity_wizard.app.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.trinity_wizard.app.data.model.Contact
import com.trinity_wizard.app.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author basyi
 * Created 5/16/2023 at 4:15 PM
 */

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {
    val contactsLiveData by lazy { MutableLiveData<List<Contact>>() }
    val updateContactsLiveData by lazy { MutableLiveData<Boolean>() }
    fun getContacts(){
        val data = repository.callContactData()
        contactsLiveData.postValue(data)
    }

    fun updateContact(id:String, firstName:String, lastName:String, email:String, dob:String){
        val contact = Contact(id, firstName, lastName, email, dob)
        if(repository.updateContact(contact) == 1) updateContactsLiveData.postValue(true)
        else updateContactsLiveData.postValue(false)
    }
}