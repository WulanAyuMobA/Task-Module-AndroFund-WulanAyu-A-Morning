package com.example.latihan.ui.minuman

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.latihan.R
import com.example.latihan.databinding.FragmentDetailMinumanBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class DetailMinumanFragment : Fragment() {

    private var _binding: FragmentDetailMinumanBinding?= null
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailMinumanBinding.inflate(layoutInflater,container,false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.button2?.setOnClickListener{
            Toast.makeText(requireActivity(),"Pesanan Berhasil", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}