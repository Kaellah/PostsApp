package com.kaellah.testuklonposts.ui.posts

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SimpleItemAnimator
import android.view.View
import com.artemkopan.recycler.listeners.OnItemClickListener
import com.kaellah.domain.entity.PostEntity
import com.kaellah.testuklonposts.R
import com.kaellah.testuklonposts.dependency.Injectable
import com.kaellah.testuklonposts.ui.base.BaseActivity
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class PostsListActivity : BaseActivity<PostsViewModel>(), Injectable, OnItemClickListener<PostEntity> {

    @Inject
    lateinit var adapter: PostsAdapter

    override fun getContentView(): Int = R.layout.activity_main

    override fun getViewModelClass(): Class<PostsViewModel> = PostsViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter.setOnItemClickListener(this)

        swipeRefresh.setOnRefreshListener { getDiscover(true) }

        postsList.adapter = adapter
        postsList.layoutManager = LinearLayoutManager(this)
        (postsList.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
    }

    override fun onStart() {
        super.onStart()
        getDiscover(false)
    }

    private fun getDiscover(fetch: Boolean) {
        viewModel.getPosts(fetch, adapter.list)
                .doOnSubscribe { onDestroyDisposable.add(it); showContentProgress() }
                .doFinally({ hideContentProgress() })
                .subscribe({
                               adapter.setList(it.first, false)
                               it.second.dispatchUpdatesTo(adapter)
                           },
                           { hideContentProgress(); showError(it) })
                .addTo(onStopDisposable)

    }

    override fun onItemClickListener(view: View?, pos: Int, item: PostEntity?, vararg transactionViews: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showContentProgress() {
        super.showContentProgress()
    }

    override fun hideContentProgress() {
        super.hideContentProgress()
    }
}
