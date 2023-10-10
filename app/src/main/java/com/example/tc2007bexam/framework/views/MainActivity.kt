package com.example.tc2007bexam.framework.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tc2007bexam.data.network.movie.Movie
import com.example.tc2007bexam.data.network.movie.Result
import com.example.tc2007bexam.databinding.ActivityMainBinding
import com.example.tc2007bexam.framework.adapters.MovieAdapter
import com.example.tc2007bexam.framework.viewmodels.MainViewModel

class MainActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter : MovieAdapter = MovieAdapter()
    private lateinit var data:ArrayList<Movie>
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        viewModel.getMovieList()
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpRecyclerView(dataForList: List<Result>){
        binding.RVMovie.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        binding.RVMovie.layoutManager = linearLayoutManager
        adapter.MovieAdapter(dataForList, this)
        binding.RVMovie.adapter = adapter
    }
    private fun initializeObservers(){
        viewModel.movieLiveData.observe(this){ movie ->
            setUpRecyclerView(movie.results)
        }
    }
}