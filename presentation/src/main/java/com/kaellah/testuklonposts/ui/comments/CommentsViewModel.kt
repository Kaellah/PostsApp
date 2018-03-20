package com.kaellah.testuklonposts.ui.comments

import android.support.v7.util.DiffUtil
import android.support.v7.util.DiffUtil.DiffResult
import com.kaellah.domain.entity.CommentEntity
import com.kaellah.domain.interactor.comment.GetCommentsUseCase
import com.kaellah.domain.util.delegate
import com.kaellah.testuklonposts.viewmodel.BaseViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import kotlin.LazyThreadSafetyMode.NONE


class CommentsViewModel @Inject constructor(private val getCommentsUseCase: GetCommentsUseCase) : BaseViewModel() {

    private val commentsObserver by lazy(NONE) {
        getCommentsUseCase.execute().toObservable().replay(1).delegate(onClearedDisposable)
    }

    fun getComments(postId: Int, fetch: Boolean, oldList: MutableList<CommentEntity>): Observable<Pair<List<CommentEntity>, DiffResult>> {
        getCommentsUseCase.postId = postId
        return commentsObserver.connect(fetch)
                .map<List<CommentEntity>> { ArrayList<CommentEntity>(it) }  //make copy array (necessary for diff utils)
                .map { it to DiffUtil.calculateDiff(CommentsAdapter.Diff(oldList, it)) }
                .observeOn(AndroidSchedulers.mainThread())
    }
}