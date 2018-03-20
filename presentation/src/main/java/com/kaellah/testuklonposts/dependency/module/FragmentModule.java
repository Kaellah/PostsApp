package com.kaellah.testuklonposts.dependency.module;


import com.kaellah.testuklonposts.ui.posts.PostsListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Class for fragments injecting
 */

@Module()
public abstract class FragmentModule {

    @ContributesAndroidInjector()
    abstract PostsListFragment contributePostsListFragment();
}
