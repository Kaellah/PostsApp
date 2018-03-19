package com.kaellah.testuklonposts.ui

import android.os.Bundle
import com.kaellah.testuklonposts.R
import com.kaellah.testuklonposts.dependency.Injectable
import com.kaellah.testuklonposts.ui.base.BaseActivity

class PostsListActivity : BaseActivity<PostsViewModel>(), Injectable {

    override fun getContentView(): Int = R.layout.activity_main

    override fun getViewModelClass(): Class<PostsViewModel> = PostsViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        
    }
}
