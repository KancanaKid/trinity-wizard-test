package com.trinity_wizard.app.data.repository

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.trinity_wizard.app.data.model.Contact
import com.trinity_wizard.app.data.util.readDataFromJson
import com.trinity_wizard.app.data.util.writeData
import javax.inject.Inject

/**
 * @author basyi
 * Created 5/16/2023 at 4:02 PM
 */
class MainRepository @Inject constructor(
    private val context: Context
){

    fun callContactData(): List<Contact> {
        val jsonString = readDataFromJson(context, "data.json")
        val listOfContact = object : TypeToken<List<Contact>>() {}.type
        return Gson().fromJson(jsonString, listOfContact)
    }

    fun updateContact(contact: Contact): Int {
        return writeData(context,contact)
    }
}