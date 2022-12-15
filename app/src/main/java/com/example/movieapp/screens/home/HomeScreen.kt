package com.example.movieapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.data.Movie
import com.example.movieapp.data.getMovies
import com.example.movieapp.navigation.MovieScreens
import com.example.movieapp.widgets.MovieRow

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(elevation = 5.dp, backgroundColor = MaterialTheme.colors.background) {
                Text(text = "Movies", color = MaterialTheme.colors.onBackground)
            }
        },
    ) {
        MainContent(navController = navController)
        it.calculateBottomPadding()
    }
}


@Composable
fun MainContent(navController: NavController,
    movieList: List<Movie> = getMovies()
) {
    Column(Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList) {movie ->
                MovieRow(movie = movie) { title ->
                    navController.navigate(route = MovieScreens.Detail.name+"/$title")
                }
            }
        }
    }
}