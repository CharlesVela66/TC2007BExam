package com.example.tc2007bexam.framework.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tc2007bexam.data.network.movie.Movie
import com.example.tc2007bexam.data.network.movie.Result
import com.example.tc2007bexam.domain.MovieListRequirement
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val movieLiveData = MutableLiveData<Movie>()
    private val movieListRequirement = MovieListRequirement()

    fun getMovieList(){
        viewModelScope.launch(Dispatchers.IO) {
            val result: Movie? = movieListRequirement()
            Log.d("Salida", result?.total_results.toString())
            CoroutineScope(Dispatchers.Main).launch {
                movieLiveData.postValue(result!!)
            }
        }}
}