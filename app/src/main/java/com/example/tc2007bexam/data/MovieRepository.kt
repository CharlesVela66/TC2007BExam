package com.example.tc2007bexam.data

import com.example.tc2007bexam.data.network.movie.Movie
import com.example.tc2007bexam.data.network.MovieAPIClient
import com.example.tc2007bexam.data.network.movie.Result

class MovieRepository {
    private val apiMovie = MovieAPIClient()

    suspend fun getMovieList(): Movie? = apiMovie.getMovieList()

}