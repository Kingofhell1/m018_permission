package com.example.m018_permission.premission

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.m018_permission.databinding.FragmentPhotoCardBinding
import java.util.*
import androidx.navigation.fragment.navArgs
import com.example.m018_permission.data.ConstData
import com.example.m018_permission.data.Photo
import com.example.m018_permission.premission.MainFragment.Companion.KEY_IMG


class PhotoCardFragment : Fragment() {

    private var _binding: FragmentPhotoCardBinding? = null
    private val binding get() = _binding!!
    private var _photo: Photo? = null
    private var photo = _photo

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhotoCardBinding.inflate(layoutInflater)
        arguments?.let {
             val photo = it.getString(KEY_IMG)
//            photo = it.getParcelable(ConstData.PHOTO)!!
            Log.d("Photo get", photo.toString())
            if (photo != null) {
                Glide
                    .with(this@PhotoCardFragment)
                    .load(photo)
                    .into(binding.photoView)


            }
        }

        return binding.root
    }

}