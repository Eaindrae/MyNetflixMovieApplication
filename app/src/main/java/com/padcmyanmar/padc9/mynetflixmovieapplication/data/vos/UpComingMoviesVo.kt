package com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos

import androidx.room.*

@Entity(tableName = "movie_upcoming",
    indices = [Index(value = ["upc_id"], unique = true)])
data class UpComingMoviesVo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pk_id")
    val id:Int,
    @Embedded(prefix = "upc_")
    val movieVo: MovieVo
)