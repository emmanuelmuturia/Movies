package com.example.movies.datalayer

import android.app.Application

class MovieApplication : Application() {

    val database: MovieDatabase by lazy { MovieDatabase.getDatabase(this) }

    //lateinit var repository: MovieRepository

}