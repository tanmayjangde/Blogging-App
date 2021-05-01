package com.tanmay.bloggingapp.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tanmay.api.models.entities.Article
import com.tanmay.bloggingapp.data.ArticlesRepo
import kotlinx.coroutines.launch

class FeedViewModel:ViewModel() {

    private val _feed = MutableLiveData<List<Article>>()

    val feed:LiveData<List<Article>> = _feed

    fun fetchGlobalFeed()=viewModelScope.launch {
        ArticlesRepo.getGlobalFeed().body()?.let{
            _feed.postValue(it.articles)
            Log.d("Feed", "feed fetched${it.articlesCount}")
        }
    }
}