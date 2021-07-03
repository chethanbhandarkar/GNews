package com.chethanbhandarkar.gnews.ui.topheadlines

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.chethanbhandarkar.gnews.R
import com.chethanbhandarkar.gnews.data.repository.NewsData
import com.chethanbhandarkar.gnews.databinding.EachNewsdataBinding
import com.chethanbhandarkar.gnews.utils.ApplicationUtil

class NewsPagingAdapter(private val listener: OnItemClickListener) :
	PagingDataAdapter<NewsData.Articles, NewsPagingAdapter.NewsViewHolder>(NEWS_COMPARATOR) {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
		val binding =
			EachNewsdataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return NewsViewHolder(binding)
	}

	@RequiresApi(Build.VERSION_CODES.O)
	override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
		val currentItem = getItem(position)
		if (currentItem != null) {
			holder.bind(currentItem)
		}

	}

	inner class NewsViewHolder(private val binding: EachNewsdataBinding) :
		RecyclerView.ViewHolder(binding.root) {



		init {
			binding.root.setOnClickListener {
				val position = bindingAdapterPosition
				if (position != RecyclerView.NO_POSITION) {
					val item = getItem(position)
					if (item != null) {
						listener.onItemClick(item)
					}

				}
			}
		}

		@RequiresApi(Build.VERSION_CODES.O)
		fun bind(news: NewsData.Articles) {
			binding.apply {
				tvTitle.text = news.title
				tvTimepublished.text =
					"Published at: ".plus(ApplicationUtil.convertDate(news.publishedAt.toString()))
				Glide.with(itemView)
					.load(news.urlToImage)
					.centerCrop()
					.transition(DrawableTransitionOptions.withCrossFade())
					.error(R.drawable.ic_launcher_background)
					.into(ivNewsimage)
			}

		}
	}

	interface OnItemClickListener {
		fun onItemClick(news: NewsData.Articles)
	}

	companion object {
		private val NEWS_COMPARATOR = object : DiffUtil.ItemCallback<NewsData.Articles>() {
			override fun areItemsTheSame(
				oldItem: NewsData.Articles,
				newItem: NewsData.Articles
			) = oldItem.url == newItem.url

			override fun areContentsTheSame(
				oldItem: NewsData.Articles,
				newItem: NewsData.Articles
			) = oldItem == newItem

		}
	}

}