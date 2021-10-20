package com.example.musicwiki.repo.local.genre

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface GenreDAO {
    @Insert
    suspend fun insert(item:Genre)

    @Update
    suspend fun update(item:Genre)

    @Query("SELECT * FROM genre LIMIT :lim")
    fun getData(lim:Int):LiveData<List<Genre>>

    @Query("SELECT * FROM genre")
    fun getAllData():LiveData<List<Genre>>

    @Query("SELECT Count(id) FROM genre")
    fun getCount():Int

    @Query("SELECT * from genre WHERE id =:key")
    fun getItemById(key:Long):LiveData<Genre>

    @Query("SELECT * from genre WHERE name =:key")
    fun getItemByName(key:String):LiveData<Genre>

    @Query("SELECT id FROM genre WHERE name =:q")
    fun getIdByName(q:String):Long?
}