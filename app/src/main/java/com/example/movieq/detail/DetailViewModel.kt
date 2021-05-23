package com.example.movieq.detail

import androidx.lifecycle.ViewModel
import com.example.movieq.core.domain.model.Movie
import com.example.movieq.core.domain.usecase.MovieUseCase

class DetailViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavMovie(movie: Movie, newStatus:Boolean) = movieUseCase.setFavMovie(movie, newStatus)
}