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

    @Query("SELECT * FROM genre")
    fun getAllData():LiveData<List<Genre>>

    @Query("SELECT Count(id) FROM genre")
    fun getCount():Int
}