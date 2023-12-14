package com.example.kotiln_1205_crud

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.kotiln_1205_crud.databinding.ActivityMainBinding

class  MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val TAG:String = "Log"
        val actionBar = supportActionBar
        if (actionBar != null) {
            setupActionBarWithNavController(findNavController(R.id.fragment))
            Log.d(TAG,"실행중")
        } else {
            // ActionBar가 null일 경우 대처 방법을 여기에 추가
            Log.d(TAG,"오류")

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}