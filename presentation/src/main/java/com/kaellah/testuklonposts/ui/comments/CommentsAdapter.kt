package com.kaellah.testuklonposts.ui.comments

import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.ViewGroup
import com.artemkopan.recycler.adapter.RecyclerListAdapter
import com.artemkopan.recycler.diff.BaseDiffCallback
import com.artemkopan.utils.ViewUtils
import com.kaellah.domain.entity.CommentEntity
import com.kaellah.domain.entity.UserEntity
import com.kaellah.testuklonposts.R
import kotlinx.android.synthetic.main.item_view.*
import javax.inject.Inject


class CommentsAdapter @Inject constructor() : RecyclerListAdapter<CommentEntity, ViewHolder>() {

    companion object {
        private const val HEADER = 0
        private const val ITEM = 1
    }

    private var userEntity: UserEntity? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            HEADER -> {
                CommentsHeaderViewHolder(ViewUtils.inflateView(parent, R.layout.header_item_view))
            }
            ITEM -> {
                val holder = CommentsViewHolder(ViewUtils.inflateView(parent, R.layout.item_view))
                holder.constraint.setOnClickListener { callOnItemClick(holder, it) }
                holder
            }
            else -> throw NotImplementedError("Not implemented viewType")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, model: CommentEntity, position: Int) {
        (holder as? CommentsViewHolder)?.bind(model, position)
    }

    override fun onBindHeaderHolder(holder: ViewHolder) {
        (holder as? CommentsHeaderViewHolder)?.bind(userEntity, 0)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) HEADER else ITEM
    }

    fun setUser(userEntity: UserEntity) {
        this.userEntity = userEntity
        notifyItemChanged(0)
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