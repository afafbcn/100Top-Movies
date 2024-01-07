package com.example.movies

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MoviesAdapter (
    val context:Context,
    var data : ArrayList<Movie>
):RecyclerView.Adapter<MovieViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(context).inflate(R.layout.movie_row,parent,false)
        )

    }
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movie_title.text = "${data[position].title}"
        for ( genre in data[position].genre ){
            holder.movie_genre.text = "${holder.movie_genre.text}$genre,"
        }
        holder.movie_genre.text=holder.movie_genre.text.toString().subSequence(0,holder.movie_genre.text.toString().length-1)
        Picasso.get().load(data[position].image).into(holder.movie_image)
        holder.movie_year.text="(${data[position].year} )"
        holder.movie_rating.text=data[position].rating
        holder.itemView.setOnClickListener {
            val i = Intent(context,movie_details_activity::class.java)
            i.putExtra("movieId",data[position].id)
            context.startActivity(i)
        }


    }

    override fun getItemCount(): Int {
        return data.size
    }




}