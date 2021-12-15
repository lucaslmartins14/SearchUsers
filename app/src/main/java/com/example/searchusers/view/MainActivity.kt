package com.example.searchusers.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.searchusers.R
import com.example.searchusers.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewmodel: MyViewModel = ViewModelProvider(this)[MyViewModel::class.java]

        viewmodel.resultUser.observe(this){
            if (it.success){
                textViewName.text = it.user?.name
                textViewAge.text = it.user?.age
                textViewGender.text = it.user?.gender
            } else {
                textViewName.text = "no user found"
                textViewAge.text = ""
                textViewGender.text = ""
            }
        }

        buttonSearch.setOnClickListener {
            viewmodel.searchUserByName(editTextName.text.toString())
        }
    }
}