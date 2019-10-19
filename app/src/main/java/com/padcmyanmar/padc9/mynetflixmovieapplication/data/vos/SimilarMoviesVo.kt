package com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos

import androidx.room.*

@Entity(tableName = "movie_similar")
data class SimilarMoviesVo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pk_id")
    val id:Int,
    @ColumnInfo(name = "movie_id")
    val movieId:Int,
    @Embedded(prefix = "sim_")
    val movieVo: MovieVo
)