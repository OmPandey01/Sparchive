package com.omp48531.sparchive.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*

@Composable
fun LoginScreen() {

    Scaffold {

            innerPadding ->
        Box(
            Modifier.padding(innerPadding)
                .background(color = Color.White)

        ) {
            Column {
                Box(
                   modifier =  Modifier.fillMaxWidth()
                        .height(100.dp)
                        .background(color = Color.LightGray),
                    contentAlignment = Alignment.Center





                ){

                    Text(
                        text = "Login Screen",
                        fontSize = 30.sp,
                    )
                }

                Box(contentAlignment = Alignment.Center){
                    Button(onClick = {}) {
                        Text("Login")
                    }
                }
            }
        }

    }
}