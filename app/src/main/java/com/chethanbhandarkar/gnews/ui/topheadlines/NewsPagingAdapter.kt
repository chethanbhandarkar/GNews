package com.chethanbhandarkar.gnews.ui.topheadlines

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.chethanbhandarkar.gnews.R
import com.chethanbhandarkar.gnews.data.repository.NewsData
import com.chethanbhandarkar.gnews.databinding.EachNewsdataBinding


class NewsPagingAdapter(private val listener:OnItemClickListener):PagingDataAdapter<NewsData.Articles,NewsPagingAdapter.NewsViewHolder >(NEWS_COMPARATOR) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding=EachNewsdataBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem=getItem(position)
       if(currentItem!=null)
       {
           holder.bind(currentItem)
       }


    }
    inner class NewsViewHolder(private val binding: EachNewsdataBinding) :
        RecyclerView.ViewHolder(binding.root) {



        init{

            binding.root.setOnClickListener{
                val position=bindingAdapterPosition
                if(position!=RecyclerView.NO_POSITION)
                {
                    val item=getItem(position)
                    if(item!=null)
                    {
                        listener.onItemClick(item)
                    }

                }

            }
        }
        fun bind(news: NewsData.Articles) {

            binding.apply {
               tvTitle.text = news.title
               tvTimepublished.text = news.publishedAt
                Glide.with(itemView)
                 //   .load("https://cdn.cnn.com/cnnnext/dam/assets/210701232124-bagram-air-base-afghanistan-0625-super-tease.jpg")
                    .load(news.urlToImage)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_launcher_background)
                    .into(ivNewsimage)


            }

        }
    }

    interface OnItemClickListener{
        fun onItemClick(news:NewsData.Articles)
    }

    companion object{

        private val NEWS_COMPARATOR=object:DiffUtil.ItemCallback<NewsData.Articles>(){


            override fun areItemsTheSame(
                oldItem: NewsData.Articles,
                newItem: NewsData.Articles
            )=oldItem.url==newItem.url

            override fun areContentsTheSame(
                oldItem: NewsData.Articles,
                newItem: NewsData.Articles
            )=oldItem==newItem

        }
            }






}