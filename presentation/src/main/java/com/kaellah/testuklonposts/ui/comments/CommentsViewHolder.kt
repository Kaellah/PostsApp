package com.kaellah.testuklonposts.ui.comments

import android.content.Context
import android.view.View
import com.artemkopan.recycler.holder.BaseHolder
import com.kaellah.domain.entity.CommentEntity
import kotlinx.android.extensions.CacheImplementation.SPARSE_ARRAY
import kotlinx.android.extensions.ContainerOptions
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_view.*

@ContainerOptions(SPARSE_ARRAY)
class CommentsViewHolder(override val containerView: View) : BaseHolder<CommentEntity>(containerView), LayoutContainer {

    override fun bind(context: Context?, item: CommentEntity, position: Int) {
        titleTextView.text = item.email
        bodyTextView.text = item.body
    }

    override fun clear() {
    }
}