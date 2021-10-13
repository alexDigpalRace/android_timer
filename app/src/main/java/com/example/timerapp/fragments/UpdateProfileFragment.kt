package com.example.timerapp.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.timerapp.R
import com.example.timerapp.database.Profile
import com.example.timerapp.database.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_update_profile.*
import kotlinx.android.synthetic.main.fragment_update_profile.view.*


class UpdateProfileFragment : Fragment() {

    private val args by navArgs<UpdateProfileFragmentArgs>()

    private lateinit var myProfileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update_profile, container, false)

        myProfileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)

        // TODO view binding
        view.profile_update_et_name.setText(args.currentProfile.name)
        view.profile_update_save_btn.setOnClickListener {
            updateItem()
        }

        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem() {
        val profileName : String = profile_update_et_name.text.toString()

        if (inputCheck(profileName)) {
            val updatedProfile = Profile(args.currentProfile.id, profileName)
            myProfileViewModel.updateProfile(updatedProfile)
            Toast.makeText(requireContext(), "Updated successfully", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateProfileFragment_to_profileFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields...?", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(profileName: String): Boolean {
        return !TextUtils.isEmpty(profileName)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteProfile()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteProfile () {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Delete ${args.currentProfile.name}")
        builder.setMessage("Are you sure you want to delete?")
        builder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, id ->
            myProfileViewModel.deleteProfile(args.currentProfile)
            Toast.makeText(
                requireContext(),
                "Sucessfully removed ${args.currentProfile.name}",
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateProfileFragment_to_profileFragment)
        })
        builder.setNegativeButton("No") {_, _ ->}
        builder.create().show()
    }
}