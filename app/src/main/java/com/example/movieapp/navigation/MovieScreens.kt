package com.example.movieapp.navigation

enum class MovieScreens {
    Home,
    Detail;

    companion object {
        fun fromRoute(route: String?) : MovieScreens
        = when (route?.substringBefore(delimiter = "/")) {
            Home.name -> Home
            Detail.name -> Detail
            null -> Home
            else -> throw IllegalArgumentException("Route $route is not valid argument!")
        }
    }
}