package com.kaellah.testuklonposts.dependency.module

import com.kaellah.data.api.PostsService
import com.kaellah.data.repository.PostDataRepository
import com.kaellah.domain.repository.PostsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun providePostRepo(apiService: PostsService): PostsRepository = PostDataRepository(apiService)
}
