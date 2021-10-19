package com.example.musicwiki.repo.local.albums

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AlbumsDAO {
    @Insert
    suspend fun insert(item:Albums)

    @Query("SELECT COUNT(id) FROM albums WHERE tag = :tagName")
    fun getCount(tagName:String):Int
}