package com.karim.movies.uI.homeScreen.movieDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.karim.movies.R
import com.karim.movies.databinding.FragmentMovieDetailsBinding
import com.karim.movies.utils.Constants

class MovieDetailsFragment : Fragment() {

    private var _binding:FragmentMovieDetailsBinding? =null
    private val mBinding get()=_binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentMovieDetailsBinding.inflate(inflater,container,false)
        return _binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}