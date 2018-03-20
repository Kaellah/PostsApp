package com.kaellah.testuklonposts.ui.posts

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SimpleItemAnimator
import android.view.View
import com.artemkopan.recycler.listeners.OnItemClickListener
import com.kaellah.domain.entity.PostEntity
import com.kaellah.testuklonposts.R
import com.kaellah.testuklonposts.dependency.Injectable
import com.kaellah.testuklonposts.ui.base.BaseFragment
import com.kaellah.testuklonposts.ui.comments.CommentsListFragment
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class PostsListFragment : BaseFragment<PostsViewModel>(), Injectable, OnItemClickListener<PostEntity> {

    companion object {
        fun newInstance(): PostsListFragment = PostsListFragment()
    }

    @Inject
    lateinit var adapter: PostsAdapter

    override fun getContentView(): Int = R.layout.fragment_list

    override fun getViewModelClass(): Class<PostsViewModel> = PostsViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter.setOnItemClickListener(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.title = getString(R.string.posts_title)

        swipeRefresh.setOnRefreshListener { getPosts(true) }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        (recyclerView.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getPosts(false)
    }

    private fun getPosts(fetch: Boolean) {
        viewModel.getPosts(fetch, adapter.list)
                .doOnSubscribe { onDestroyViewDisposable.add(it); showProgressContent() }
                .doFinally({ hideProgressContent() })
                .subscribe({
                               adapter.setList(it.first, false)
                               it.second.dispatchUpdatesTo(adapter)
                           },
                           { hideProgressContent(); showError(it) })
                .addTo(onStopDisposable)
    }

    override fun onItemClickListener(view: View, pos: Int, item: PostEntity?, vararg transactionViews: View?) {
        item?.let {
            startFragment(CommentsListFragment.newInstance(it.id, it.userId), true)
        }
    }

    override fun showProgressContent() {
        swipeRefresh.isRefreshing = true
    }

    override fun hideProgressContent() {
        swipeRefresh.isRefreshing = false
    }
}
