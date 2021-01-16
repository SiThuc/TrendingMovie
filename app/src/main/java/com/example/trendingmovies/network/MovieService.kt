package com.example.trendingmovies.network

import com.example.trendingmovies.model.Movies
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface MovieService {
    @GET("trending/all/day?api_key=f1371f4970416d49c86d4b209b0606a5")
    fun getTrendingMovie(): Single<Movies>
}