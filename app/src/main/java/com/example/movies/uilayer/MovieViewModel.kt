package com.example.movies.uilayer

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.datalayer.Movie
import com.example.movies.datalayer.MovieDatabase
import com.example.movies.datalayer.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MovieViewModel(app: Application) : AndroidViewModel(app) {

    val database = MovieDatabase.getDatabase(app)
    val dao = database.movieDAO()
    val movieRepository = MovieRepository(movieDAO = dao)

    private var _movieState = MutableStateFlow<List<Movie>>(emptyList())
    val movieState: StateFlow<List<Movie>> = _movieState.asStateFlow()

    /*fun getAllMovies(): Flow<List<Movie>> {
        return viewModelScope.launch {

        }
    }*/

    init {
        viewModelScope.launch {
            movieRepository.getAllMovies().collectLatest {
                _movieState.value = it
            }
        }
    }


    fun addMovie(movie: Movie) {
        movieRepository.addMovie(movie)
    }


    fun deleteMovies() {
        movieRepository.deleteAllMovies()
    }

}