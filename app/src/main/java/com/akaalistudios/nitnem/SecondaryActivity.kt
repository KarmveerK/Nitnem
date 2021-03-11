package com.akaalistudios.nitnem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        setContentView(R.layout.activity_secondary)

        val BaniName = findViewById<TextView>(R.id.activity_secondary_bani_name)
        val Banitext = findViewById<TextView>(R.id.secondary_activity_bani_text)
        val Banitext2 = findViewById<TextView>(R.id.secondary_activity_bani_text_2)
        val intent = intent
        val Bani = intent.getStringExtra("Bani")
        when(Bani){
            "ਮੂਲ ਮੰਤਰ"->{
                BaniName.text = "ਮੂਲ ਮੰਤਰ"
                Banitext.setText(R.string.mool_mantra)
            }
            "ਜਪੁਜੀ ਸਾਹਿਬ"->{
                BaniName.text = "ਜਪੁਜੀ ਸਾਹਿਬ"
                Banitext.setText(R.string.japji_sahib)
            }
            "ਜਾਪ ਸਾਹਿਬ"->{
                BaniName.text = "ਜਾਪ ਸਾਹਿਬ"

                Banitext.setText(R.string.jaap_sahib)
                Banitext2.setText(R.string.jaap_sahib2)

            }
            "ਤ੍ਵਪ੍ਰਸਾਦਿ ਸ੍ਵਯੇ"->{
                BaniName.text = "ਤ੍ਵਪ੍ਰਸਾਦਿ ਸ੍ਵਯੇ"
                Banitext.setText(R.string.tav_prasad_savaiye)
            }
            "ਚੌਪਈ ਸਾਹਿਬ"->{
                BaniName.text = "ਚੌਪਈ ਸਾਹਿਬ"
                Banitext.setText(R.string.chaupai_sahib)
            }
            "ਅਨੰਦੁ ਸਾਹਿਬ"->{
                BaniName.text = "ਅਨੰਦੁ ਸਾਹਿਬ"
                Banitext.setText(R.string.anand_sahib)
            }
            "ਰਹਰਾਸਿ ਸਾਹਿਬ"->{
                BaniName.text = "ਰਹਰਾਸਿ ਸਾਹਿਬ"
                Banitext.setText(R.string.rehraas_sahib)
                Banitext2.setText(R.string.rehraas_sahib2)
            }
            "ਕੀਰਤਨ ਸੋਹਿਲਾ"->{
                BaniName.text = "ਕੀਰਤਨ ਸੋਹਿਲਾ"
                Banitext.setText(R.string.kirtan_sohila)
            }
        }
    }
    private fun getBaniString(): String? {
        val jaap_sahib = StringBuilder()
        val reader: BufferedReader
        try {
            reader = BufferedReader(
                InputStreamReader(assets.open("jaap_sahib.txt"))
            )
            var str: String?
            while (reader.readLine().also { str = it } != null) {
                jaap_sahib.append(str)
            }
            reader.close()
            return jaap_sahib.toString()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}