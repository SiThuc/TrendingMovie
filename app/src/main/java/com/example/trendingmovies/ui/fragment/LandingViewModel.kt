package com.example.trendingmovies.ui.fragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trendingmovies.model.Movie
import com.example.trendingmovies.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import timber.log.Timber
import timber.log.Timber.e
import java.util.*

class LandingViewModel @ViewModelInject constructor(
    movieRepository: Repository
) : ViewModel() {
    private val _trendingMovies = MutableLiveData<List<Movie>>()
    val trendingMovies: LiveData<List<Movie>>
        get() = _trendingMovies

    init {
        movieRepository.getTrendingMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({movies -> _trendingMovies.value = movies.results},
                {t -> Timber.e(t)})
    }

}