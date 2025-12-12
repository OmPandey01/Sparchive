package com.omp48531.sparchive.screens


import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.omp48531.sparchive.ui.theme.NewFontFamily
import com.omp48531.sparchive.viewmodel.NotesViewModel

import androidx.compose.ui.graphics.Brush


@Composable
fun NoteListScreen(
    viewModel: NotesViewModel,
    onNoteClick: (Int) -> Unit ,
    modifier: Modifier// We pass the ID back when clicked
) {
    // Collect the data from ViewModel
    val notes by viewModel.notes.collectAsState()

    Scaffold(
        topBar = {
            @OptIn(ExperimentalMaterial3Api::class)
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.White
                ),
                title = { Text(
                text = "SPARCHIVE",
                    color = Color.Black,
                    fontSize =40.sp,
                    fontWeight = FontWeight.ExtraBold,
//                    style = TextStyle(shadow = Shadow(Color.Yellow, offset = Offset.Zero, blurRadius = 9.0F) )
                    ) }
            ,
            actions = {
                IconButton(
                    onClick = {}

                ) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                }
            }
                )
        }
    ) { innerPadding -> Box(
        modifier= Modifier
            .background(color = Color.White)
            .padding(20.dp)
    ){
        LazyColumn(
            Modifier.background(Color.Transparent),
            contentPadding = innerPadding
        ) {
            items(notes) { note ->
                Box(Modifier
                    .height(10.dp)
                    .background(color = Color.Transparent))
                NoteItem(note = note, onClick = { onNoteClick(note.id) })
            }
        }
    }



    }
}

@Composable
fun NoteItem(note: com.omp48531.sparchive.data.Note, onClick: () -> Unit) {

    Box(
        modifier = Modifier

            .clickable(onClick = onClick)
            .fillMaxWidth()

            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(10.dp),
                ambientColor = Color.Black,
                spotColor = Color.Black
            )
            .height(130.dp)
            .background(shape = RoundedCornerShape(10.dp), brush = Brush.linearGradient(colors = listOf(
                Color.LightGray, Color.Green  )))
            .padding(vertical = 20.dp, horizontal = 20.dp)


    ){
        Column {
            Text(text = note.title,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = NewFontFamily
                )
            Text(text ="${note.pages} Pages", maxLines = 1 )
            Text(text ="${note.memberCount} Members", maxLines = 1 )
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Text("Created ON : 16-10-25",
                    fontWeight = FontWeight.Bold, fontSize = 10.sp)
            }
        }
    }
//    ListItem(
//        headlineContent = { Text(note.title) },
//        supportingContent = { Text(note.data, maxLines = 1) },
//        modifier = Modifier
//
//            .background(shape = RoundedCornerShape(20), color = Color.Green)
//            .padding(vertical = 20.dp, horizontal = 10.dp)
//            .clickable { onClick() }
//
//
//    )
}