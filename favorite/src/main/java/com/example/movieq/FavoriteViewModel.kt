package com.example.movieq

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.movieq.core.domain.usecase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favMovie = movieUseCase.getFavMovie().asLiveData()
}