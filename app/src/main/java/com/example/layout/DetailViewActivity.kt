package com.example.layout

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.layout.databinding.ActivityDetailViewBinding

class DetailViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailViewBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        // 뷰 바인딩
        binding = ActivityDetailViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()

    binding.Button.setOnClickListener{
        var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com"))
        startActivity(intent)
    }
    }




    // 클릭된 뷰에 관한 데이터를 보여줌
    fun getData(){
        if(intent.hasExtra("currentWriter") && intent.hasExtra("currentPost")){
            binding.textView.text = intent.getStringExtra("currentWriter")
            binding.textView2.text = intent.getStringExtra("currentPost")
        }
        else{
            Toast.makeText(this,"불러오기 실패",Toast.LENGTH_SHORT).show()
        }
    }

}