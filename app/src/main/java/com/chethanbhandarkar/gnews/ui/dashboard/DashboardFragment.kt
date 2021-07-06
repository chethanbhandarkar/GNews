package com.chethanbhandarkar.gnews.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.chethanbhandarkar.gnews.data.repository.NewsData
import com.chethanbhandarkar.gnews.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment(),IndiaNewsAdapter.onItemClickListener2 {
	private var _binding: FragmentDashboardBinding? = null
	private val binding get() = _binding!!

	private val viewModel by  viewModels<DashboardViewModel>()
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		_binding = FragmentDashboardBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

        val adapter=IndiaNewsAdapter(this)
		binding.rvDashboardIndia.adapter=adapter
		binding.rvDashboardIndia.layoutManager=StaggeredGridLayoutManager(1,LinearLayoutManager.VERTICAL)



		viewModel.news.observe(viewLifecycleOwner, Observer {

			adapter.submitData(viewLifecycleOwner.lifecycle,it)
		})





	}
	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	override fun onItemClick(news: NewsData.Articles) {


		val action=DashboardFragmentDirections.actionNavigationDashboardToNewsDetailsFragment(news)
		findNavController().navigate(action)
	}
}