package com.example.trendingmovies.repository

import com.example.trendingmovies.model.Movies
import com.example.trendingmovies.network.MovieService
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val movieService: MovieService
) {
    fun getTrendingMovie(): Single<Movies>{
        return movieService.getTrendingMovie()
            .subscribeOn(Schedulers.io())
    }
}