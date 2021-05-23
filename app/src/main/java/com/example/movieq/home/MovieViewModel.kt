package com.example.movieq.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.movieq.core.domain.usecase.MovieUseCase

class MovieViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val movie = movieUseCase.getAllMovie().asLiveData()
}