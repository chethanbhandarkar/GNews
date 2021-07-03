package com.chethanbhandarkar.gnews.ui.newsdetails

import android.graphics.drawable.Drawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.chethanbhandarkar.gnews.R
import com.chethanbhandarkar.gnews.databinding.FragmentNewsdetailsBinding
import com.chethanbhandarkar.gnews.ui.dashboard.DashboardFragment
import com.chethanbhandarkar.gnews.ui.dashboard.DashboardViewModel
import com.chethanbhandarkar.gnews.ui.topheadlines.TopHeadlinesViewModel
import com.chethanbhandarkar.gnews.utils.ApplicationUtil
import com.google.android.material.bottomnavigation.BottomNavigationView

class NewsDetailsFragment : Fragment() {
	private val args by navArgs<NewsDetailsFragmentArgs>()

	companion object {
		fun newInstance() = NewsDetailsFragment()
	}


	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return inflater.inflate(R.layout.fragment_newsdetails, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val binding = FragmentNewsdetailsBinding.bind(view)

		binding.apply {
			val newsArticle = args.newsArticle

			tvDetailstitle.text = newsArticle.title
			tvDetailsdescription.text = newsArticle.description
			tvAuthor.text = "Author: ".plus(newsArticle.author.toString())
			tvContent.text = newsArticle.content
			Glide.with(this@NewsDetailsFragment)
				.load(newsArticle.urlToImage)
				.centerCrop()
				.transition(DrawableTransitionOptions.withCrossFade())
				.error(R.drawable.ic_launcher_background)
				.listener(object : RequestListener<Drawable> {
					override fun onLoadFailed(
						e: GlideException?,
						model: Any?,
						target: Target<Drawable>?,
						isFirstResource: Boolean
					): Boolean {
						progressBar.isVisible = false
						return false
					}

					override fun onResourceReady(
						resource: Drawable?,
						model: Any?,
						target: Target<Drawable>?,
						dataSource: DataSource?,
						isFirstResource: Boolean
					): Boolean {
						progressBar.isVisible = false
						return false
					}

				})
				.into(ivDetailsimage)
		}

	}

}