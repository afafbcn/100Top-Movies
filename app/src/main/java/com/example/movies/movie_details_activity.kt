package com.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.mWebView
import kotlinx.android.synthetic.main.activity_movie_details.movie_big_image
import kotlinx.android.synthetic.main.activity_movie_details.movie_description_details
import kotlinx.android.synthetic.main.activity_movie_details.movie_rating_details
import kotlinx.android.synthetic.main.activity_movie_details.movie_title

class movie_details_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        val movieId = intent.extras!!.getString("movieId")
        val MovieVM = ViewModelProvider(this).get(MovieViewModel::class.java)
        MovieVM.getMovieById(movieId!!)
        MovieVM.movie.observe(this){movie ->
            if(movie!=null){
                //fill data in the layout
                movie_title.text = "${movie.title} (${movie.year})"
                mWebView.settings.javaScriptEnabled = true
                mWebView.loadUrl(movie.trailer_embed_link)
                mWebView.webChromeClient = WebChromeClient()
                movie_rating_details.text = movie.rating
                movie_description_details.text = movie.description
                Picasso.get().load(movie.big_image).into(movie_big_image)

            }
        }
    }

}
