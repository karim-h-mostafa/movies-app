package com.karim.movies.ui.homeScreen.moviesCategoriesScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.karim.domain.model.Movie
import com.karim.movies.databinding.ListItemMovieBinding
import com.karim.movies.utils.Constants
import com.squareup.picasso.Picasso
import javax.inject.Inject

class MoviesAdapter @Inject constructor() : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
    private var moviesList = listOf<Movie>()
    private var movieClickListener: ((Int)->Unit)? = null

    inner class MovieViewHolder(private val mBinding: ListItemMovieBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        init {
            itemView.setOnClickListener {
                val absoluteAdapterPosition = absoluteAdapterPosition
                if (absoluteAdapterPosition != RecyclerView.NO_POSITION)
                    movieClickListener?.invoke(moviesList[absoluteAdapterPosition].id)
            }
        }

        fun bindMovie(movie: Movie) {
            Picasso.get().load(Constants.IMAGE_URL + movie.poster).into(mBinding.ivPoster)
        }

    }

    fun setOnMovieClickListener(clickListener:((Int)->Unit)) {
        movieClickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val listItemMovieBinding =
            ListItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(listItemMovieBinding)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(moviesList[position])
    }
}