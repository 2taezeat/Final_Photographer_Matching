package com.ebookfrenzy.carddemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.final_photographer_matching.R
import com.example.final_photographer_matching.databinding.HomeRecommendCardviewBinding

class HomeRecommendAdapter() : RecyclerView.Adapter<HomeRecommendAdapter.CustomViewHolder>() {
    inner class CustomViewHolder(val homeRecommendCardviewBinding: HomeRecommendCardviewBinding)
        : RecyclerView.ViewHolder(homeRecommendCardviewBinding.root)

    private val nicknames = arrayOf("열쩡사진사",
        "룸 하이디", "KU_grapher", "호랑이 사진관")

    private val locations = arrayOf("서울 양천구", "경기도 남양주",
        "서울 송파구", "서울 성북구")


    private val kinds = arrayOf("스냅샷", "프로필",
        "바디 프로필", "증명사진")


    private val tagOne = arrayOf("#웨딩", "#단체사진",
        "#아마추어", "#취업사진")


    private val tagTwo = arrayOf("#단체사진", "#보정무료",
        "#저렴", "#군인사진")


    private val stars = arrayOf("4.5", "5.0",
        "4.3", "4.2")

    private val images = arrayListOf<Int>(R.drawable.image_1,R.drawable.image_2,R.drawable.image_3,R.drawable.image_4)




    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    // (3) 외부에서 클릭 시 이벤트 설정
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
    // (4) setItemClickListener로 설정한 함수 실행
    private lateinit var itemClickListener : OnItemClickListener



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
        viewHolder.homeRecommendCardviewBinding.homeRecommendNicknameText.text = nicknames[i]
        viewHolder.homeRecommendCardviewBinding.homeCardRecommendLocationText.text = locations[i]
        viewHolder.homeRecommendCardviewBinding.homeCardKindText.text = kinds[i]
        viewHolder.homeRecommendCardviewBinding.homeCardRecommendTag1.text = tagOne[i]
        viewHolder.homeRecommendCardviewBinding.homeCardRecommendTag2.text = tagTwo[i]
        viewHolder.homeRecommendCardviewBinding.homeCardRecommendStarText.text = stars[i]

        viewHolder.homeRecommendCardviewBinding.cardViewCL.setOnClickListener {
            itemClickListener.onClick(it, i)
        }


        viewHolder.homeRecommendCardviewBinding.homeCardRecommendImageview.setImageResource(images[i])

    }

    override fun getItemCount(): Int {
        return nicknames.size
    }
}
