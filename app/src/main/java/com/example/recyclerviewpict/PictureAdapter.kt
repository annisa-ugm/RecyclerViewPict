package com.example.recyclerviewpict

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpict.databinding.ItemPictureBinding

// Menerima daftar Picture dan menghubungkannya dengan RecyclerView.
class PictureAdapter (private val listPicture: List<Picture>) :
    RecyclerView.Adapter<PictureAdapter.PictureViewHolder>() {

    // Memegang referensi tampilan item individu dalam RecyclerView
    inner class PictureViewHolder(private val binding: ItemPictureBinding) :
            RecyclerView.ViewHolder(binding.root) {

        // Untuk atur gambar dan teks pada item layout bds objek Picture
                fun bind(picture: Picture) {
                    with(binding) {
                        imgDisaster.setImageResource(picture.drawableResId)
                        txtDisasterDescription.text = picture.description
                    }
                }
            }

    // Dipanggil saat ViewHolder baru harus dibuat
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val binding = ItemPictureBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return PictureViewHolder(binding)
    }

    // Mengembalikan jumlah item dalam listPicture.
    override fun getItemCount(): Int {

        return listPicture.size
    }

    // Menghubungkan data di posisi tertentu dari listPicture ke ViewHolder.
    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder.bind(listPicture[position])
    }
}