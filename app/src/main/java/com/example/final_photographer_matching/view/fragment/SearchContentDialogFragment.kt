package com.example.final_photographer_matching.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.final_photographer_matching.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SearchContentDialogFragment : BottomSheetDialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{

        val view = inflater.inflate(R.layout.fragment_search_content_dialog, container, false)

        val chatButton = view.findViewById<Button>(R.id.search_content_chatting_button)

        chatButton.setOnClickListener{
            dismiss()
            val navController = findNavController()
            navController.navigate(R.id.navigation_chat)
        }

        return view
    }

    override fun getTheme(): Int = R.style.CustomBottomSheetDialog


}