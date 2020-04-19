package com.example.mvvmonebutton

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyViewModel : ViewModel() {

    val myText: MutableLiveData<String> = MutableLiveData()

    fun onBtnClicked() {
        //viewModelScope has the same lifecycle with viewmodel
        viewModelScope.launch {
            waitForMe(5)
        }
    }

    private suspend fun showSomeText(sec : Int) {
        myText.postValue("$sec seconds after Button is clicked")
    }

    //IO, Default difference？
    private suspend fun waitForMe(sec: Int) = withContext(Dispatchers.IO) {
        for( i in 1..sec){
            delay(i * 1000L)
            showSomeText(i)
        }

    }
}