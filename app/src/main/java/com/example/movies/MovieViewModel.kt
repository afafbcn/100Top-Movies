package com.example.movies

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel :ViewModel() {
    var topMovies = MutableLiveData<ArrayList<Movie>>()
    var movie = MutableLiveData<Movie>()

    fun getMovies () = CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = RetrofitInstance.MovieApi.getTopMovie()
            if (response.isSuccessful) {
                CoroutineScope(Dispatchers.Main).launch {
                    topMovies.value = response.body()
                }
            }else{

            }
        }catch (e : Exception){

        }
    }
    fun getMovieById(movieId:String)= CoroutineScope(Dispatchers.IO).launch{
        try {
            val response = RetrofitInstance.MovieApi.getTopMovieById(movieId)
            if (response.isSuccessful){
                CoroutineScope(Dispatchers.Main).launch {
                    movie.value=response.body()
                }
            }
            else{

            }

        }catch (e:Exception){
        }
    }
}