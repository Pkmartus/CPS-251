package com.pmartus.contactproject.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pmartus.contactproject.Contact
import com.pmartus.contactproject.R

class ContactListAdapter :
    RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int){

        contactList.let {
            holder.contactName.text = it!![listPosition].contactName
            holder.contactNumber.text = it!![listPosition].contactNumber
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_card,parent,false)
        return ViewHolder(view)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList == null) 0 else contactList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var contactName: TextView
        var contactNumber: TextView

        init {
            contactName = itemView.findViewById(R.id.displayName)
            contactNumber = itemView.findViewById(R.id.displayNumber)
        }
    }
}