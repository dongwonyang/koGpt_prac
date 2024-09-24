package com.example.search_kogpt.presentation.main.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.search_kogpt.databinding.ItemKogptanswerBinding
import com.example.search_kogpt.databinding.ItemPromptBinding
import com.example.search_kogpt.databinding.ItemUnknownBinding

class SearchListAdapter(
) : ListAdapter<SearchListItem, SearchListAdapter.ViewHolder>(
    SearchDiffUtil()
) {
    abstract class ViewHolder(root: View) : RecyclerView.ViewHolder(root) {
        abstract fun onBind(text: String)
    }

    enum class ViewType {
        PROMPT, ANSWER
    }

    class PromptViewHolder(
        private val binding: ItemPromptBinding
    ) : ViewHolder(binding.root) {
        override fun onBind(text: String) {
            binding.tvPromptAnswer.text = text
        }
    }

    class KoGptViewHolder(
        private val binding: ItemKogptanswerBinding
    ) : ViewHolder(binding.root) {
        override fun onBind(text: String) {
            binding.tvKoGptAnswerAnswer.text = text
        }

    }

    class UnknownViewHolder(
        binding: ItemUnknownBinding
    ) : ViewHolder(binding.root) {
        override fun onBind(text: String) {
        }

    }

    override fun getItemViewType(position: Int) = when (getItem(position).type) {
        SearchType.PROMPT -> ViewType.PROMPT.ordinal
        SearchType.ANSWER -> ViewType.ANSWER.ordinal
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder = when (viewType) {
        ViewType.PROMPT.ordinal -> PromptViewHolder(
            ItemPromptBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

        ViewType.ANSWER.ordinal -> KoGptViewHolder(
            ItemKogptanswerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

        else -> UnknownViewHolder(
            ItemUnknownBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SearchListAdapter.ViewHolder, position: Int) {
        holder.onBind(getItem(position).text)
    }
}

class SearchDiffUtil : DiffUtil.ItemCallback<SearchListItem>() {
    override fun areItemsTheSame(oldItem: SearchListItem, newItem: SearchListItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: SearchListItem, newItem: SearchListItem): Boolean {
        return oldItem == newItem
    }
}
