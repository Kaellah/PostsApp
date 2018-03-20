package com.kaellah.testuklonposts.ui

import android.annotation.TargetApi
import android.os.Build.VERSION_CODES
import android.os.Bundle
import com.kaellah.testuklonposts.R
import com.kaellah.testuklonposts.dependency.Injectable
import com.kaellah.testuklonposts.ui.base.BaseActivity
import com.kaellah.testuklonposts.ui.posts.PostsListFragment
import com.kaellah.testuklonposts.ui.posts.PostsViewModel

class MainActivity : BaseActivity<PostsViewModel>(), Injectable {

    override fun getContentView(): Int = R.layout.activity_base

    override fun getViewModelClass(): Class<PostsViewModel> = PostsViewModel::class.java

    @TargetApi(VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            startFragment(PostsListFragment.newInstance(), false)
        }
    }
}
