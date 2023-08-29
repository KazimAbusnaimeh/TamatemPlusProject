package com.tamatem.tmatemplusproject.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.tamatem.tmatemplusproject.presentation.R
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
        onClickListeners()
        handleBackStack()

    }

    private fun initWebView() {
        binding.wvTamatemPlus.apply {
            @SuppressLint("SetJavaScriptEnabled")
            settings.javaScriptEnabled = true
            settings.setSupportZoom(true)
            settings.builtInZoomControls = true
            settings.displayZoomControls = false
            settings.domStorageEnabled = true
            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()
            loadUrl("https://tamatemplus.com/home")
        }
    }


    private fun onClickListeners() {
        binding.toolBar.ivBack.setOnClickListener { webViewGoBack() }
        binding.toolBar.ivForward.setOnClickListener { webViewGoForward() }
        binding.toolBar.ivReload.setOnClickListener { webViewReload() }
        binding.toolBar.ivClose.setOnClickListener { webViewClose() }
    }

    fun webViewGoBack() {
        if (binding.wvTamatemPlus.canGoBack())
            binding.wvTamatemPlus.goBack()
    }

    private fun webViewGoForward() {
        if (binding.wvTamatemPlus.canGoForward())
            binding.wvTamatemPlus.goForward()
    }

    private fun webViewReload() {
        binding.wvTamatemPlus.reload()
    }

    private fun webViewClose() {
        findNavController().navigate(R.id.action_webFragment_to_startFragment)
    }

    fun handleBackStack() {
        binding.wvTamatemPlus.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN)
                if (keyCode == KeyEvent.KEYCODE_BACK)
                    if (binding.wvTamatemPlus != null)
                        if (binding.wvTamatemPlus.canGoBack())
                            binding.wvTamatemPlus.goBack()
                        else
                            findNavController().navigate(R.id.action_webFragment_to_startFragment)

            true
        }
    }


}