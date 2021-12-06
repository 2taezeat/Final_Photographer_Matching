package com.example.final_photographer_matching.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebookfrenzy.carddemo.HomeRecommendAdapter
import com.example.final_photographer_matching.databinding.FragmentHomeBinding
import com.example.final_photographer_matching.viewmodels.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val lazyActivity by lazy {
        requireActivity()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })


        val homeRecommendRecyclerview = binding.homeRv2
        //homeRecommendRecyclerview.layoutManager = LinearLayoutManager(lazyActivity)
        //homeRecommendRecyclerview.adapter = HomeRecommendAdapter()

        homeRecommendRecyclerview.also {
            it.layoutManager = object : LinearLayoutManager(lazyActivity, HORIZONTAL, false){
                override fun canScrollVertically(): Boolean {
                    return false
                }
            }
            it.adapter = HomeRecommendAdapter()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}