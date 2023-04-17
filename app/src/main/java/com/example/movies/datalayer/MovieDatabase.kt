package com.example.movies.datalayer

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDAO(): MovieDAO

    companion object {
        @Volatile
        private var instance: MovieDatabase? = null

        fun getDatabase(context: Context) : MovieDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(context, MovieDatabase::class.java, "movieDatabase")
                    .build()
                    .also { instance = it }
            }
        }

    }

}