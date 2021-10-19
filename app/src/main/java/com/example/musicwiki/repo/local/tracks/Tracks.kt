package com.example.musicwiki.repo.local.tracks

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tracks")
data class Tracks  (
    @PrimaryKey(autoGenerate = true)
    val id:Long = 0L,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "count")
    var count: Int? = null,

    @ColumnInfo(name = "reach")
    var reach: Int? = null,

    @ColumnInfo(name = "summery")
    var summery: String? = null,

    @ColumnInfo(name = "content")
    var content: String? = null,
)