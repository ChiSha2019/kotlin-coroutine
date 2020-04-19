package com.example.mvvmonebutton

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmonebutton.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        //get viewModel
        val viewmodel:MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        //Bind viewmodel
        binding.viewmodel = viewmodel
        binding.lifecycleOwner = this

    }
}
