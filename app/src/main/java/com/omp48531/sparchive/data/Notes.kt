package com.omp48531.sparchive.data

data class Note(
    val id:Int,
    val title:String ,
    val pages: Int,
    val data:String,
    val memberCount:Int
)

val dummyNotes=listOf<Note>(
    Note(1,"Devki Villlage",pages=5,"Village is great place to live in", memberCount = 4),
    Note(2,"Devki Villlage",pages=5,"Village is great place to live in", memberCount = 4),
    Note(3,"Devki Villlage",pages=5,"Village is great place to live in", memberCount = 4),
    Note(4,"Devki Villlage",pages=5,"Village is great place to live in", memberCount = 4),
    Note(1,"Devki Villlage",pages=5,"Village is great place to live in", memberCount = 4),
    Note(1,"Devki Villlage",pages=5,"Village is great place to live in", memberCount = 4),

)