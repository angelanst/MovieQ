package com.example.movieq.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieq.R
import com.example.movieq.core.domain.model.Movie
import com.example.movieq.core.ui.MovieAdapter
import com.example.movieq.detail.DetailActivity
import com.example.movieq.favorite.databinding.ActivityFavoriteBinding
import com.example.movieq.favoriteModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding
    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)

        movieAdapter = MovieAdapter()
        favoriteViewModel.favMovie.observe(this, { dataList ->
            if (dataList != null) {
                movieAdapter.setData(dataList)
            }
        })

        showRecyclerView()
        setActionBar()
    }

    private fun setActionBar() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = resources.getString(R.string.favorite)
        }
    }

    private fun showRecyclerView() {
        movieAdapter = MovieAdapter()

        binding.rvFavMovie.layoutManager = LinearLayoutManager(this)
        binding.rvFavMovie.adapter = movieAdapter
        binding.rvFavMovie.setHasFixedSize(true)

        movieAdapter.onItemClick = { selectedData -> setSelectedMovie(selectedData) }
    }

    private fun setSelectedMovie(movie: Movie) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(DetailActivity.MOVIE, movie)
        }
        startActivity(intent)
    }
}