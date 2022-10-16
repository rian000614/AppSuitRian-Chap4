package com.example.appsuitrian_chap4.Intro.inputname

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.appsuitrian_chap4.Intro.OnFinishNavigateListener
import com.example.appsuitrian_chap4.R
import com.example.appsuitrian_chap4.databinding.FragmentInputPlayerNameBinding
import com.example.appsuitrian_chap4.menu.MenuGame


class InputPlayerName :  Fragment(), OnFinishNavigateListener {

    private lateinit var binding: FragmentInputPlayerNameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentInputPlayerNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onFinishNavigateListener() {
        val name = binding.etName.text.toString().trim()
        if (name.isEmpty()) {
            Toast.makeText(requireContext(), "Please input your name !", Toast.LENGTH_SHORT).show()
        } else {
            navigateToMenu(name)
        }
    }


    private fun navigateToMenu(name: String) {
        MenuGame.startActivity(requireContext(), name)
    }
}