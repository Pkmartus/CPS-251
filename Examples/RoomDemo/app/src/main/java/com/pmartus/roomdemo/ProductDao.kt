package com.pmartus.roomdemo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

//this is the Data Access Operator interface that manages communication with the repository
@Dao
interface ProductDao {
    //the insert function
    @Insert
    fun insertProduct(product: Product)

    //the query function to pull from the database
    @Query("SELECT * FROM products WHERE productName = :name")
    fun findProduct(name: String): List<Product>

    //the delete function to remove database entries
    @Query("DELETE FROM products WHERE productName = :name")
    fun deleteProduct(name: String)

    @Query("SELECT * FROM products")
    fun getAllProducts(): LiveData<List<Product>>
}