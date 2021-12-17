package com.example.final_photographer_matching.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebookfrenzy.carddemo.HomeKindAdapter
import com.ebookfrenzy.carddemo.HomeNewAdapter
import com.ebookfrenzy.carddemo.HomeRecommendAdapter
import com.example.final_photographer_matching.R
import com.example.final_photographer_matching.databinding.FragmentHomeBinding
import com.example.final_photographer_matching.utils.BottomDialogShow
import com.example.final_photographer_matching.view.activity.MainActivity
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

    val tmp = HomeKindAdapter()

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

        binding.homeToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.home_menu_notification -> {
                    val navController = findNavController()
                    navController.navigate(R.id.navigation_notification)
                    true
                }
                R.id.home_menu_chat -> {
                    val navController = findNavController()
                    navController.navigate(R.id.navigation_chat)
                    true
                }

                else -> false
            }
        }


        val homeRecommendRecyclerView = binding.homeRv2
        val homeKindRecyclerView = binding.homeRv3
        val homeNewRecyclerView = binding.homeRv4

        tmp.setItemClickListener(object: HomeKindAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                val fragmentManager: FragmentManager = lazyActivity.supportFragmentManager
                BottomDialogShow.homeContentDialogFragmentShow(fragmentManager)
            }
        })


        homeRecommendRecyclerView.also {
            it.layoutManager = object : LinearLayoutManager(lazyActivity, HORIZONTAL, false){
                override fun canScrollVertically(): Boolean {
                    return false
                }
            }
            it.adapter = HomeRecommendAdapter()
        }

        homeKindRecyclerView.also {
            it.layoutManager = object : LinearLayoutManager(lazyActivity, HORIZONTAL, false){
                override fun canScrollVertically(): Boolean {
                    return false
                }
            }
            it.adapter = tmp


        }

        homeNewRecyclerView.also {
            it.layoutManager = object : LinearLayoutManager(lazyActivity, HORIZONTAL, false){
                override fun canScrollVertically(): Boolean {
                    return false
                }
            }
            it.adapter = HomeNewAdapter()
        }

        binding.homeToolbar.inflateMenu(R.menu.home_toolbar_menu)


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}