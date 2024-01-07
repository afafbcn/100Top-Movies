package com.example.movies

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movie_row.view.movie_genre
import kotlinx.android.synthetic.main.movie_row.view.movie_image
import kotlinx.android.synthetic.main.movie_row.view.movie_rating
import kotlinx.android.synthetic.main.movie_row.view.movie_title
import kotlinx.android.synthetic.main.movie_row.view.movie_year

class MovieViewHolder (itemView:View):RecyclerView.ViewHolder(itemView) {
    val movie_title = itemView.movie_title
    val movie_rating = itemView.movie_rating
    val movie_image = itemView.movie_image
    val movie_genre = itemView.movie_genre
    val movie_year = itemView.movie_year
}
