package org.sopt.androidweek.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.sopt.androidweek.R
import org.sopt.androidweek.databinding.FragmentSecondOnBoardBinding

class SecondOnBoardFragment : Fragment() {
    private var _binding: FragmentSecondOnBoardBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondOnBoardBinding.inflate(layoutInflater,container,false)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_second_fragment_to_third_fragment)
        }

        return binding.root
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}