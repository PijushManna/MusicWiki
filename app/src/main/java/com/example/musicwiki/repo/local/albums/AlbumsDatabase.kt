package com.example.musicwiki.repo.local.albums

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Albums::class], version = 2, exportSchema = false)
abstract class AlbumsDatabase : RoomDatabase(){
    abstract val albumsDAO: AlbumsDAO
    companion object {
        @Volatile
        private var INSTANCE: AlbumsDatabase? = null

        fun getInstance(context: Context): AlbumsDatabase {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AlbumsDatabase::class.java,
                        "albums_database_history"
                    ).fallbackToDestructiveMigration()
                        .build()
                }
                return INSTANCE!!
            }
        }
    }
}