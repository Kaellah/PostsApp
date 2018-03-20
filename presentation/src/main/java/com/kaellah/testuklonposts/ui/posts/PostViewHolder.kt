package com.kaellah.testuklonposts.ui.posts

import android.content.Context
import android.view.View
import com.artemkopan.recycler.holder.BaseHolder
import com.kaellah.domain.entity.PostEntity
import kotlinx.android.extensions.CacheImplementation.SPARSE_ARRAY
import kotlinx.android.extensions.ContainerOptions
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_view.*

@ContainerOptions(SPARSE_ARRAY)
class PostViewHolder(override val containerView: View) : BaseHolder<PostEntity>(containerView), LayoutContainer {

    override fun bind(context: Context?, item: PostEntity, position: Int) {
        titleTextView.text = item.title
        bodyTextView.text = item.body
    }

    override fun clear() {
    }
}