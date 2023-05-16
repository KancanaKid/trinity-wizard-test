package com.trinity_wizard.app.ui.adapters

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.trinity_wizard.app.data.model.Contact
import com.trinity_wizard.app.databinding.ContactsItemBinding

/**
 * @author basyi
 * Created 5/16/2023 at 4:29 PM
 */
class ContactViewHolder(val itemBinding: ContactsItemBinding):RecyclerView.ViewHolder(itemBinding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(contact: Contact){
         itemBinding.contactName.text = "${contact.firstName} ${contact.lastName}"
    }
}