package com.example.musicwiki.repo.local.artists

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artists")
data class Artists(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name = "name")
    var name: String? = null,

    @ColumnInfo(name = "tag")
    var tag: String? = null,

    @ColumnInfo(name = "mbid")
    var mbid: String? = null,

    @ColumnInfo(name = "url")
    var url: String? = null,

    @ColumnInfo(name = "artist")
    var artist: String? = null,

    @ColumnInfo(name = "image")
    var image: String? = null,

    @ColumnInfo(name = "rank")
    var rank: String? = null,
)
