package com.lsakee.feature

import android.os.Bundle
import androidx.activity.viewModels
import com.lsakee.core_ui.base.BindingActivity
import com.lsakee.feature.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel by viewModels<MenuViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.tvName.setOnClickListener {

            viewModel.getTag()
        }

    }


}