package com.chethanbhandarkar.gnews.ui.dashboard

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
import com.chethanbhandarkar.gnews.databinding.EachNewsdataType2Binding
import com.chethanbhandarkar.gnews.ui.topheadlines.NewsPagingAdapter
import com.chethanbhandarkar.gnews.utils.ApplicationUtil

class IndiaNewsAdapter(private val listener:IndiaNewsAdapter.onItemClickListener2):PagingDataAdapter<NewsData.Articles,IndiaNewsAdapter.ViewHolder>(NEWS_COMPARATOR) {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val binding=EachNewsdataType2Binding.inflate(LayoutInflater.from(parent.context),parent,false)
		return ViewHolder(binding)
	}

	@RequiresApi(Build.VERSION_CODES.O)
	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val currentItem=getItem(position)
		if(currentItem!=null){
			holder.bind(currentItem)
		}
	}





	inner class ViewHolder(private val binding:EachNewsdataType2Binding):RecyclerView.ViewHolder(binding.root)
	{



		init{


			binding.root.setOnClickListener {
				val position=bindingAdapterPosition
				if(position!=RecyclerView.NO_POSITION){

					val item=getItem(position)
					if(item!=null)
					{
						listener.onItemClick(item)
					}

				}

				//TODO

			}
		}

		@RequiresApi(Build.VERSION_CODES.O)
		fun bind(news:NewsData.Articles){
			binding.apply{
				tvTitle.text=news.title
tvTimepublished.text=ApplicationUtil.convertDate(news.publishedAt.toString())
				Glide.with(itemView)
					.load(news.urlToImage)
					.centerCrop()
					.transition(DrawableTransitionOptions.withCrossFade())
					.error(R.drawable.ic_launcher_background)
					.into(ivNewsimage)


			}
		}

	}

	interface onItemClickListener2{

		fun onItemClick(news:NewsData.Articles)
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