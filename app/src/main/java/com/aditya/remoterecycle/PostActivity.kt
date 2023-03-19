package com.aditya.remoterecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aditya.remoterecycle.databinding.ActivityPostBinding
import com.bumptech.glide.Glide

class PostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPostBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val albumId = intent.getStringExtra("albumId").toString()
        val id = intent.getStringExtra("id").toString()
        val thumbnail = intent.getStringExtra("thumbnail").toString()
        val url = intent.getStringExtra("url").toString()
        val title = intent.getStringExtra("title").toString()


        val imgPost = binding.imgPost
        Glide.with(this)
            .load(thumbnail)
            .into(imgPost);



        binding.btnPost.setOnClickListener {
            val intent = Intent(this@PostActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }


}