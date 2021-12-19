package com.example.final_photographer_matching.view.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.JavascriptInterface
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.final_photographer_matching.databinding.FragmentSearchBinding
import com.example.final_photographer_matching.utils.BottomDialogShow
import com.example.final_photographer_matching.viewmodels.SearchViewModel

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel
    private var _binding: FragmentSearchBinding? = null
    private val searchURL = "https://photographer-matching.web.app/search"
    private val lazyActivity by lazy {
        requireActivity()
    }


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchViewModel =
            ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root



        binding.searchWebView.apply {
            webViewClient = WebViewClient()
            settings.builtInZoomControls = true
            settings.javaScriptEnabled = true
            settings.cacheMode = WebSettings.LOAD_DEFAULT
        }

        binding.searchWebView.addJavascriptInterface(JSBridge(lazyActivity),"JSBridge")
        binding.searchWebView.loadUrl(searchURL)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



class JSBridge(lazyActivity: FragmentActivity){
    var lazyActivity: FragmentActivity = lazyActivity


    @JavascriptInterface
    fun showMessageInNative(message:String){
        //Received message from webview in native, process data
        Log.d("jsjsjs","${message}")

        val fragmentManager: FragmentManager = lazyActivity.supportFragmentManager
        BottomDialogShow.searchContentDialogFragmentShow(fragmentManager)
    }
}