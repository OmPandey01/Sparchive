package com.omp48531.sparchive.navigation

import androidx.compose.material3.Text
import  androidx.compose.runtime.*
import androidx.compose.ui.Modifier

import androidx.navigation3.*
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay

import androidx.lifecycle.viewmodel.compose.viewModel //i will learn why?

import  com.omp48531.sparchive.screens.NoteListScreen
import  com.omp48531.sparchive.screens.NoteDetailScreen
import com.omp48531.sparchive.viewmodel.NotesViewModel

@Composable
fun AppNavGraph(viewModel: NotesViewModel=viewModel()) {

    val backStack = remember { mutableStateListOf<Screen>(Screen.Home) }



    NavDisplay(

        backStack = backStack,
        onBack = { backStack.removeLastOrNull() }
    ){

        key -> when(key) {
            is Screen.Home -> NavEntry(key){
                NoteListScreen(onNoteClick = { noteId ->
                    backStack.add(Screen.DetailScreen(noteId))
                } , viewModel =viewModel,
                    modifier = Modifier)
        }

        is Screen.DetailScreen -> NavEntry(key){


            NoteDetailScreen(noteId = key.noteId, viewModel = viewModel , onBack = {
                backStack.removeLastOrNull()
            } )
        }


        // else -> null this is wrong
        else -> NavEntry(key){
            Text("Error")
        }
        }
    }



}