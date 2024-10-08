package com.example.myapplication.Adapter

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.Model.BrandModel
import com.example.myapplication.R
import com.example.myapplication.databinding.ViewholderBrandBinding
import com.example.myapplication.databinding.ViewholderColorBinding

class ColorAdapter(val items: MutableList<String>) :
    RecyclerView.Adapter<ColorAdapter.Viewholder>() {

    private var selectedPosition = -1
    private var lastSelectedPosition = -1
    private lateinit var context: Context

    class Viewholder(val binding: ViewholderColorBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorAdapter.Viewholder {
        context = parent.context
        val biding = ViewholderColorBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(biding)
    }

    override fun onBindViewHolder(holder: ColorAdapter.Viewholder, position: Int) {



        Glide.with(holder.itemView.context)
            .load(items[position])
            .into(holder.binding.pic)

        holder.binding.root.setOnClickListener {
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
        }

        if (selectedPosition == position) {

            holder.binding.ColorLayout.setBackgroundResource(R.drawable.grey_bg_selected)
        } else {
            holder.binding.ColorLayout.setBackgroundResource(R.drawable.grey_bg)
        }
    }

    override fun getItemCount(): Int = items.size
}