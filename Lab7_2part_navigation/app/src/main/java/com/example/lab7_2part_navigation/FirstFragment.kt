package com.example.lab7_2part_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lab7_2part_navigation.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var result:String? = ""
        childFragmentManager.setFragmentResultListener("main_data", this){_, bundle->
            result = bundle.getString("text")
            binding.textViewHeader.text = result
        }
        binding.buttonChange.setOnClickListener{
            result?.let{
                findNavController().navigate(FirstFragmentDirections.toSecondFragment(it))
            }
        }


    }





}