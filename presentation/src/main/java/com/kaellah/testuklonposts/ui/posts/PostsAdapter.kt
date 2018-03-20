package com.kaellah.testuklonposts.ui.posts

import android.view.ViewGroup
import com.artemkopan.recycler.adapter.RecyclerListAdapter
import com.artemkopan.recycler.diff.BaseDiffCallback
import com.artemkopan.utils.ViewUtils
import com.kaellah.domain.entity.PostEntity
import com.kaellah.testuklonposts.R
import kotlinx.android.synthetic.main.item_view.*
import java.util.*
import javax.inject.Inject


class PostsAdapter @Inject constructor() : RecyclerListAdapter<PostEntity, PostViewHolder>(Collections.emptyList()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val holder = PostViewHolder(ViewUtils.inflateView(parent, R.layout.item_view))
        holder.constraint.setOnClickListener { callOnItemClick(holder, it) }
        return holder
    }

    override fun onBindViewHolder(holder: PostViewHolder, model: PostEntity, position: Int) {
        holder.bind(model, position)
    }

    class Diff(oldList: List<PostEntity>?, newList: List<PostEntity>?) : BaseDiffCallback<PostEntity>(oldList, newList) {

        override fun areContentsTheSame(oldItem: PostEntity?, newItem: PostEntity?): Boolean {
            return oldItem != null && newItem != null &&
                    oldItem.id == newItem.id &&
                    oldItem.userId == newItem.userId &&
                    oldItem.title == newItem.title &&
                    oldItem.body == newItem.body
        }

        override fun areItemsTheSame(oldItem: PostEntity?, newItem: PostEntity?): Boolean {
            return oldItem?.id == newItem?.id
        }
    }
}