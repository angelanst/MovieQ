package com.example.movieq.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.movieq.core.domain.usecase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favMovie = movieUseCase.getFavMovie().asLiveData()
}