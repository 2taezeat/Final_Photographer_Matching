package com.ebookfrenzy.carddemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.final_photographer_matching.R
import com.example.final_photographer_matching.databinding.HomeRecommendCardviewBinding

class HomeRecommendAdapter() : RecyclerView.Adapter<HomeRecommendAdapter.CustomViewHolder>() {
    inner class CustomViewHolder(val homeRecommendCardviewBinding: HomeRecommendCardviewBinding)
        : RecyclerView.ViewHolder(homeRecommendCardviewBinding.root)

    private val titles = arrayOf("Chapter One",
        "Chapter Two", "Chapter Three", "Chapter Four",
        "Chapter Five", "Chapter Six", "Chapter Seven",
        "Chapter Eight")

    private val details = arrayOf("Item one details", "Item two details",
        "Item three details", "Item four details",
        "Item five details", "Item six details",
        "Item seven details", "Item eight details")

    private val images = intArrayOf(1,2,3,4,5,6,7,8)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): HomeRecommendAdapter.CustomViewHolder {
        val bind = DataBindingUtil.inflate<HomeRecommendCardviewBinding>(
            LayoutInflater.from(viewGroup.context),
            R.layout.home_recommend_cardview,
            viewGroup,
            false
        )
        return CustomViewHolder(bind)
    }

    override fun onBindViewHolder(viewHolder: CustomViewHolder, i: Int) {
        //viewHolder.dashboardEditCardviewBinding.dashboardEdittextEditingKind.text = titles[i]
        //viewHolder.homeCardviewBinding.dashboardEdittextEditingKind.setText(titles[i])
        //viewHolder.notificationsCardviewBinding.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}
