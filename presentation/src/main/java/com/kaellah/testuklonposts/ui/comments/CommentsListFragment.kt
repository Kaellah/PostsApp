package com.kaellah.testuklonposts.ui.comments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SimpleItemAnimator
import android.view.View
import com.kaellah.domain.Constants.Extra
import com.kaellah.testuklonposts.R
import com.kaellah.testuklonposts.dependency.Injectable
import com.kaellah.testuklonposts.ui.base.BaseFragment
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class CommentsListFragment : BaseFragment<CommentsViewModel>(), Injectable {

    companion object {
        fun newInstance(postId: Int, userId: Int) = CommentsListFragment().apply {
            arguments = Bundle()
                    .apply {
                        putInt(Extra.EXTRA_POST_ID, postId)
                        putInt(Extra.EXTRA_USER_ID, userId)
                    }
        }
    }

    private var postId: Int = 0
    private var userId: Int = 0

    @Inject
    lateinit var adapter: CommentsAdapter

    override fun getContentView(): Int = R.layout.fragment_list

    override fun getViewModelClass(): Class<CommentsViewModel> = CommentsViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        postId = arguments?.getInt(Extra.EXTRA_POST_ID)!!
        userId = arguments?.getInt(Extra.EXTRA_USER_ID)!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.title = getString(R.string.comments_title)

        swipeRefresh.setOnRefreshListener { getPosts(true) }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        (recyclerView.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
        adapter.showHeader(true)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getPosts(false)
        getUser()
    }

    private fun getUser() {
        viewModel
                .getUser(userId)
                .doOnSubscribe { onDestroyViewDisposable.add(it) }
                .subscribe({ adapter.setUser(it); getPosts(false) },
                           { showError(it) })
                .addTo(onStopDisposable)
    }

    private fun getPosts(fetch: Boolean) {
        viewModel
                .getComments(postId, fetch, adapter.list)
                .doOnSubscribe { onDestroyViewDisposable.add(it); showProgressContent() }
                .doFinally({ hideProgressContent() })
                .subscribe({
                               val isEmpty = adapter.isEmpty
                               adapter.setList(it.first, false)

                               if (isEmpty) {
                                   adapter.notifyDataSetChanged()

                               } else {
                                   it.second.dispatchUpdatesTo(adapter)
                               }
                           },
                           { hideProgressContent(); showError(it) })
                .addTo(onStopDisposable)
    }

    override fun showProgressContent() {
        swipeRefresh.isRefreshing = true
    }

    override fun hideProgressContent() {
        swipeRefresh.isRefreshing = false
    }
}
