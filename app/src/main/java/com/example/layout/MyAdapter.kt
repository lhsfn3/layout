package com.example.layout

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.layout.databinding.RecyclerviewItemBinding

class MyAdapter(val wirterList : Array<String>, val postList : Array<String>)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // 생성된 뷰 홀더에 값 지정
    class MyViewHolder(val binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(writer: String, post: String) {
            // 뷰 홀더의 제목과 설명
            binding.writerText.text = writer
            binding.postText.text = post

            // 뷰 홀더 클릭시 디테일뷰로
            binding.cardView.setOnClickListener {
                val intent: Intent = Intent(it.context, DetailViewActivity::class.java)
                intent.putExtra("currentWriter", writer)
                intent.putExtra("currentPost", post)
                it.context.startActivity(intent)
            }
        }
    }

    // 어떤 xml 으로 뷰 홀더를 생성할지 지정
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    // 뷰 홀더에 데이터 바인딩
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(wirterList[position],postList[position])
    }

    // 뷰 홀더의 개수 리턴
    override fun getItemCount(): Int {
        return wirterList.size
    }
}