package com.tamatem.tmatemplusproject.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tamatem.tmatemplusproject.presentation.R
import com.tamatem.tmatemplusproject.presentation.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClickListeners()
    }

    private fun onClickListeners() {
        binding.btnOpenWebView.setOnClickListener { openWebView() }
    }

    private fun openWebView() {
        findNavController().navigate(R.id.action_startFragment_to_webFragment)
    }
}