package com.example.tc2007bexam.data.network

import com.example.tc2007bexam.data.network.movie.Movie
import com.example.tc2007bexam.utils.Constants

class MovieAPIClient {
    private lateinit var api: MovieAPIService

    suspend fun getMovieList(): Movie?{
        api = NetworkModuleDI()
        return try{
            api.getMovieList("Bearer ${Constants.TOKEN}")
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }
    }


}