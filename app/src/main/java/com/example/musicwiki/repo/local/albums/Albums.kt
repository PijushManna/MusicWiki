package com.example.musicwiki.repo.local.albums

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "albums")
data class Albums(
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

    @ColumnInfo(name = "play_count")
    var playCount:String? = null,

    @ColumnInfo(name = "listeners")
    var listeners:String? = null,

    @ColumnInfo(name = "published")
    var published:String? = null,

    @ColumnInfo(name = "summery")
    var summery:String? = null,

    @ColumnInfo(name = "content")
    var content:String? = null,
)
