package com.example.movies

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface MovieApi {
    @Headers("X-RapidAPI-Key: ba93d4f796msh746f2b3d6b6e02dp1e5c61jsn6ba25bc575f4",
             "X-RapidAPI-Host: imdb-top-100-movies.p.rapidapi.com",
              "Content_type: application/json"  )
    @GET(".")
    suspend fun getTopMovie()
    : Response<ArrayList<Movie>>

    @Headers("X-RapidAPI-Key: ba93d4f796msh746f2b3d6b6e02dp1e5c61jsn6ba25bc575f4",
             "X-RapidAPI-Host: imdb-top-100-movies.p.rapidapi.com",
        "Content_type: application/json")
    @GET("/{movie_id}")
    suspend fun getTopMovieById(
        @Path("movie_id") movieID : String
    ):Response<Movie>
}