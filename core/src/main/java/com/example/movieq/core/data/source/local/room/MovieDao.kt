package com.example.movieq.core.data.source.local.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    fun getAllMovie(): Flow<List<com.example.movieq.core.data.source.local.entity.MovieEntity>>

    @Query("SELECT * FROM movie where favorite = 1")
    fun getFavMovie(): Flow<List<com.example.movieq.core.data.source.local.entity.MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: List<com.example.movieq.core.data.source.local.entity.MovieEntity>)

    @Update
    fun updateFavMovie(movie: com.example.movieq.core.data.source.local.entity.MovieEntity)
}