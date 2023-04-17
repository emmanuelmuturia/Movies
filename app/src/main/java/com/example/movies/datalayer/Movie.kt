package com.example.movies.datalayer

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "myMovies")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "movieId")
    val id: Int = 0,
    @ColumnInfo(name = "movieTitle")
    val title: String,
    @ColumnInfo(name = "movieYear")
    val year: Int
)
