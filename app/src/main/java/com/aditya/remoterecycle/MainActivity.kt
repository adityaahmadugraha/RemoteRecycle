package com.aditya.remoterecycle


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aditya.remoterecycle.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: PhotoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val viewModel = ViewModelProvider(
            this@MainActivity, ViewModelProvider.NewInstanceFactory()
        )[MainViewModel::class.java]


        mAdapter = PhotoAdapter {photo->
           Intent(this@MainActivity, PostActivity::class.java).also {
                it.putExtra("id", photo.id)
                it.putExtra("albumId", photo.albumId)
                it.putExtra("thumbnail", photo.thumbnailUrl)
                it.putExtra("title", photo.title)
                it.putExtra("url", photo.url)
                startActivity(it)
            }
        }

        viewModel.photo.observe(this@MainActivity) { listPhoto ->
            mAdapter.submitList(listPhoto)
            binding.rvPhoto.adapter = mAdapter
            binding.rvPhoto.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvPhoto.setHasFixedSize(true)
        }


        viewModel.isLoading.observe(this@MainActivity) { isLoading ->

            binding.progressBar.isVisible = isLoading
        }
    }
}