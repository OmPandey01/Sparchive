package com.omp48531.sparchive.data

data class Note(
    val id:Int,
    val title:String ,
    val data:String,
)

val dummyNotes=listOf<Note>(
    Note(1,"Devki Villlage","Village is great place to live in"),
    Note(1,"naini ","Village is great place to live in"),
    Note(1,"Teliyerganj","Village is great place to live in"),
    Note(1,"Village","Village is great place to live in"),

)