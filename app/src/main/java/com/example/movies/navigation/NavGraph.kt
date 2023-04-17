package com.example.movies.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movies.datalayer.Movie
import com.example.movies.uilayer.AddMovieScreen
import com.example.movies.uilayer.HomeScreen
import com.example.movies.uilayer.MovieApp
import com.example.movies.uilayer.MovieListScreen

@Composable
fun MovieNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.Start.name) {

        composable(route = Routes.Start.name) {
            MovieApp(navController = navController)
        }

        composable(route = Routes.Add.name) {
            AddMovieScreen(navController = navController)
        }
        composable(route = Routes.All.name) {
            MovieListScreen(navController = navController)
        }
    }
}