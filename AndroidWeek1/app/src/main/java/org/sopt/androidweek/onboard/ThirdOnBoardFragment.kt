package org.sopt.androidweek.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.sopt.androidweek.R
import org.sopt.androidweek.databinding.FragmentThirdOnBoardBinding

class ThirdOnBoardFragment : Fragment() {
    private var _binding: FragmentThirdOnBoardBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdOnBoardBinding.inflate(layoutInflater, container, false)

        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_third_fragment_to_sign_in_activity)
            requireActivity().finish()
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}