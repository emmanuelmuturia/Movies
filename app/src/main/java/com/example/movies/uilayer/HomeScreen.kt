package com.example.movies.uilayer

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.movies.navigation.Routes

@Composable
fun HomeScreen(navController: NavHostController) {

    val movieViewModel: MovieViewModel = viewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyButton(onClick = { navController.navigate(Routes.Add.name) }, text = "Add")
        Spacer(modifier = Modifier.height(7.dp))
        MyButton(onClick = { movieViewModel.deleteMovies() }, text = "Delete")
    }
}


@Composable
fun MyButton(
    onClick: () -> Unit,
    text: String
) {
    Button(
        onClick = onClick
    ) {
        Text(text = text)
    }
}