package com.ocean.animation

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import com.ocean.animation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            Handler(Looper.getMainLooper()).postDelayed({
                binding.animeViewConePop.visibility = View.VISIBLE
                binding.animeViewConePop.setAnimation("cone_pop.json")
                binding.animeViewConePop.speed = 1.0F
                binding.animeViewConePop.repeatCount = 5
                binding.animeViewConePop.playAnimation()
            }, 3000)

            Handler(Looper.getMainLooper()).postDelayed({
                binding.animeBlast.visibility = View.VISIBLE
                binding.animeBlast.setAnimation("confetti1.json")
                binding.animeBlast.speed = 1.0F
                binding.animeBlast.repeatCount = 5
                binding.animeBlast.playAnimation()
            },4000)

            binding.animeViewConePop.setOnClickListener {
                binding.animeViewConePop.playAnimation()
//                binding.animeBlast.playAnimation()
            }
        } catch (e : IllegalStateException){
            Log.d("try-catch", "onCreate: ${e.printStackTrace()}")
        }

        /*Handler(Looper.getMainLooper()).postDelayed({
            binding.animeViewConePop.visibility = View.VISIBLE
            binding.animeViewConePop.playAnimation()
        }, 3000)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.animeBlast.visibility = View.VISIBLE
            binding.animeBlast.playAnimation()
        },4000)

        binding.animeViewConePop.setOnClickListener {
            binding.animeViewConePop.playAnimation()
            binding.animeBlast.playAnimation()
        }*/



        binding.animeViewConePop.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {

            }

            override fun onAnimationEnd(animation: Animator) {
                Log.d("TAG", "onAnimation End")
            }

            override fun onAnimationCancel(animation: Animator) {

            }

            override fun onAnimationRepeat(animation: Animator) {

            }

        })
    }
}