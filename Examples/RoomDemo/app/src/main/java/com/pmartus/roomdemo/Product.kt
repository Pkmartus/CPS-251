package com.pmartus.roomdemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")

class Product {
    //adding annotations for the entity
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "productId")
    var id:Int = 0

    @ColumnInfo(name = "productName")
    var productName:String? = null
    var quantity:Int = 0

    constructor() {}

    constructor(id: Int, productName: String, quantity: Int) {
        this.id = id
        this.productName = productName
        this.quantity = quantity
    }

    constructor(productName: String, quantity: Int) {
        this.productName = productName
        this.quantity = quantity
    }
}