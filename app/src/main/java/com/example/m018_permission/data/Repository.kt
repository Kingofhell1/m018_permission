package com.example.m018_permission.data

import androidx.lifecycle.LiveData
import com.example.m018_permission.premission.App
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class Repository(context: Context?) {

    val photoDatabase = (context?.applicationContext as App).photoDatabase.photoDao()

    fun savePhoto (uri: String, name: String) {
        val photo = Photo(uri, name)
        CoroutineScope(Dispatchers.IO).launch {
            photoDatabase.insertPhoto(photo)
        }
    }

    fun getPhotoList (): Flow<List<Photo>> {
        return photoDatabase.getAllPhotos()
    }
}