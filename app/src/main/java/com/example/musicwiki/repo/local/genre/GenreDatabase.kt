package com.example.musicwiki.repo.local.genre

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Genre::class], version = 2, exportSchema = false)
abstract class GenreDatabase : RoomDatabase() {
    abstract val genreDAO: GenreDAO

    companion object {
        @Volatile
        private var INSTANCE: GenreDatabase? = null

        fun getInstance(context: Context): GenreDatabase {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        GenreDatabase::class.java,
                        "genre_database_history"
                    ).fallbackToDestructiveMigration()
                        .build()
                }
                return INSTANCE!!
            }
        }
    }
}