package com.ebookfrenzy.carddemo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.final_photographer_matching.R
import com.example.final_photographer_matching.databinding.HomeKindCardviewBinding
import com.example.final_photographer_matching.databinding.HomeNewCardviewBinding
import com.example.final_photographer_matching.databinding.HomeRecommendCardviewBinding
import com.example.final_photographer_matching.utils.BottomDialogShow
import com.example.final_photographer_matching.view.activity.MainActivity

class HomeKindAdapter() : RecyclerView.Adapter<HomeKindAdapter.CustomViewHolder>() {
    inner class CustomViewHolder(val homeKindCardviewBinding: HomeKindCardviewBinding)
        : RecyclerView.ViewHolder(homeKindCardviewBinding.root)

    override fun onBindViewHolder(viewHolder: CustomViewHolder, i: Int) {
        //viewHolder.dashboardEditCardviewBinding.dashboardEdittextEditingKind.text = titles[i]
        //viewHolder.homeCardviewBinding.dashboardEdittextEditingKind.setText(titles[i])
        //viewHolder.notificationsCardviewBinding.itemImage.setImageResource(images[i])

        viewHolder.homeKindCardviewBinding.cardViewCL.setOnClickListener {
            itemClickListener.onClick(it, i)
        }


    }

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    // (3) 외부에서 클릭 시 이벤트 설정
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
    // (4) setItemClickListener로 설정한 함수 실행
    private lateinit var itemClickListener : OnItemClickListener

    private val titles = arrayOf("Chapter One",
        "Chapter Two", "Chapter Three", "Chapter Four",
        "Chapter Five", "Chapter Six", "Chapter Seven",
        "Chapter Eight")

    private val details = arrayOf("Item one details", "Item two details",
        "Item three details", "Item four details",
        "Item five details", "Item six details",
        "Item seven details", "Item eight details")

    private val images = intArrayOf(1,2,3,4,5,6,7,8)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): HomeKindAdapter.CustomViewHolder {
        val bind = DataBindingUtil.inflate<HomeKindCardviewBinding>(
            LayoutInflater.from(viewGroup.context),
            R.layout.home_kind_cardview,
            viewGroup,
            false
        )
        return CustomViewHolder(bind)
    }


    override fun getItemCount(): Int {
        return titles.size
    }
}
