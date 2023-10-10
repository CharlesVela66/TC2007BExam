package com.example.tc2007bexam.domain

import com.example.tc2007bexam.data.MovieRepository
import com.example.tc2007bexam.data.network.movie.Movie

class MovieListRequirement {
    private val repository = MovieRepository()

    suspend operator fun invoke(): Movie? = repository.getMovieList()
}