package com.example.movies.uilayer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.movies.datalayer.Movie
import com.example.movies.navigation.Routes

@Composable
fun MovieApp(navController: NavHostController) {

    val viewModel: MovieViewModel = viewModel()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text("Movie") }) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    //viewModel.movieRepository.getAllMovies()
                    viewModel.addMovie(movie = Movie(id = 0, title = "Title 1", year = 2023))
                    navController.navigate(Routes.All.name)
                },
                backgroundColor = Color.Gray,
                shape = RoundedCornerShape(16.dp),
            ) {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add FAB",
                    tint = Color.White,
                )
            }
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colors.background
        ) {
            HomeScreen(navController = navController)
        }
    }
}