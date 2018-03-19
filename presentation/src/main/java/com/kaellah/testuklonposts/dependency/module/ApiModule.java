package com.kaellah.testuklonposts.dependency.module;

import com.kaellah.data.api.PostsService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @since 10/11/17
 */
@Module
public class ApiModule {

    @Singleton
    @Provides
    PostsService providePostsService(Retrofit retrofit) {
        return retrofit.create(PostsService.class);
    }
}
