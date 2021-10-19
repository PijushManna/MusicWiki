package com.example.musicwiki.repo.local.tracks

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TracksDAO {
    @Insert
    suspend fun insert(item: Tracks)

    @Update
    suspend fun update(item:Tracks)

    @Query("SELECT * FROM Tracks LIMIT :lim")
    fun getData(lim:Int):LiveData<List<Tracks>>

    @Query("SELECT * FROM Tracks")
    fun getAllData():LiveData<List<Tracks>>

    @Query("SELECT Count(id) FROM Tracks")
    fun getCount():Int

    @Query("SELECT * from Tracks WHERE id =:key")
    fun getItemById(key:Long):LiveData<Tracks>
}