package com.example.musicwiki.repo.local.tracks

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Tracks::class], version = 2, exportSchema = false)
abstract class TracksDatabase : RoomDatabase() {
    abstract val tracksDAO: TracksDAO

    companion object {
        @Volatile
        private var INSTANCE: TracksDatabase? = null

        fun getInstance(context: Context): TracksDatabase {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        TracksDatabase::class.java,
                        "tracks_database_history"
                    ).fallbackToDestructiveMigration()
                        .build()
                }
                return INSTANCE!!
            }
        }
    }
}