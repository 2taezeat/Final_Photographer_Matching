package com.example.final_photographer_matching.utils

import androidx.fragment.app.FragmentManager
import com.example.final_photographer_matching.view.fragment.HomeContentDialogFragment
import com.example.final_photographer_matching.view.fragment.ProfileEditDialogFragment
import com.example.final_photographer_matching.view.fragment.SearchContentDialogFragment


class BottomDialogShow{
    companion object {
        private val profileEditDialogFragment = ProfileEditDialogFragment()
        fun profileEditDialogFragmentShow(fragmentManager: FragmentManager) {
            profileEditDialogFragment.show(fragmentManager, profileEditDialogFragment.tag)
        }

        private val homeContentDialogFragment = HomeContentDialogFragment()
        fun homeContentDialogFragmentShow(fragmentManager: FragmentManager) {
            homeContentDialogFragment.show(fragmentManager, homeContentDialogFragment.tag)
        }

        private val searchContentDialogFragment = SearchContentDialogFragment()
        fun searchContentDialogFragmentShow(fragmentManager: FragmentManager) {
            searchContentDialogFragment.show(fragmentManager, searchContentDialogFragment.tag)
        }

    }
}