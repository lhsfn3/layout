package com.example.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.layout.databinding.ActivityMainBinding


class       MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var writerList : Array<String>
    lateinit var postList : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)

        writerList = resources.getStringArray(R.array.item_writer)
        postList = resources.getStringArray(R.array.item_post)

        binding.articleList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)

        binding.articleList.adapter = MyAdapter(writerList,postList)

        binding.projectName.text = "가구"

        setContentView(R.layout.activity_main)
        Glide.with(this)
            .load("https://mblogthumb-phinf.pstatic.net/MjAxODA1MjlfMjM2/MDAxNTI3NjA1MTY2MTUz.2RBJVPFj9InyO97Nh4-y4ClSPPrM2sZESvV3P1QlyUIg.41KpujeoTOyGAsXiTEa8K4w5zChKfoVvATDwDimJUBgg.JPEG.rightbrainer/%25EC%259D%25B8%25EB%25AC%25BC%25EC%2582%25AC%25EC%25A7%2584_%25EC%259E%2598_%25EC%25B0%258D%25EB%258A%2594%25EB%25B2%2595_2.jpg?type=o_webp")
            .apply(RequestOptions.bitmapTransform(RoundedCorners(50)))
            .into(findViewById(R.id.iv_image))


    }
}