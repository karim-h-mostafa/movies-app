package com.karim.movies.ui.homeScreen.moviesCategoriesScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.karim.movies.databinding.FragmentMoviesCategoriesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MoviesCategoriesFragment : Fragment() {

    private var _binding: FragmentMoviesCategoriesBinding? = null
    private val mBinding get() = _binding!!
    @Inject
    lateinit var moviesAdapter:MoviesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMoviesCategoriesBinding.inflate(
            inflater,
            container,
            false
        )
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        moviesAdapter.setOnMovieClickListener{position->
            val movieDetailsAction=MoviesCategoriesFragmentDirections.actionFromListToMovie(position)
            findNavController().navigate(movieDetailsAction)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun onMoviesListResponse(){

    }
}