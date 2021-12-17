package com.example.final_photographer_matching.view.fragment

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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.final_photographer_matching.databinding.FragmentSearchBinding
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

        //binding.searchWebView.addJavascriptInterface(WebAppInterface(lazyActivity), "BlackJin")
        binding.searchWebView.addJavascriptInterface(JSBridge(),"JSBridge")

        binding.searchWebView.loadUrl(searchURL)

//        binding.searchWebView.addJavascriptInterface(new Object() {
//            @JavascriptInterface
//            fun justDoIt(keyword : String) {
//                Toast.makeText(lazyActivity, "Keyword is " + keyword, Toast.LENGTH_LONG).show();
//            }
//        }, "Zeany");
//
//        binding.webviewCl.setOnClickListener {
//            Log.d("qwe","qwe")
//        }



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class WebAppInterface(private val mContext: Context) {

    /** Show a toast from the web page  */
    @JavascriptInterface
    fun showToast(toast: String) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
    }
}

class JSBridge(){
    @JavascriptInterface
    fun showMessageInNative(message:String){
        //Received message from webview in native, process data
        Log.d("jsjsjs","${message}")
    }
}