package com.example.movies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movies.datalayer.Movie
import com.example.movies.uilayer.AddMovieScreen
import com.example.movies.uilayer.HomeScreen
import com.example.movies.uilayer.MovieListScreen

@Composable
fun MovieNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.All.name) {

        composable(route = Routes.Add.name) {
            //AddMovieScreen(movie)
        }
        composable(route = Routes.All.name) {
            MovieListScreen()
        }
    }
}