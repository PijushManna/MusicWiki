package com.example.musicwiki.repo.local.albums

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AlbumsDAO {
    @Insert
    suspend fun insert(item:Albums)

    @Query("SELECT COUNT(id) FROM albums WHERE tag = :tagName")
    fun getCount(tagName:String):Int

    @Query("SELECT * FROM albums")
    fun getAllData():LiveData<List<Albums>>

    @Query("SELECT * FROM albums WHERE tag =:tagName")
    fun getAlbumsByTag(tagName: String):LiveData<List<Albums>>

    @Query("SELECT * FROM albums WHERE id =:key")
    fun getAlbumById(key: Long):LiveData<Albums>
}