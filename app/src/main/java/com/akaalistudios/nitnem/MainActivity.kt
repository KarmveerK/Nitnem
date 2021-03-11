package com.akaalistudios.nitnem

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    val banis = arrayOf("ਮੂਲ ਮੰਤਰ","ਜਪੁਜੀ ਸਾਹਿਬ", "ਜਾਪ ਸਾਹਿਬ", "ਤ੍ਵਪ੍ਰਸਾਦਿ ਸ੍ਵਯੇ", "ਚੌਪਈ ਸਾਹਿਬ", "ਅਨੰਦੁ ਸਾਹਿਬ","ਰਹਰਾਸਿ ਸਾਹਿਬ","ਕੀਰਤਨ ਸੋਹਿਲਾ")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        setContentView(R.layout.activity_main)

        val bani_list = findViewById<RecyclerView>(R.id.bani_list).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = BaniAdapter(banis) {
                val intent = Intent(this@MainActivity, SecondaryActivity::class.java).apply {
                    putExtra("Bani", it)
                }
                startActivity(intent)
            }.apply {
                setHasStableIds(true)
            }
            setHasFixedSize(true)
        }

    }


}