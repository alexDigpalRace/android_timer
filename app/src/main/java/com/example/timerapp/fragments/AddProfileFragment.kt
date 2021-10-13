package com.example.timerapp.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.timerapp.R
import com.example.timerapp.database.Profile
import com.example.timerapp.database.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_add_profile.*
import kotlinx.android.synthetic.main.fragment_add_profile.view.*

class AddProfileFragment : Fragment() {

    private lateinit var myProfileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_profile, container, false)

        myProfileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        view.profile_save_btn.setOnClickListener {
            // save profile to database
            insertDataToDatabase()
        }

        return view
    }

    // TODO change to view binding
    private fun insertDataToDatabase() {
        val profileName = profile_et_name.text.toString()

        if (inputCheck(profileName)) {
            val profile = Profile(0, profileName)
            myProfileViewModel.addProfile(profile)
            Toast.makeText(requireContext(), "Sucessfully added", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addProfileFragment_to_profileFragment)
        } else {
            Toast.makeText(requireContext(), "Please enter a name", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(profileName: String): Boolean {
        return !TextUtils.isEmpty(profileName)
    }
}