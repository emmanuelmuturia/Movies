package com.example.movies.datalayer

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMovie(movie: Movie)

    @Query("DELETE FROM myMovies")
    suspend fun deleteMovies()

    @Query("SELECT * FROM myMovies ORDER BY movieId ASC")
    fun getAllMovies(): Flow<List<Movie>>

}