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

    @Query("SELECT * FROM tracks LIMIT :lim")
    fun getData(lim:Int):LiveData<List<Tracks>>

    @Query("SELECT * FROM tracks")
    fun getAllData():LiveData<List<Tracks>>

    @Query("SELECT Count(id) FROM tracks WHERE tag =:tag")
    fun getCount(tag:String):Int

    @Query("SELECT * from tracks WHERE id =:key")
    fun getItemById(key:Long):LiveData<Tracks>

    @Query("SELECT * from tracks WHERE tag =:tag")
    fun getItemsByTag(tag:String):LiveData<List<Tracks>>
}