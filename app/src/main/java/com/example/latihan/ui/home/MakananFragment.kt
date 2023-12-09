package com.example.latihan.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihan.data.DataFood
import com.example.latihan.databinding.FragmentMakananBinding
import com.example.latihan.ui.home.adapter.FoodAdapter


class MakananFragment : Fragment() {

    private var _binding: FragmentMakananBinding?= null
    private val binding get() = _binding
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMakananBinding.inflate(layoutInflater,container,false)
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        foodAdapter = FoodAdapter{food->
            val action = MakananFragmentDirections.actionHomeFragmentToDetailFragment(food)
            findNavController().navigate(action)
        }
        val foodData = DataFood.dummyFood
//        tanpa apply
//        binding?.rvFood?.layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL,false)
//        binding?.rvFood?.adapter = foodAdapter
//        pakai apply
        binding?.rvFood?.apply {
            layoutManager = LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL,false)
            adapter = foodAdapter // ini variabel dari class foodAdapter.
        }
        foodAdapter.submitList(foodData)
    }


}