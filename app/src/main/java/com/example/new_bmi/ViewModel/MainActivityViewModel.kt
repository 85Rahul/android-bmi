package com.example.new_bmi.ViewModel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {

    var result: MutableLiveData<Float> = MutableLiveData()
    var print:MutableLiveData<String> = MutableLiveData()


    fun BmiCalculate( height1:Int, weight1:Int){
        val heightInCM = height1.toFloat()
        val weightINKG = weight1.toFloat()

        val heightmeter = heightInCM / 100
        val heightmetersquare = heightmeter * heightmeter
         result.value = weightINKG / heightmetersquare

        if (result.value!! < 18.5) {
         print.value = "underweight"
        } else if (result.value!! >= 18.5 && result.value!! < 25) {
            print.value = "healthy"
        } else if (result.value!! >= 25 && result.value!! < 30) {
            print.value = "overweight"
        } else {
            print.value = "Obese"
        }
    }

}