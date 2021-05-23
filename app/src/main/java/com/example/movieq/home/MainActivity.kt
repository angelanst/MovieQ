package com.example.movieq.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieq.R
import com.example.movieq.core.data.Resource.*
import com.example.movieq.core.domain.model.Movie
import com.example.movieq.core.ui.MovieAdapter
import com.example.movieq.databinding.ActivityMainBinding
import com.example.movieq.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val movieViewModel: MovieViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieAdapter = MovieAdapter()
        movieViewModel.movie.observe(this, { dataList ->
            if (dataList != null) {
                when (dataList) {
                    is Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Success -> {
                        binding.progressBar.visibility = View.GONE
                        movieAdapter.setData(dataList.data)
                    }
                    is Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, dataList.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        showRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_favorite -> {
                val uri = Uri.parse("movieqapp://favorite")
                startActivity(Intent(Intent.ACTION_VIEW, uri))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showRecyclerView(){
        movieAdapter = MovieAdapter()
        binding.rvMovie.layoutManager = LinearLayoutManager(this)
        binding.rvMovie.setHasFixedSize(true)
        binding.rvMovie.adapter = movieAdapter

        movieAdapter.onItemClick = { selectedData -> setSelectedMovie(selectedData) }
    }

    private fun setSelectedMovie(movie: Movie) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(DetailActivity.MOVIE, movie)
        }
        startActivity(intent)
    }
}