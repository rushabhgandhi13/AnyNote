package com.Rushabh_Gandhi.anynote

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NoteViewModel(application: Application) : AndroidViewModel(application) {


    val allNotes: LiveData<List<Notes>>
    var dao = NoteDatabase.getDatabase(application).getNoteDao()
    private var repository = NoteRepository(dao)

    init {
       val dao = NoteDatabase.getDatabase(application).getNoteDao()
        repository = NoteRepository(dao)
        allNotes = repository.allNotes

    }
 fun deleteNote(note: Notes)= viewModelScope.launch(Dispatchers.IO) {
    repository.delete(note)
}
    fun InsertNote(note: Notes)= viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }
}