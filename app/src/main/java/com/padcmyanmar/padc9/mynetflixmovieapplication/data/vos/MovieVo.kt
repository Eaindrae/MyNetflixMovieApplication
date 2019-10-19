package com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies",
    indices = [Index(value = ["id"], unique = true)]
)
data class MovieVo(

    @SerializedName("popularity")
    @ColumnInfo(name = "popularity")
    val popularity: Double,

    @SerializedName("vote_count")
    @ColumnInfo(name = "vote_count")
    val voteCount: Int,

    @SerializedName("video")
    @ColumnInfo(name = "video")
    val video: Boolean,

    @SerializedName("poster_path")
    @ColumnInfo(name = "poster_path")
    val posterPath: String?,

    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    val id: Int,

    @SerializedName("adult")
    @ColumnInfo(name = "adult")
    val adult: Boolean,

    @SerializedName("backdrop_path")
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,

    @SerializedName("original_language")
    @ColumnInfo(name = "original_language")
    val originalLanguage: String,

    @SerializedName("original_title")
    @ColumnInfo(name = "original_title")
    val originalTitle: String,

    @SerializedName("genre_ids")
    @ColumnInfo(name = "genre_ids")
    val genreIds: List<Int>,

    @SerializedName("title")
    @ColumnInfo(name = "title")
    val title: String,

    @SerializedName("vote_average")
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,

    @SerializedName("overview")
    @ColumnInfo(name = "overview")
    val overview: String,

    @SerializedName("release_date")
    @ColumnInfo(name = "release_date")
    val releaseDate: String
)