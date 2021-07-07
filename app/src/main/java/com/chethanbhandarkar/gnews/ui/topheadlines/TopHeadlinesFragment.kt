package com.chethanbhandarkar.gnews.ui.topheadlines

import android.app.Activity
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavigatorProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.chethanbhandarkar.gnews.R
import com.chethanbhandarkar.gnews.data.repository.NewsData
import com.chethanbhandarkar.gnews.databinding.FragmentTopheadlinesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopHeadlinesFragment : Fragment(),NewsPagingAdapter.onItemClickListenr {

        private val topHeadlinesViewModel by viewModels<TopHeadlinesViewModel>()

    private var _binding: FragmentTopheadlinesBinding? = null

    private val binding get() = _binding!!

    private var searching: Boolean = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentTopheadlinesBinding.inflate(inflater, container, false)

        val toolbar: androidx.appcompat.widget.Toolbar = binding.toolBar
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        val adapter = NewsPagingAdapter(this)

        binding.apply {
            rvTopheadlines.setHasFixedSize(true)
            rvTopheadlines.adapter = adapter.withLoadStateHeaderAndFooter(

                header = LoadingStateAdapter {
                    adapter.retry()
                },
                footer = LoadingStateAdapter {
                    adapter.retry()
                },
            )
            adapter.addLoadStateListener {

                binding.apply {
                    if (adapter.itemCount == 0 && searching) {
                        noDataLottie.isVisible = true
                        tvTopheadlines.text = getString(R.string.string_nonews)
                    } else if (adapter.itemCount == 0) {
                        searchingLottie.isVisible = true
                        tvTopheadlines.text = getString(R.string.string_findingnews)
                    } else {
                        noDataLottie.isVisible = false
                        searchingLottie.isVisible = false
                        tvTopheadlines.text = getString(R.string.string_topheadlines)

                    }
                }


            }





        }



        topHeadlinesViewModel.news.observe(viewLifecycleOwner,{
            adapter.submitData(viewLifecycleOwner.lifecycle, it)

        })

    }

    //
















    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search_bar_menu, menu)


        val search = menu.findItem(R.id.nav_search)
        val searchView = search?.actionView as SearchView
        searchView.queryHint = " Search News"

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                if (query != null) {
                    searching = true
                    binding.rvTopheadlines.scrollToPosition(0)
                    topHeadlinesViewModel.getTopHeadlines(query)
                    searchView.clearFocus()

                }

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(news: NewsData.Articles) {
        val action=TopHeadlinesFragmentDirections.actionNavigationHomeToNewsDetailsFragment(news)
        findNavController().navigate(action)
    }

}