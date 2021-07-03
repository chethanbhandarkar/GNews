package com.chethanbhandarkar.gnews.ui.topheadlines

import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.chethanbhandarkar.gnews.R
import com.chethanbhandarkar.gnews.data.repository.NewsData
import com.chethanbhandarkar.gnews.databinding.FragmentTopheadlinesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopHeadlinesFragment : Fragment() ,NewsPagingAdapter.OnItemClickListener{

    private  val topHeadlinesViewModel by viewModels<TopHeadlinesViewModel>()

    private var _binding: FragmentTopheadlinesBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentTopheadlinesBinding.inflate(inflater, container, false)

        val toolbar: androidx.appcompat.widget.Toolbar=binding.toolBar
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        val root: View = binding.root
        return root
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
        val adapter=NewsPagingAdapter(this)

        binding.apply {
            rvTopheadlines.setHasFixedSize(true)
            rvTopheadlines.adapter=adapter.withLoadStateHeaderAndFooter(

                header = LoadingStateAdapter{
                    adapter.retry()
                },
                footer = LoadingStateAdapter{
                    adapter.retry()
                },
            )

        }
        topHeadlinesViewModel.news.observe(viewLifecycleOwner, Observer {
          adapter.submitData(viewLifecycleOwner.lifecycle,it)

        })

    }

    override fun onItemClick(news: NewsData.Articles) {
        val action=TopHeadlinesFragmentDirections.actionNavigationHomeToNewsDetailsFragment(news)
        findNavController().navigate(action)

    }
    override fun onCreateOptionsMenu(menu: Menu,inflater:MenuInflater) {
        super.onCreateOptionsMenu(menu,inflater)
        inflater.inflate(R.menu.search_bar_menu,menu)



        val search=menu.findItem(R.id.nav_search)
        val searchView=search?.actionView as SearchView
        searchView.queryHint=" Search News"

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                if(query!=null)
                {   binding.rvTopheadlines.scrollToPosition(0)
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


}