package com.example.final_photographer_matching.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.final_photographer_matching.R
import com.example.final_photographer_matching.databinding.FragmentMypageBinding
import com.example.final_photographer_matching.utils.BottomDialogShow
import com.example.final_photographer_matching.utils.FragmentShowHide
import com.example.final_photographer_matching.viewmodels.MyPageViewModel


class MyPageFragment : Fragment() {

    private lateinit var notificationsViewModel: MyPageViewModel
    private var _binding: FragmentMypageBinding? = null


    private val binding get() = _binding!!
    private val lazyActivity by lazy {
        requireActivity()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(MyPageViewModel::class.java)


        _binding = FragmentMypageBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.mypageToolbar.inflateMenu(R.menu.mypage_toolbar_menu)


        binding.profileRegisterButton.setOnClickListener{
            val fragmentManager: FragmentManager = lazyActivity.supportFragmentManager
            BottomDialogShow.profileEditDialogFragmentShow(fragmentManager)
        }


        binding.mypageToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.mypage_notification -> {
                    val navController = findNavController()
                    navController.navigate(R.id.navigation_notification)
                    true
                }

                else -> false
            }
        }



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}