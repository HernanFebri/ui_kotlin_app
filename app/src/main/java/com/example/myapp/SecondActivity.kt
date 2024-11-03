package com.example.myapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.fragment.FirstFragment

class SecondActivity : AppCompatActivity() {
    private  val dataString: String = "Helo ini adalah data string"

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

       val transaction = supportFragmentManager.beginTransaction()
        val firstFragment = FirstFragment.sendData(dataString)


        transaction.replace(R.id.fragment_container, firstFragment)
        transaction.commit()


    }
}