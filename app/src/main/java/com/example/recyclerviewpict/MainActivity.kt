package com.example.recyclerviewpict

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewpict.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menggunakan generatePictures, membuat instance adapter, dan diatur ke RecyclerView
        val pictureList = generatePictures()
        val adapterPicture = PictureAdapter(pictureList)

        // Mengatur RecyclerView pada rvPicture
        with(binding) {
            rvPicture.apply {
                adapter = adapterPicture
                layoutManager = GridLayoutManager(this@MainActivity, 3)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Membuat daftar objek Picture yang akan ditampilkan
    private fun generatePictures() : List<Picture> {
        return listOf(
            Picture(R.drawable.baseline_tsunami_24, "Tsunami"),
            Picture(R.drawable.baseline_volcano_24, "Volcano"),
            Picture(R.drawable.baseline_warning_24, "War"),
            Picture(R.drawable.baseline_flood_24, "Flood"),
            Picture(R.drawable.baseline_cloudy_snowing_24, "Cloudy"),
            Picture(R.drawable.baseline_directions_bus_24, "Bus Accident")
        )
    }
}