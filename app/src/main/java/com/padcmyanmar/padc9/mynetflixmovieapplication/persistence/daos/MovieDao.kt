package com.padcmyanmar.padc9.mynetflixmovieapplication.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.*
import com.padcmyanmar.padc9.mynetflixmovieapplication.data.vos.*

@Dao
abstract class MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertNowPlayingMovies(movies: List<NowPlayingMovieVo>): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPopularMovies(movies: List<PopularMoviesVo>): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertTopRatedMovies(movies: List<TopRatedMoviesVo>): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUpComingMovies(movies: List<UpComingMoviesVo>): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertSimilarMovies(movies: List<SimilarMoviesVo>): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertMovies(movies: List<MovieVo>): LongArray

    @Query("SELECT * FROM movie_now_playing")
    abstract fun getNowPlayingMovies(): LiveData<List<NowPlayingMovieVo>>

    @Query("SELECT * FROM movie_popular")
    abstract fun getPopularMovies(): LiveData<List<PopularMoviesVo>>

    @Query("SELECT * FROM movie_top_rated")
    abstract fun getTopRatedMovies(): LiveData<List<TopRatedMoviesVo>>

    @Query("SELECT * FROM movie_upcoming")
    abstract fun getUpComingMovies(): LiveData<List<UpComingMoviesVo>>

    @Query("SELECT * FROM movie_similar WHERE movie_id=:movieId")
    abstract fun getSimilarMovies(movieId: Int): LiveData<List<SimilarMoviesVo>>

    @Query("SELECT * FROM movies WHERE title LIKE :movieName AND poster_path IS NOT NULL")
    abstract fun searchMoviesByName(movieName: String): LiveData<List<MovieVo>>

    @Query("SELECT * FROM movies WHERE id=:id")
    abstract fun getMovieById(id: Int): MovieVo

    fun insertToNowPlayingMovies(movieList: List<MovieVo>) {

        val nowPlayingList = arrayListOf<NowPlayingMovieVo>()
        movieList.forEach {
            nowPlayingList.add(NowPlayingMovieVo(0, it))
        }
        insertMovies(movieList)
        insertNowPlayingMovies(nowPlayingList)
    }

    fun insertToPopularMovies(movieList: List<MovieVo>) {

        val popularMovieList = arrayListOf<PopularMoviesVo>()
        movieList.forEach {
            popularMovieList.add(PopularMoviesVo(0, it))
        }
        insertMovies(movieList)
        insertPopularMovies(popularMovieList)
    }

    fun insertToTopRatedMovies(movieList: List<MovieVo>) {

        val topRatedMovieList = arrayListOf<TopRatedMoviesVo>()
        movieList.forEach {
            topRatedMovieList.add(TopRatedMoviesVo(0, it))
        }
        insertMovies(movieList)
        insertTopRatedMovies(topRatedMovieList)
    }

    fun insertToUpcomingMovies(movieList: List<MovieVo>) {

        val upComingMovieList = arrayListOf<UpComingMoviesVo>()
        movieList.forEach {
            upComingMovieList.add(UpComingMoviesVo(0, it))
        }
        insertMovies(movieList)
        insertUpComingMovies(upComingMovieList)
    }

    fun insertToSimilarMovies(movieList: List<MovieVo>,movieId: Int) {

        val similarMovies = arrayListOf<SimilarMoviesVo>()
        movieList.forEach {
            similarMovies.add(SimilarMoviesVo(0,movieId, it))
        }
        insertMovies(movieList)
        insertSimilarMovies(similarMovies)
    }

}