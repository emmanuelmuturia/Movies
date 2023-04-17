package com.example.movies.uilayer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.movies.datalayer.Movie
import com.example.movies.navigation.Routes

@Composable
fun AddMovieScreen(navController: NavHostController) {

    val movieViewModel: MovieViewModel = viewModel()

    var movieTitle by remember { mutableStateOf("") }
    var movieYear by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TheNewMovie(value = movieTitle, onValueChanged = {movieTitle = it}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next))
        TheNewMovie(value = movieYear, onValueChanged = {movieYear = it}, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done))
        NewButton(onClick = {
            movieViewModel.addMovie(movie = Movie(id = 0, title = movieTitle, year = movieYear.toInt()))
            navController.popBackStack(Routes.Start.name, inclusive = false)

                            }, text = "Add")
    }
}


@Composable
fun TheNewMovie(
    value: String,
    onValueChanged: (String) -> Unit,
    keyboardOptions: KeyboardOptions
) {
    OutlinedTextField(value = value, onValueChange = onValueChanged, keyboardOptions = keyboardOptions)
}


@Composable
fun NewButton(
    onClick: () -> Unit,
    text: String
) {
    Button(onClick = onClick) {
        Text(text = text)
    }
}