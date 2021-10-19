package com.example.musicwiki.repo.local.artists

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Artists::class], version = 1, exportSchema = false)
abstract class ArtistsDatabase : RoomDatabase(){
    abstract val artistsDAO: ArtistsDAO
    companion object {
        @Volatile
        private var INSTANCE: ArtistsDatabase? = null

        fun getInstance(context: Context): ArtistsDatabase {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ArtistsDatabase::class.java,
                        "artists_database_history"
                    ).fallbackToDestructiveMigration()
                        .build()
                }
                return INSTANCE!!
            }
        }
    }
}