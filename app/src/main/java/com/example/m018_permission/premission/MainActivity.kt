package com.example.m018_permission.premission

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.m018_permission.R
import com.example.m018_permission.databinding.ActivityMainBinding
import com.example.m018_permission.databinding.FragmentMainBinding

class MainActivity : AppCompatActivity() {

        private  var _binding: ActivityMainBinding? = null
        private  val binding get() = _binding!!

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            _binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
        }

}