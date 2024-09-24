package com.example.search_kogpt.presentation.main.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.search_kogpt.databinding.FragmentSearchBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding get() = _binding!!

    private val listAdapter: SearchListAdapter by lazy {
        SearchListAdapter()
    }

    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()

        generateKoGpt()
    }

    private fun initView() = with(binding) {
        rvSearch.adapter = listAdapter
        rvSearch.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun generateKoGpt(){
        binding.btnSearch.setOnClickListener {
            viewModel.generateKoGpt(binding.etSearch.text.toString())
        }
    }

    private fun initViewModel() = with(viewModel) {
        viewLifecycleOwner.lifecycleScope.launch {
            uiState.flowWithLifecycle(lifecycle)
                .collectLatest { uiState ->
                    onBind(uiState)
                }
        }
    }

    private fun onBind(uiState: SearchUiState) = with(binding) {
        when (uiState) {
            is SearchUiState.ErrorUiState -> {}
            is SearchUiState.NormalUiState ->
                listAdapter.submitList(uiState.list)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}