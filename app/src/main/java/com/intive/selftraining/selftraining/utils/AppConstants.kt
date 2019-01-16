package com.intive.selftraining.selftraining.utils

const val BASE_URL = "https://api.themoviedb.org/3/"
const val ORIGINAL_LOGO_SIZE = 6
const val SPAN_COUNT = 3
const val API_KEY = "api_key"
const val DB_NAME = "db_movie"
const val YOUTUBE_THUMBNAIL_URL = "http://img.youtube.com/vi/"
const val YOUTUBE_VIDEO_URL = "http://www.youtube.com/watch?v="
const val MOVIE_DETAILS = "movie_details"
const val MOVIE_VIDEO = "movie_video"

fun getYoutubeVideoPath(videoPath: String): String {
    return YOUTUBE_VIDEO_URL + videoPath
}

fun getYoutubeThumbnailPath(thumbnailPath: String): String {
    return "$YOUTUBE_THUMBNAIL_URL$thumbnailPath/sddefault.jpg"
}