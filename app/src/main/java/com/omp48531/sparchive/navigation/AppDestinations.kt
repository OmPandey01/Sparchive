package com.omp48531.sparchive.navigation

import kotlinx.serialization.Serializable


//i have to create a sealed interface to keep a list of screens i will have in my app

sealed interface Screen{

    @Serializable
    data object Home: Screen

    @Serializable
    data class DetailScreen(val noteId: Int):Screen
}