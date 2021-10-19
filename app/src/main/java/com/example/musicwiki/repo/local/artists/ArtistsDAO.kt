package com.example.musicwiki.repo.local.artists

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ArtistsDAO {
    @Insert
    suspend fun insert(item:Artists)

    @Query("SELECT COUNT(id) FROM Artists WHERE tag = :tagName")
    fun getCount(tagName:String):Int

    @Query("SELECT * FROM artists")
    fun getAllData():LiveData<List<Artists>>

    @Query("SELECT * FROM artists WHERE tag =:tag")
    fun getArtistsByTag(tag:String):LiveData<List<Artists>>
}