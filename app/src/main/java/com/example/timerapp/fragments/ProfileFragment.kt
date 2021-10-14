package com.example.timerapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.timerapp.ProfileAdapter
import com.example.timerapp.R
import com.example.timerapp.viewModel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.view.*


class ProfileFragment : Fragment() {

    private lateinit var myProfileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // recycler view
        val adapter = ProfileAdapter()
        val recyclerView = view.profile_recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // ProfileViewModel
        myProfileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        myProfileViewModel.readAllProfiles.observe(viewLifecycleOwner, Observer { profile ->
            adapter.setData(profile)
        })

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_addProfileFragment)
        }
        return view
    }
}