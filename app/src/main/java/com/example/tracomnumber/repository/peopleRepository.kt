package com.example.tracomnumber.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.tracomnumber.model.people
import com.example.tracomnumber.room.DaoPeople
import com.example.tracomnumber.room.DatabasePeople

class peopleRepository(application: Application) {

    private var daoPeople: DaoPeople

    private var allNotes: LiveData<List<people>>

    init {
        val database: DatabasePeople = DatabasePeople.getInstance(application.applicationContext)!!

        daoPeople = database.daopeople()
        allNotes = daoPeople.getAllNotes()
    }

    fun insert(people: people) {
        val insertNoteAsyncTask = InsertNoteAsyncTask(daoPeople).execute(people)
    }

    fun deleteAllNotes() {
        val deleteAllNotesAsyncTask = DeleteAllNotesAsyncTask(daoPeople).execute()
    }

    fun getAllNotes(): LiveData<List<people>> {

        return allNotes
    }


    private class InsertNoteAsyncTask(daoPeople: DaoPeople) : AsyncTask<people, Unit, Unit>() {

        val noteDao = daoPeople

        override fun doInBackground(vararg p0: people?) {
            noteDao.insert(p0[0]!!)
        }
    }


    private class DeleteAllNotesAsyncTask(val noteDao: DaoPeople) : AsyncTask<Unit, Unit, Unit>() {

        override fun doInBackground(vararg p0: Unit?) {
            noteDao.deleteAllNotes()
        }
    }

}