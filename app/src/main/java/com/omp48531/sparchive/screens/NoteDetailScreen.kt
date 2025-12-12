package com.omp48531.sparchive.screens

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.annotation.experimental.Experimental
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.omp48531.sparchive.viewmodel.NotesViewModel
//import org.w3c.dom.Text
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.IntOffset
import  androidx.compose.ui.unit.sp
import  androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import org.intellij.lang.annotations.JdkConstants


@Composable
fun NoteDetailScreen(viewModel: NotesViewModel,noteId:Int,onBack:()->Unit){

    val note = viewModel.getNoteById(noteId)
    Scaffold(topBar ={
        @OptIn(ExperimentalMaterial3Api::class)
        (TopAppBar(
            modifier = Modifier.background(color = Color.Blue),
            title = { Text(note?.title ?: "Error")},
            navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(imageVector =Icons.AutoMirrored.Outlined.ArrowBack,
                        contentDescription = "Previous Page")
                }
            }
        ))
    }) { innerPadding->
        Box(modifier = Modifier.padding(innerPadding)){


            Box(Modifier.background(color = Color.Green).fillMaxWidth().fillMaxHeight())
            Box(Modifier


                .fillMaxHeight(0.5f)
                .fillMaxWidth(0.9f)
                .padding(bottom = 20.dp)
                .zIndex(1f)
                .align(Alignment.BottomCenter)
//                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(color = Color.White, shape = RoundedCornerShape(20.dp))
                .padding(30.dp)

            ){
                Text(note?.data ?: "Error")

                Box(Modifier


//                    .padding(bottom = .dp)
                    .zIndex(1f)
                    .align(Alignment.BottomCenter)
//                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(color = Color.LightGray, shape = RoundedCornerShape(40.dp))
//                    .padding(5.dp)

                ){
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,

                    ) {
                        Button(onClick = {}, shape = RoundedCornerShape(50)) {
                            Icon(imageVector =Icons.AutoMirrored.Outlined.KeyboardArrowLeft,
                                contentDescription = "Previous Page")
                        }

                        Text(text ="${note?.pages}")
                        Button(onClick = {}) {
                            Icon(imageVector =Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                                contentDescription = "Next Page")
                        }
                    }
                }
            }


        }

    }
}