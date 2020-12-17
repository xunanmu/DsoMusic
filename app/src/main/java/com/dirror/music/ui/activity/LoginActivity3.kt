package com.dirror.music.ui.activity

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.dirror.music.MyApplication
import com.dirror.music.databinding.ActivityLogin3Binding
import com.dirror.music.util.getStatusBarHeight

class LoginActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityLogin3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initListener()
    }

    private fun initView() {
        (binding.btnCancel.layoutParams as ConstraintLayout.LayoutParams).apply {
            topMargin = getStatusBarHeight(window, this@LoginActivity3)
        }

        binding.lottieBackground.repeatCount = -1
        binding.lottieBackground.playAnimation()
        binding.lottieBackground.speed = 1f

        val typeface = Typeface.createFromAsset(assets, "fonts/Moriafly-Regular.ttf")
        binding.tvLogo.typeface = typeface
        binding.tvVersion.typeface = typeface
    }

    private fun initListener() {
        binding.apply{
            // 取消
            btnCancel.setOnClickListener { finish() }
            // 手机号登录
            btnLoginByPhone.setOnClickListener {
                MyApplication.activityManager.startLoginByPhoneActivity(this@LoginActivity3)
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.lottieBackground.cancelAnimation()
    }

}