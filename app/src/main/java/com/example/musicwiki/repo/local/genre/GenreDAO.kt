package com.example.musicwiki.repo.local.genre

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GenreDAO {
    @Insert
    suspend fun insert(item:Genre)

    @Query("SELECT * FROM genre LIMIT :lim")
    fun getData(lim:Int):LiveData<List<Genre>>
}