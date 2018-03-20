package com.kaellah.testuklonposts.ui.comments

import android.view.View
import com.artemkopan.recycler.holder.SimpleHolder
import com.kaellah.domain.entity.UserEntity
import com.kaellah.testuklonposts.R
import com.kaellah.testuklonposts.util.string
import kotlinx.android.extensions.CacheImplementation.SPARSE_ARRAY
import kotlinx.android.extensions.ContainerOptions
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.header_item_view.*

@ContainerOptions(SPARSE_ARRAY)
class CommentsHeaderViewHolder(override val containerView: View) : SimpleHolder<UserEntity>(containerView), LayoutContainer {

    override fun bind(item: UserEntity?, position: Int) {
        item?.let {
            nameTextView.text = String.format(containerView.context string R.string.name, it.name)
            emailTextView.text = String.format(containerView.context string R.string.email, it.email)
            phoneTextView.text = String.format(containerView.context string R.string.phone, it.phone)
            companyTextView.text = String.format(containerView.context string R.string.company, it.company.name)
        }
    }

    override fun clear() {
    }
}