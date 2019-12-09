package com.example.aplicacion2

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

const val historiaRequest = 1;

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        boton1.setOnClickListener {
            val intent = Intent(this, retoHistoria::class.java)
            startActivityForResult(intent,historiaRequest)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                boton1.setBackgroundColor(Color.parseColor("#01DF01"))
                boton1.setEnabled(false)
                toast("Has ganado el reto")
            }
            else{
                toast("Has fallado el reto")
            }

        }
    }


}
