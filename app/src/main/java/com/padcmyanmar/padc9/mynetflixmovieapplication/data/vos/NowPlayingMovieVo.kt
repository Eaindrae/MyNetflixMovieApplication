package com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos

import androidx.room.*

@Entity(tableName = "movie_now_playing",
    indices = [Index(value = ["np_id"], unique = true)]
)
data class NowPlayingMovieVo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pk_id")
    val id:Int,
    @Embedded(prefix = "np_")
    val movieVo: MovieVo
)