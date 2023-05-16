package com.trinity_wizard.app.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.trinity_wizard.app.data.model.Contact
import com.trinity_wizard.app.databinding.ContactsItemBinding

/**
 * @author basyi
 * Created 5/16/2023 at 1:46 PM
 */
class ContactsAdapter(private val listener:OnItemClickedListener):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var contacts:ArrayList<Contact> = arrayListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ContactViewHolder(ContactsItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun getItemCount() = contacts.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ContactViewHolder){
            holder.bind(contacts[position])
            holder.itemBinding.itemLayout.setOnClickListener {
                listener.details(contacts[position])
            }
        }
    }

    interface OnItemClickedListener{
        fun details(contact:Contact)
    }
}