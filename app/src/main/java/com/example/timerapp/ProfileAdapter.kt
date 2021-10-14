package com.example.timerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.timerapp.model.Profile
import com.example.timerapp.fragments.ProfileFragmentDirections
import kotlinx.android.synthetic.main.profile_custom_row.view.*

class ProfileAdapter: RecyclerView.Adapter<ProfileAdapter.MyViewHolder>() {

    private  var profileList = emptyList<Profile>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.profile_custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = profileList[position]
        holder.itemView.profile_list_btn.text = currentItem.name.toString()

        holder.itemView.profile_list_btn.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToUpdateProfileFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    fun setData(profiles: List<Profile>) {
        this.profileList = profiles
        notifyDataSetChanged()
    }
}