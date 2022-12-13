package com.example.movieapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MovieAppTheme {
        Scaffold(
            topBar = {
                TopAppBar(elevation = 5.dp) {
                    Text(text = "Movies")
                }
            },
        ) {
            content()
            it.calculateBottomPadding()
        }
    }
}


@Composable
fun MovieRow(title: String, onItemClick: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(120.dp)
            .clickable {
                onItemClick.invoke(title)
            },
        elevation = 6.dp,
        shape = RoundedCornerShape(4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp
            ) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Movie image")
            }

            Text(
                text = title, modifier = Modifier.padding(horizontal = 5.dp)
            )
        }
    }
}


@Preview
@Composable
fun MainContent(
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
                    Log.d("", "MainContent: clicked: $title")
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApp {
        MainContent()
    }
}
