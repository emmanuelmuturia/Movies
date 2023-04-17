package com.example.movies.uilayer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.movies.datalayer.Movie
import com.example.movies.navigation.Routes

@Composable
fun MovieListScreen(movieViewModel: MovieViewModel = viewModel(), navController: NavHostController) {

    val movieList by movieViewModel.movieState.collectAsState()

        LazyColumn {
            items(movieList) { theMovies ->
                MovieCard(movies = theMovies)
            }
        }
    }



@Composable
fun MovieCard(movies: Movie) {
    Card(
        elevation = 7.dp
    ) {
        Column(
            modifier = Modifier.padding(7.dp),
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Text(text = "Title: ${movies.title}")
            Spacer(modifier = Modifier.height(3.dp))
            Text(text = "Year: ${movies.year}")
            Spacer(modifier = Modifier.height(3.dp))
        }
    }
}