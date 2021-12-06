package com.example.final_photographer_matching.utils

import androidx.fragment.app.FragmentManager
import com.example.final_photographer_matching.view.fragment.ProfileEditDialogFragment


class BottomDialogShow{
    companion object {
        private val refrigeratorBottomSheet = ProfileEditDialogFragment()
        fun refrigeratorBottomDialogFragmentShow(fragmentManager: FragmentManager) {
            refrigeratorBottomSheet.show(fragmentManager, refrigeratorBottomSheet.tag)
        }
    }
}