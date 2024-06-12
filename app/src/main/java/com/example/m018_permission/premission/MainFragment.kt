package com.example.m018_permission.premission

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.GridLayoutManager
import com.example.m018_permission.R
import com.example.m018_permission.data.Repository
import com.example.m018_permission.databinding.FragmentMainBinding
import androidx.navigation.fragment.findNavController
import com.example.m018_permission.data.ConstData
import com.example.m018_permission.data.ConstData.PHOTO
import com.example.m018_permission.data.Photo
import com.example.m018_permission.premission.PhotoAdapter



class MainFragment : Fragment() {

    private  var _binding: FragmentMainBinding? = null
    private  val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                    return MainViewModel(
                        requireContext(),
                        Repository(context?.applicationContext)
                    ) as T
                } else {
                    throw IllegalArgumentException("")
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater)

        val adapter = PhotoAdapter(requireContext(), {photo -> onItemClick(photo)})

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(
            requireContext(),
            3,
            GridLayoutManager.VERTICAL,
            false
        )

        viewModel.repository.getPhotoList().asLiveData().observe(viewLifecycleOwner) { listOfSights ->
            adapter.setData(listOfSights)
        }

        binding.takePhoto.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_photoFragment)
        }

        return binding.root


    }
    private fun onItemClick(item: Photo){
        val bundle = Bundle().apply{
            putString(KEY_IMG, item.photoUri)
        }
       Log.d("Photo take", bundle.toString())
       findNavController().navigate(resId = R.id.action_photoFragment_to_mainCard, args = bundle)
    }
    companion object{
        const val KEY_IMG = "KEY_IMG"
    }



}
