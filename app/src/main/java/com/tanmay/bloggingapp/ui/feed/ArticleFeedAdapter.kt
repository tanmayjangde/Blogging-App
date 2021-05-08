package com.tanmay.bloggingapp.ui.feed

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tanmay.api.models.entities.Article
import com.tanmay.bloggingapp.R
import com.tanmay.bloggingapp.databinding.ListItemArticleBinding

class ArticleFeedAdapter(val onArticleClicked : (slug : String)-> Unit) : ListAdapter<Article, ArticleFeedAdapter.ArticleViewHolder>(
        object : DiffUtil.ItemCallback<Article>(){
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem==newItem
            }
            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.toString()==newItem.toString()
            }
        }
){

    inner class ArticleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
                parent.context.getSystemService(LayoutInflater::class.java).inflate(
                        R.layout.list_item_article,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        ListItemArticleBinding.bind(holder.itemView).apply {
            val article = getItem(position)

            authorTextView.text = article.author.username
            articleTitle.text = article.title
            bodySnippetText.text = article.body
            dateTextView.text = "May 1st, 2021" //TODO: format actual date
            authorImageView.background = ColorDrawable(Color.GRAY) //show actual image

            root.setOnClickListener{ onArticleClicked(article.slug)}
        }
    }
}