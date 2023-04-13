package com.pmartus.contactproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")

class Contact {
    //adding annotations for the entity
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contactId")
    var id:Int = 0

    @ColumnInfo(name = "contactName")
    var contactName:String? = null
    var contactNumber:String? = null
    //TODO change to require ten digit number

    constructor() {}

    constructor(id: Int, contactName: String,contactNumber: String) {
        this.id = id
        this.contactName = contactName
        this.contactNumber = contactNumber
    }

    constructor(contactName: String, contactNumber: String) {
        this.contactName = contactName
        this.contactNumber = contactNumber
    }
}