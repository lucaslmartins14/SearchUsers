package com.example.searchusers.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.searchusers.model.ResultUser
import com.example.searchusers.model.UserService

class MyViewModel : ViewModel() {

    val resultUser: MutableLiveData<ResultUser> = MutableLiveData()

    fun searchUserByName(name: String){
        resultUser.value = UserService().searchByName(name)
    }
}