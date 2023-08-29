package com.tamatem.tmatemplusproject.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.tamatem.tmatemplusproject.presentation.databinding.FragmentWebBinding


class WebFragment : Fragment() {

    lateinit var binding: FragmentWebBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWebBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initWebView()

    }

    private fun initWebView() {
        @SuppressLint("SetJavaScriptEnabled")
        binding.wvTamatemPlus.settings.javaScriptEnabled = true
        binding.wvTamatemPlus.settings.setSupportZoom(true)
        binding.wvTamatemPlus.settings.builtInZoomControls = true
        binding.wvTamatemPlus.settings.displayZoomControls = false
        binding.wvTamatemPlus.settings.domStorageEnabled = true
        binding.wvTamatemPlus.webViewClient = WebViewClient()
        binding.wvTamatemPlus.webChromeClient = WebChromeClient()

        binding.wvTamatemPlus.loadUrl("https://tamatemplus.com/home")
    }


}