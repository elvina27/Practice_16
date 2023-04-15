package com.example.practice_16

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataModel : ViewModel() {
    val messageForCompFragment: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val messageFromCompFragment: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val messageFromCompFragmentTrue: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val messageFromUserFragmentTrue: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}
