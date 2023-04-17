package com.example.movies.datalayer

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieRepository(private val movieDAO: MovieDAO) {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun addMovie(movie: Movie) {
        coroutineScope.launch(Dispatchers.IO) {
            movieDAO.addMovie(movie)
        }
    }

    suspend fun getAllMovies(): Flow<List<Movie>> {
        return withContext(Dispatchers.IO) {
            movieDAO.getAllMovies()
        }
    }

    fun deleteAllMovies() {
        coroutineScope.launch(Dispatchers.IO) {
            movieDAO.deleteMovies()
        }
    }

}