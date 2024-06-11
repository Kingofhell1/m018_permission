package com.example.m018_permission.premission

import android.content.Context
import com.example.m018_permission.data.Repository
import androidx.lifecycle.LiveData
import com.example.m018_permission.data.Photo
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel(val context: Context,
                    val repository: Repository) : ViewModel() {

}