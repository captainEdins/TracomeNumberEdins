package com.example.tracomnumber.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.tracomnumber.model.people
import com.example.tracomnumber.repository.peopleRepository

class PeopleViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: peopleRepository = peopleRepository(application)

    private var allNotes: LiveData<List<people>> = repository.getAllNotes()

    fun insert(note: people) {
        repository.insert(note)
    }

    fun deleteAllNotes() {
        repository.deleteAllNotes()
    }

    fun getAllNotes(): LiveData<List<people>> {
        return allNotes
    }
}