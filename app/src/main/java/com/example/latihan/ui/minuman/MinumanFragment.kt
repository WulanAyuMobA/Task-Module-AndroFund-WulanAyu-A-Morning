package com.example.latihan.ui.minuman

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.latihan.R
import com.example.latihan.databinding.FragmentMinumanBinding



class MinumanFragment : Fragment() {

    private var _binding: FragmentMinumanBinding?= null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMinumanBinding.inflate(layoutInflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.klik?.setOnClickListener{
            pindah()
        }
    }

    private fun pindah() {
        val DetailMinumanFragment = DetailMinumanFragment()
          val fragmentManger = parentFragmentManager
        fragmentManger.beginTransaction().apply {
            replace(R.id.fcv_main,DetailMinumanFragment,DetailMinumanFragment::class.java.simpleName)
            addToBackStack(null)
            commit()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}