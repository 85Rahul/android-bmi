package com.example.new_bmi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.new_bmi.ViewModel.MainActivityViewModel
import com.example.new_bmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewmodel: MainActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewmodel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewmodel.result.observe(this, Observer {
            binding.tvDisplay.text = it.toString()

            viewmodel.print.observe(this, Observer {
                binding.tvHealth.text=it
            })

        })



        binding.btnCalculate.setOnClickListener {
            viewmodel.BmiCalculate(
                binding.editHeight.text.toString().toInt(),
                binding.editWeight.text.toString().toInt()
            )
        }



    }
}