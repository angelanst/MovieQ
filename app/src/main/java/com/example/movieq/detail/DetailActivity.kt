package com.example.movieq.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.movieq.core.domain.model.Movie
import org.koin.android.viewmodel.ext.android.viewModel
import com.example.movieq.core.utils.IMAGE_URL
import com.example.movieq.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        const val MOVIE = "movie"
    }

    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailMovie = intent.getParcelableExtra<Movie>(MOVIE) as Movie
        showMovieDetails(detailMovie)
    }

    private fun showMovieDetails(movie: Movie) {
        supportActionBar?.title = movie.title
        binding.txtReleaseDate.text = movie.date
        binding.txtRatingDetail.text = String.format("%.1f", movie.rating)
        binding.txtTitle.text = movie.title
        binding.txtDescription.text = movie.description
        Glide.with(this)
            .load(IMAGE_URL+movie.poster)
            .into(binding.imgPoster)

        var stateMovie = movie.favorite
        setFavoriteStatus(stateMovie)
        binding.tbFavorite.setOnClickListener {
            stateMovie = !stateMovie
            setFavoriteStatus(stateMovie)
            detailViewModel.setFavMovie(movie, stateMovie)
        }
    }

    private fun setFavoriteStatus(state: Boolean) {
        binding.tbFavorite.isChecked = state
    }
}