package com.example.tracomnumber.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "people_table")
data class people(var name: String, var dob: String, var area: String, var N_ID: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}