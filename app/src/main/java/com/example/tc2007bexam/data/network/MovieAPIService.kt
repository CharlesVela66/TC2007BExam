package com.example.tc2007bexam.data.network

import com.example.tc2007bexam.data.network.movie.Movie
import retrofit2.http.GET
import retrofit2.http.Header


interface MovieAPIService {
    //https://pokeapi.co/api/v2/pokemon/?limit=1279
    @GET("popular")
    suspend fun getMovieList(@Header("Authorization") token: String): Movie

}