package com.example.saba.sampleKotlin.adapter

import android.widget.TextView
import com.example.saba.sampleKotlin.R
import com.example.saba.sampleKotlin.domain.model.apiModels.RepoModel
import com.facebook.drawee.view.SimpleDraweeView
import com.zuluft.autoadapter.renderables.OrderableRenderer
import com.zuluft.autoadapterannotations.Render
import com.zuluft.autoadapterannotations.ViewField
import com.zuluft.generated.RepoListRendererViewHolder

@Render(layout = R.layout.repo_item,
            views = [
                ViewField(
                    id = R.id.ivListAvatar,
                    name = "avatar",
                    type = SimpleDraweeView::class),
                ViewField(
                    id = R.id.tvListUser,
                    name = "user",
                    type = TextView::class),
                ViewField(
                    id = R.id.tvListName,
                    name = "name",
                    type = TextView::class),
                ViewField(
                    id = R.id.tvListLanguage,
                    name = "language",
                    type = TextView::class),
                ViewField(
                    id = R.id.tvListStars,
                    name = "stars",
                    type = TextView::class)
            ])
class RepoListRenderer(val repoModel: RepoModel) : OrderableRenderer<RepoListRendererViewHolder>(){

    override fun apply(holder: RepoListRendererViewHolder){
        holder.avatar.setImageURI(repoModel.owner.avatarUrl)
        holder.user.text = repoModel.owner.login
        holder.name.text = repoModel.name
        holder.language.text = repoModel.language
        holder.stars.text = repoModel.starCount.toString()
    }

    private fun getRepo(oR: OrderableRenderer<*>):
            RepoModel = (oR as RepoListRenderer).repoModel

    override fun compareTo(oR: OrderableRenderer<*>):
            Int = getRepo(oR).starCount.compareTo(repoModel.starCount)

    override fun areContentsTheSame(oR: OrderableRenderer<*>):
            Boolean = repoModel.name == getRepo(oR).name

    override fun areItemsTheSame(oR: OrderableRenderer<*>):
            Boolean = repoModel.id == getRepo(oR).id

}
