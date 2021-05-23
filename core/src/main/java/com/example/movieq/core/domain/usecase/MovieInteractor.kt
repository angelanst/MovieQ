package com.example.movieq.core.domain.usecase

import com.example.movieq.core.domain.model.Movie
import com.example.movieq.core.domain.repository.IMovieRepository

class MovieInteractor(private val movieRepository: IMovieRepository): MovieUseCase {
    override fun getAllMovie() = movieRepository.getAllMovie()
    override fun getFavMovie() = movieRepository.getFavMovie()
    override fun setFavMovie(movie: Movie, state: Boolean) = movieRepository.setFavMovie(movie, state)
}