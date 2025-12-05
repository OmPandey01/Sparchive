package com.omp48531.sparchive.viewmodel


import androidx.lifecycle.ViewModel
import com.omp48531.sparchive.data.Note
import com.omp48531.sparchive.data.dummyNotes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NotesViewModel : ViewModel() {

    // 1. The Source of Truth: A list of notes
    // In a real app, you would fetch this from a database here.
    private val _notes = MutableStateFlow(dummyNotes)
    val notes: StateFlow<List<Note>> = _notes.asStateFlow()

    // 2. Helper to get a single note
    fun getNoteById(id: Int): Note? {
        print(_notes.value);
        return _notes.value.find { it.id == id }
        //find( ) takes an expression ,predicate

    }
}