package com.omp48531.sparchive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.omp48531.sparchive.screens.NoteListScreen
import com.omp48531.sparchive.screens.NoteDetailScreen
import com.omp48531.sparchive.ui.theme.SparchiveTheme
import com.omp48531.sparchive.viewmodel.NotesViewModel

import com.omp48531.sparchive.screens.LoginScreen
import com.omp48531.sparchive.screens.RegistrationScreen

import  com.omp48531.sparchive.navigation.AppNavGraph

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavGraph()
        }

    }
}


//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val viewModel = NotesViewModel()
//        setContent {
//            val navController = rememberNavController()
//
//            NavHost(navController, startDestination = "login_screen") {
//                composable("list_screen") {
//                    NoteListScreen(
//                        viewModel = viewModel,
//                        onNoteClick = { noteId ->
//                            navController.navigate("detail_screen/$noteId")
//                        },
//                        modifier = Modifier.padding(16.dp)
//                    )
//                }
//
//                composable("login_screen") {
//                    LoginScreen(
//                        onBack = { navController.popBackStack() },
//                        onRegister = { navController.navigate("registration_screen") }
//                    )
//                }
//
//                composable("registration_screen") { // Added registration screen route
//                    RegistrationScreen(onBack = { navController.popBackStack() })
//                }
//
//                composable("detail_screen/{noteId}") { backStackEntry ->
//                    val noteId = backStackEntry.arguments?.getString("noteId")?.toIntOrNull()
//                    if (noteId != null) {
//                        NoteDetailScreen(viewModel = viewModel, noteId = noteId, onBack = {
//                            navController.popBackStack()
//                        })
//                    }
//                }
//            }
//        }
//    }
//}
