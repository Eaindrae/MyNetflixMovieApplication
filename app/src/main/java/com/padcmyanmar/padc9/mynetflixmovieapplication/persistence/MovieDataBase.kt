package com.padcmyanmar.padc9.mynetflixmovieapplication.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.*
import com.padcmyanmar.padc9.mynetflixmovieapplication.persistence.daos.MovieDao
import com.padcmyanmar.padc9.mynetflixmovieapplication.persistence.typeconverters.GenreListTypeConverter
import com.padcmyanmar.padc9.mynetflixmovieapplication.utils.DB_NAME

@Database(
    entities = [NowPlayingMovieVo::class, PopularMoviesVo::class, SimilarMoviesVo::class,
        TopRatedMoviesVo::class, UpComingMoviesVo::class,MovieVo::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(GenreListTypeConverter::class)
abstract class MovieDataBase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private var instances: MovieDataBase? = null
        fun getInstance(context: Context): MovieDataBase {
            if (instances == null) {
                instances = Room.databaseBuilder(context, MovieDataBase::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration().build()
            }
            return instances!!
        }
    }

}