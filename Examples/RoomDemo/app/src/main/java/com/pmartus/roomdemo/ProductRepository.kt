package com.pmartus.roomdemo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

//the product repository that interacts with the room database on behalf of the viewmodel
class ProductRepository(application: Application) {

    //the results of a search will be stored here
    val searchResults = MutableLiveData<List<Product>>()
    private var productDao: ProductDao?
    //return the entire database stored in liveData so that the recyclerView can display it
    val allProducts: LiveData<List<Product>>?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    init {
        val  db: ProductRoomDatabase? = ProductRoomDatabase.getDatabase(application)
        productDao = db?.productDao()
        allProducts = productDao?.getAllProducts()
    }

    //the insert and delete functions make a call off of the main thread to add the new product to the database
    fun insertProduct(newProduct: Product) {
        coroutineScope.launch(Dispatchers.IO) { asyncInsert(newProduct)  }
    }

    private fun asyncInsert(product: Product) {
        productDao?.insertProduct(product)
    }

    fun deleteProduct(name: String) {
        coroutineScope.launch(Dispatchers.IO) { asyncDelete(name) }
    }

    private fun asyncDelete(name: String) {
        productDao?.deleteProduct(name)
    }

    //because the find product method needs access to the searchResults variable
    // the call to asyncFind is dispatched on the main thread and then uses the IO dispatcher to perform the database operation
    fun findProduct(name: String) {
        coroutineScope.launch(Dispatchers.Main) { searchResults.value = asyncFind(name) }
    }

    private suspend fun asyncFind(name: String): List<Product>? =
        coroutineScope.async(Dispatchers.IO) { return@async productDao?.findProduct(name) }.await()
}