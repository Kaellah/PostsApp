package com.kaellah.testuklonposts.dependency.module;

import com.kaellah.testuklonposts.ui.PostsListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @since 03/19/2018
 */

@Module()
public abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract PostsListActivity contributeMoviesActivity();
}
