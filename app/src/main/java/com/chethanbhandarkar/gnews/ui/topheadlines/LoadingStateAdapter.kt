package com.chethanbhandarkar.gnews.ui.topheadlines

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chethanbhandarkar.gnews.databinding.ErrorStateBinding
import com.chethanbhandarkar.gnews.ui.topheadlines.LoadingStateAdapter.LoadingViewHolder

class LoadingStateAdapter
    constructor(private val retry:()->Unit)

    : LoadStateAdapter<LoadingViewHolder>() {



    inner class LoadingViewHolder(private val binding: ErrorStateBinding,retry: () -> Unit):RecyclerView.ViewHolder(binding.root)
    {
        init{

            binding.btnRetry.setOnClickListener {
                retry.invoke()

            }


        }

        fun bind(loadState: LoadState){
            binding.apply {
                progressBar.isVisible=loadState is LoadState.Loading
                btnRetry.isVisible=loadState !is LoadState.Loading
                tvError.isVisible=loadState !is LoadState.Loading


            }
        }



    }

    override fun onBindViewHolder(holder: LoadingViewHolder, loadState: LoadState) {
       holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadingViewHolder {
      return LoadingViewHolder(ErrorStateBinding.inflate(LayoutInflater.from(parent.context),parent,false),retry)
    }
}