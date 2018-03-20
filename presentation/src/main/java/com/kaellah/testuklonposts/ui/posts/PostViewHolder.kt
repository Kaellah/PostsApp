package com.kaellah.testuklonposts.ui.posts

import android.content.Context
import android.view.View
import com.artemkopan.recycler.holder.BaseHolder
import com.kaellah.domain.entity.PostEntity
import kotlinx.android.extensions.LayoutContainer


class PostViewHolder(override val containerView: View) : BaseHolder<PostEntity>(containerView), LayoutContainer {

    override fun bind(context: Context?, item: PostEntity, position: Int) {
    }

    override fun clear() {
    }
}