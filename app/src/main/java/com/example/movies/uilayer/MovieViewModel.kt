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

    private val database = MovieDatabase.getDatabase(app)
    private val dao = database.movieDAO()
    private val movieRepository = MovieRepository(movieDAO = dao)

    private var _movieState = MutableStateFlow<List<Movie>>(emptyList())
    val movieState: StateFlow<List<Movie>> = _movieState.asStateFlow()


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