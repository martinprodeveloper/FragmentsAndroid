package com.example.fragmentsandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    lateinit var buttonFragment1: Button
    lateinit var buttonFragment2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(TAG, "onCreate")

        buttonFragment1 = findViewById(R.id.btn_fragment_1)
        buttonFragment2 = findViewById(R.id.btn_fragment_2)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val mainFragment = MainFragment()
        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        fragmentTransaction.add(R.id.fr_container, mainFragment)
        fragmentTransaction.commit()

        buttonFragment1.setOnClickListener {
            Toast.makeText(this, "Primer Fragmento", Toast.LENGTH_SHORT).show()

            val transaction = supportFragmentManager.beginTransaction()

            transaction.replace(R.id.fr_container, firstFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        buttonFragment2.setOnClickListener {
            Toast.makeText(this, "Segundo Fragmento", Toast.LENGTH_SHORT).show()

            val transaction = supportFragmentManager.beginTransaction()

            transaction.replace(R.id.fr_container, secondFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart")
    }

}