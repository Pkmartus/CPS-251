package com.pmartus.contactproject

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

//the contact repository that interacts with the room database on behalf of the viewmodel
class ContactRepository(application: Application) {

    //the results of a search will be stored here
    val searchResults = MutableLiveData<List<Contact>>()
    val sortedList = MutableLiveData<List<Contact>>()
    private var contactDao: ContactDao?
    //return the entire database stored in liveData so that the recyclerView can display it
    var allContacts: LiveData<List<Contact>>?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    init {
        val  db: ContactRoomDatabase? = ContactRoomDatabase.getDatabase(application)
        contactDao = db?.productDao()
        allContacts = contactDao?.getAllContacts()
    }

    //the insert and delete functions make a call off of the main thread to add the new product to the database
    fun insertContact(newContact: Contact) {
        coroutineScope.launch(Dispatchers.IO) { asyncInsert(newContact)  }
    }

    private fun asyncInsert(contact: Contact) {
        contactDao?.insertContact(contact)
    }

    fun deleteContact(id: Int) {
        coroutineScope.launch(Dispatchers.IO) { asyncDelete(id) }
    }

    private fun asyncDelete(id: Int) {
        contactDao?.deleteContact(id)
    }

    //because the find product method needs access to the searchResults variable
    // the call to asyncFind is dispatched on the main thread and then uses the IO dispatcher to perform the database operation
    fun findContact(name: String) {
        coroutineScope.launch(Dispatchers.Main) { searchResults.value = asyncFind(name) }
    }

    private suspend fun asyncFind(name: String): List<Contact>? =
        coroutineScope.async(Dispatchers.IO) { return@async contactDao?.findContact(name) }.await()

    fun sortContactAsc() {
        coroutineScope.launch(Dispatchers.Main) { sortedList.value = asyncSortAsc() }
    }

    private suspend fun asyncSortAsc(): List<Contact>? =
        coroutineScope.async(Dispatchers.IO) { return@async contactDao?.sortContactAsc() }.await()
}