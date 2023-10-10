package com.example.tc2007bexam.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tc2007bexam.data.network.movie.Result
import com.example.tc2007bexam.databinding.ItemMovieBinding
import com.example.tc2007bexam.framework.adapters.viewholders.MovieViewHolder

class MovieAdapter: RecyclerView.Adapter<MovieViewHolder>() {
    var data:ArrayList<Result> = ArrayList()
    lateinit var context: Context

    fun MovieAdapter(basicData: List<Result>, context: Context){
        this.data = basicData as ArrayList<Result>
        this.context = context
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return data.size
    }
}