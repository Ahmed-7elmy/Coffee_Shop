package com.example.myjava.Activity

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.myjava.Adapter.CategoryAdapter
import com.example.myjava.Adapter.PopularAdapter
import com.example.myjava.ViewModel.MainViewModel
import com.example.myjava.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel= MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBanner()
        initCategory()
        initPopular()

    }
    private fun initBanner() {
        binding.progressBarBanner.visibility= View.VISIBLE
        viewModel.loadBanner().observe(this@MainActivity) {//observeforever
            Glide.with(this@MainActivity).load(it[0].url).into(binding.banner)
            binding.progressBarBanner.visibility= View.GONE

        }
        viewModel.loadBanner()

    }
    private fun initCategory() {
        binding.progressBarCategory.visibility= View.VISIBLE
        viewModel.loadCategory().observeForever {
            binding.recyclerViewCat.layoutManager= LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            binding.recyclerViewCat.adapter= CategoryAdapter(it)
            binding.progressBarCategory.visibility= View.GONE
        }
        viewModel.loadCategory()

    }
    private fun initPopular() {
        binding.progressBarPopular.visibility= View.VISIBLE
        viewModel.loadPopular().observeForever {
            binding.recyclerViewPopular.layoutManager= GridLayoutManager(
                this@MainActivity,
                2
            )
            binding.recyclerViewPopular.adapter= PopularAdapter(it)
            binding.progressBarPopular.visibility= View.GONE

        }
        viewModel.loadPopular()
    }

}
