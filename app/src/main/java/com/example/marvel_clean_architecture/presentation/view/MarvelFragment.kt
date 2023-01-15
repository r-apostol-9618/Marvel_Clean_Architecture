package com.example.marvel_clean_architecture.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.marvel_clean_architecture.databinding.FragmentMarvelBinding
import com.example.marvel_clean_architecture.presentation.view.adapter.ItemAdapter
import com.example.marvel_clean_architecture.presentation.viewModel.MarvelViewModel

class MarvelFragment : Fragment() {

    private val viewModel: MarvelViewModel by viewModels()
    private lateinit var viewBinding: FragmentMarvelBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewBinding = FragmentMarvelBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.launchApi()

        viewModel.marvelCharactersList.observe(viewLifecycleOwner) {
            viewBinding.recyclerView.adapter = ItemAdapter(requireContext(), it)
        }

        viewModel.dataLoading.observe(viewLifecycleOwner) {
            viewBinding.progressCircular.visibility = if (it) VISIBLE else GONE
        }

        viewModel.errorCase.observe(viewLifecycleOwner) {
            viewBinding.errorText.visibility = if (it) VISIBLE else GONE
        }
    }

}