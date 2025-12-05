package com.omp48531.sparchive.screens

import androidx.annotation.experimental.Experimental
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.omp48531.sparchive.viewmodel.NotesViewModel
//import org.w3c.dom.Text
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import  androidx.compose.ui.unit.sp


@Composable
fun NoteDetailScreen(viewModel: NotesViewModel,noteId:Int,onBack:()->Unit){

    val note = viewModel.getNoteById(noteId)
    Scaffold(topBar ={
        @OptIn(ExperimentalMaterial3Api::class)
        (TopAppBar(
            modifier = Modifier.background(color = Color.Blue),
            title = { Text(note?.title ?: "Error")},
            navigationIcon = {
                Button(onClick = onBack) {
                    Text("<",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp)
                }
            }
        ))
    }) { innerPadding->
        Column(
            modifier = Modifier.padding(innerPadding)
        ){
            Column {
                Text(text = note?.data ?:"Error")
            }
        }

    }
}