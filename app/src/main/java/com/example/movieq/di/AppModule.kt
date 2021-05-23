package com.example.movieq.di

import com.example.movieq.core.domain.usecase.MovieInteractor
import com.example.movieq.core.domain.usecase.MovieUseCase
import com.example.movieq.detail.DetailViewModel
import com.example.movieq.home.MovieViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}