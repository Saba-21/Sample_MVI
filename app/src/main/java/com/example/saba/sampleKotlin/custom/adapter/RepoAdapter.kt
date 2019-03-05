package com.example.saba.sampleKotlin.custom.adapter

import android.view.View
import com.example.saba.sampleKotlin.R
import com.example.saba.sampleKotlin.custom.adapter.base.BaseAdapter
import com.example.saba.sampleKotlin.custom.adapter.base.BaseViewHolder
import com.example.saba.sampleKotlin.base.annotations.LayoutResourceId
import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import kotlinx.android.synthetic.main.repo_item.view.*

@LayoutResourceId(R.layout.repo_item)
class RepoAdapter : BaseAdapter<RepoModel, RepoAdapter.RepoViewHolder>() {

    override fun onViewInflated(view: View): RepoViewHolder = RepoViewHolder(view)

    inner class RepoViewHolder(view: View) : BaseViewHolder<RepoModel>(view) {

        override fun bind(item: RepoModel, vararg listeners: (RepoModel) -> Unit) {
            itemView.tvListUser.text = item.owner.login
            itemView.tvListName.text = item.name
            itemView.tvListLanguage.text = item.language
            itemView.tvListStars.text = item.starCount.toString()
            itemView.ivListAvatar.setImageURI(item.owner.avatarUrl)
            if (listeners.isNotEmpty()) {
                itemView.setOnClickListener {
                    listeners[0].invoke(item)
                }
            }
        }

    }

}