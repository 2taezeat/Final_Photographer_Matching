package com.ebookfrenzy.carddemo

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.final_photographer_matching.R
import com.example.final_photographer_matching.databinding.HomeNewCardviewBinding
import com.example.final_photographer_matching.databinding.HomeRecommendCardviewBinding

class HomeNewAdapter() : RecyclerView.Adapter<HomeNewAdapter.CustomViewHolder>() {
    inner class CustomViewHolder(val homeNewCardviewBinding: HomeNewCardviewBinding)
        : RecyclerView.ViewHolder(homeNewCardviewBinding.root)

    private val nicknames = arrayOf("great사진사",
        "Dear 사진관", "Apple_Photo", "독수리 사진관")

    private val locations = arrayOf("서울 봉천구", "서울 성북구",
        "서울 강남구", "서울 서초구")


    private val kinds = arrayOf("스냅샷", "프로필",
        "바디 프로필", "증명사진")


    private val tagOne = arrayOf("#졸업", "#베테랑",
        "#가족사진", "#청순")


    private val tagTwo = arrayOf("#우정사진", "#커플",
        "#야외", "#군인사진")

    private val stars = arrayOf("4.0", "4.5",
        "4.1", "4.3")


    private val images = arrayListOf<Int>(R.drawable.image_5,R.drawable.image_6,R.drawable.image_7,R.drawable.image_8)





    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): HomeNewAdapter.CustomViewHolder {
        val bind = DataBindingUtil.inflate<HomeNewCardviewBinding>(
            LayoutInflater.from(viewGroup.context),
            R.layout.home_new_cardview,
            viewGroup,
            false
        )
        return CustomViewHolder(bind)
    }

    override fun onBindViewHolder(viewHolder: CustomViewHolder, i: Int) {
        viewHolder.homeNewCardviewBinding.homeCardNewNicknameText.text = nicknames[i]
        viewHolder.homeNewCardviewBinding.homeCardNewLocationText.text = locations[i]
        viewHolder.homeNewCardviewBinding.homeCardNewKindText.text = kinds[i]
        viewHolder.homeNewCardviewBinding.homeCardNewTag1.text = tagOne[i]
        viewHolder.homeNewCardviewBinding.homeCardNewTag2.text = tagTwo[i]
        viewHolder.homeNewCardviewBinding.homeCardNewStarText.text = stars[i]


        viewHolder.homeNewCardviewBinding.homeCardNewImageview.setImageResource(images[i])




    }

    override fun getItemCount(): Int {
        return nicknames.size
    }
}
