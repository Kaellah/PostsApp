package com.kaellah.testuklonposts.ui.comments

import android.view.ViewGroup
import com.artemkopan.recycler.adapter.RecyclerListAdapter
import com.artemkopan.recycler.diff.BaseDiffCallback
import com.artemkopan.utils.ViewUtils
import com.kaellah.domain.entity.CommentEntity
import com.kaellah.testuklonposts.R
import kotlinx.android.synthetic.main.item_view.*
import java.util.*
import javax.inject.Inject


class CommentsAdapter @Inject constructor() : RecyclerListAdapter<CommentEntity, CommentsViewHolder>(Collections.emptyList()) {

    companion object {
        private const val HEADER = 0
        private const val ITEM = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val holder = CommentsViewHolder(ViewUtils.inflateView(parent, R.layout.item_view))
        holder.constraint.setOnClickListener { callOnItemClick(holder, it) }
        return holder
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, model: CommentEntity, position: Int) {
        holder.bind(model, position)
    }

    class Diff(oldList: List<CommentEntity>?, newList: List<CommentEntity>?) : BaseDiffCallback<CommentEntity>(oldList, newList) {

        override fun areContentsTheSame(oldItem: CommentEntity?, newItem: CommentEntity?): Boolean {
            return oldItem != null && newItem != null &&
                    oldItem.id == newItem.id &&
                    oldItem.postId == newItem.postId &&
                    oldItem.name == newItem.name &&
                    oldItem.body == newItem.body
        }

        override fun areItemsTheSame(oldItem: CommentEntity?, newItem: CommentEntity?): Boolean {
            return oldItem?.id == newItem?.id
        }
    }
}