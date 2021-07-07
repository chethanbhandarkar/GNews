package com.chethanbhandarkar.gnews.ui.webview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.chethanbhandarkar.gnews.R
import com.chethanbhandarkar.gnews.databinding.FragmentWebviewBinding

class WebviewFragment : Fragment() {
	private val args by navArgs<WebviewFragmentArgs>()
   private lateinit var binding:FragmentWebviewBinding


	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_webview, container, false)

	}

	@SuppressLint("SetJavaScriptEnabled")
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding = FragmentWebviewBinding.bind(view)
		val newsArticleURLstring = args.uRLstring
		binding.webView.apply {
			// if you want to enable zoom feature
			webViewClient = WebViewClient()
			// this will load the url of the website
			loadUrl(newsArticleURLstring)
			// this will enable the javascript settings
			settings.javaScriptEnabled = true
			// if you want to enable zoom feature
			settings.setSupportZoom(true)
		}
	}




}












