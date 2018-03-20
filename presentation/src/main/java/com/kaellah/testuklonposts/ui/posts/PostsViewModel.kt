package com.kaellah.testuklonposts.ui.posts

import android.support.v7.util.DiffUtil
import android.support.v7.util.DiffUtil.DiffResult
import com.kaellah.domain.entity.PostEntity
import com.kaellah.domain.interactor.post.GetPostsUseCase
import com.kaellah.domain.util.delegate
import com.kaellah.testuklonposts.viewmodel.BaseViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import kotlin.LazyThreadSafetyMode.NONE

/**
 * @since 12/20/17
 */
class PostsViewModel @Inject constructor(private val getPostsUseCase: GetPostsUseCase) : BaseViewModel() {

    private val discoverObserver by lazy(NONE) {
        getPostsUseCase.execute().toObservable().replay(1).delegate(onClearedDisposable)
    }

    fun getPosts(fetch: Boolean, oldList: MutableList<PostEntity>): Observable<Pair<List<PostEntity>, DiffResult>> {
        return discoverObserver.connect(fetch)
                .map<List<PostEntity>> { ArrayList<PostEntity>(it) }  //make copy array (necessary for diff utils)
                .map { it to DiffUtil.calculateDiff(PostsAdapter.Diff(oldList, it)) }
                .observeOn(AndroidSchedulers.mainThread())
    }
}