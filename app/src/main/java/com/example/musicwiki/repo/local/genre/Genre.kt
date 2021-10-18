package com.example.musicwiki.repo.local.genre

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genre")
data class Genre  (
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,

    @ColumnInfo(name = "name")
    var name: String? = null,

    @ColumnInfo(name = "count")
    var count: Int? = null,

    @ColumnInfo(name = "reach")
    var reach: Int? = null,
)