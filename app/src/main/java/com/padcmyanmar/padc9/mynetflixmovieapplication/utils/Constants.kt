package com.padcmyanmar.padc9.mynetflixmovieapplication.utils

import com.padcmyanmar.padc9.mynetflixmovieapplication.BuildConfig


const val IMAGE_PATH = "https://image.tmdb.org/t/p/w200"
const val DB_NAME = "movieDB"
const val BASE_URL = "https://api.themoviedb.org/3/"
const val PARAM_PAGE = "page"
const val PARAM_QUERY = "query"
const val API_KEY =BuildConfig.TMDB_API_KEY
const val LANGUAGE = "en-US"

const val NULL_RESPONSE = "Please check the Internet Connection And Try Again!."


const val URL_GET_POPULAR = "${BASE_URL}movie/popular?api_key=$API_KEY&language=$LANGUAGE"
const val URL_GET_TOP_RATED = "${BASE_URL}movie/top_rated?api_key=$API_KEY&language=$LANGUAGE"
const val URL_GET_UPCOMING = "${BASE_URL}movie/upcoming?api_key=$API_KEY&language=$LANGUAGE"
const val URL_GET_NOW_PLAYING = "${BASE_URL}movie/now_playing?api_key=$API_KEY&language=$LANGUAGE"
const val URL_GET_MOVIES_PREFIX = "${BASE_URL}movie/"
const val URL_GET_VIDEOS_POSTFIX = "/videos?api_key=$API_KEY&language=$LANGUAGE"
const val URL_GET_SIMILAR_MOVIES_POSTFIX = "/similar?api_key=$API_KEY&language=$LANGUAGE"
const val URL_GET_SEARCH_MOVIES = "${BASE_URL}search/movie?api_key=$API_KEY&language=$LANGUAGE"