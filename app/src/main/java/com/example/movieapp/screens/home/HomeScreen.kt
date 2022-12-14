package com.example.movieapp.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.MovieRow
import com.example.movieapp.navigation.MovieScreens

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(elevation = 5.dp, backgroundColor = Color.LightGray) {
                Text(text = "Movies")
            }
        },
    ) {
        MainContent(navController = navController)
        it.calculateBottomPadding()
    }
}


@Composable
fun MainContent(navController: NavController,
    movieList: List<String> = listOf(
        "Fellowship of the Ring",
        "Two Towers",
        "The Return of the King",
        "Return of Jedi",
        "Back to the Future",
        "Terminator"
    )
) {
    Column(Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(title = it) { title ->
                    navController.navigate(route = MovieScreens.Detail.name+"/$title")
                }
            }
        }
    }
}