package com.example.final_photographer_matching.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.final_photographer_matching.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class HomeContentDialogFragment : BottomSheetDialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home_content_dialog, container, false)

    override fun getTheme(): Int = R.style.CustomBottomSheetDialog


}