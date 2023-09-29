package com.matalex.picturesfromtheinternet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.matalex.picturesfromtheinternet.databinding.ItemPictureBinding

class PictureAdapter : RecyclerView.Adapter<PictureAdapter.PictureViewHolder>() {

    var data: List<Picture> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class PictureViewHolder(val binding: ItemPictureBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPictureBinding.inflate(inflater, parent, false)

        return PictureViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        val picture = data[position]
        val context = holder.itemView.context

        with(holder.binding) {


            tvDescription.text = picture.description

            Glide.with(context).load(picture.picture)
//                .circleCrop()
                .error(R.drawable.ic_launcher_foreground)
                .placeholder(R.drawable.ic_launcher_foreground).into(imageView)
        }

    }
}