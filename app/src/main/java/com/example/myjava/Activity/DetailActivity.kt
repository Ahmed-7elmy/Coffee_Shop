package com.example.myjava.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.IntegerRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.myjava.Domain.ItemsModel
import com.example.myjava.Helper.ManagmentCart
import com.example.myjava.R
import com.example.myjava.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    private lateinit var item: ItemsModel
    private lateinit var managmentCart: ManagmentCart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        managmentCart = ManagmentCart(this)
        bundle()
        initSizeList()

    }

    private fun initSizeList() {
        binding.apply {
            smallBtn.setOnClickListener {
                smallBtn.setBackgroundResource(R.drawable.stroke_brown_bg)
                mediumBtn.setBackgroundResource(0)
                largeBtn.setBackgroundResource(0)
            }
            mediumBtn.setOnClickListener {
                mediumBtn.setBackgroundResource(R.drawable.stroke_brown_bg)
                smallBtn.setBackgroundResource(0)
                largeBtn.setBackgroundResource(0)
            }
            largeBtn.setOnClickListener {
                largeBtn.setBackgroundResource(R.drawable.stroke_brown_bg)
                mediumBtn.setBackgroundResource(0)
                smallBtn.setBackgroundResource(0)
            }
        }

    }

    private fun bundle() {
        binding.apply {
            item = intent.getSerializableExtra("object") as ItemsModel
            Glide.with(this@DetailActivity).load(item.picUrl[0]).into(binding.picMain)
            titleTxt.text = item.title
            descriptionTxt.text = item.description
            priceTxt.text = "$" + item.price.toString()
            ratingTxt.text = item.rating.toString()
            addToCartBtn.setOnClickListener {
                Toast.makeText(this@DetailActivity, "Added to cart", Toast.LENGTH_SHORT).show()
                item.numberInCart = Integer.valueOf(binding.numberitemTxt.text.toString())
                managmentCart.insertItems(item)

            }


            backText.setOnClickListener {//BackBtn also
                startActivity(Intent(this@DetailActivity, MainActivity::class.java))
            }


            backBtn.setOnClickListener {
                startActivity(Intent(this@DetailActivity, MainActivity::class.java))
            }
            plusCart.setOnClickListener {
//                var number: Int = Integer.valueOf(numberitemTxt.text.toString())
//                number++
//                numberitemTxt.text = number.toString()
                numberitemTxt.text = (item.numberInCart + 1).toString()
                item.numberInCart++//dy lazem tt7t
                priceTxt.text = "$" + (item.price * item.numberInCart).toString()


            }
            minusBtn.setOnClickListener {

                if (item.numberInCart > 0) {
                    numberitemTxt.text = (item.numberInCart - 1).toString()
                    item.numberInCart--
                    priceTxt.text = "$" + (item.price * item.numberInCart).toString()
                }
            }


        }
    }
}
