package com.example.myapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity



class MainActivity() : AppCompatActivity(), Parcelable {


    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btnClick: Button =  findViewById(R.id.btn_click)
        val btnSecond: Button = findViewById(R.id.btn_second)


        btnSecond.setOnClickListener {
            // IMPLISIT INTENT untuk membuka URL di Google Chrome
//            val url = "https://chat.openai.com"
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
//                setPackage("com.android.chrome") // Memastikan membuka di Chrome
//            }
//
//            // Memeriksa apakah ada aplikasi yang dapat menangani intent ini
//            if (intent.resolveActivity(packageManager) != null) {
//                startActivity(intent)
//            } else {
//                // Jika Chrome tidak terinstal, buka dengan cara lain
//                val fallbackIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
//                startActivity(fallbackIntent)
//            }
//        }

            val intent = Intent().apply {
                action = Intent.ACTION_SEND

                type = "text/plain"
            }
            intent.putExtra(Intent.EXTRA_TEXT, "Hai, ini adalah kiriman")
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(
                    applicationContext,
                    "Tidak ada aplikasi yang support",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        btnClick.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }
}
