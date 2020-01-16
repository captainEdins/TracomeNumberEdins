package com.example.tracomnumber.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tracomnumber.model.people

@Dao
interface DaoPeople {

    @Insert
    fun insert( people: people)

    @Query("DELETE FROM people_table")
    fun deleteAllNotes()

    @Query("SELECT * FROM people_table ")
    fun getAllNotes(): LiveData<List<people>>

}