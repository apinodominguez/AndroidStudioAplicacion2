package com.example.aplicacion2

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

const val historiaRequest = 1;
const val biologyRequest = 2;
const val mathRequest = 3;
const val languageRequest = 4;

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton1.setOnClickListener { abrirRetos(it,1) }
        boton2.setOnClickListener { abrirRetos(it,2) }
        boton3.setOnClickListener { abrirRetos(it,3) }
        boton4.setOnClickListener { abrirRetos(it,4) }
    }

    fun abrirRetos(v: View, num: Int) {

        when (num) {
            1 -> {
                val intent = Intent(this, retoHistoria::class.java)
                startActivityForResult(intent,historiaRequest)
            }
            2 -> {
                val intent = Intent(this, retoBiology::class.java)
                startActivityForResult(intent,biologyRequest)
            }
            3 -> {
                val intent = Intent(this, retoMath::class.java)
                startActivityForResult(intent, mathRequest)
            }
            4 -> {
                val intent = Intent(this, retoLanguage::class.java)
                startActivityForResult(intent,biologyRequest)
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == historiaRequest){
            if(resultCode == Activity.RESULT_OK){
                boton1.setBackgroundColor(Color.parseColor("#01DF01"))
                boton1.setEnabled(false)
                toast("Has ganado el reto de historia")
            }
            else{
                toast("Has fallado el reto")
            }

        }
        if (requestCode == biologyRequest){
            if(resultCode == Activity.RESULT_OK){
                boton1.setBackgroundColor(Color.parseColor("#01DF01"))
                boton1.setEnabled(false)
                toast("Has ganado el reto de historia")
            }
            else{
                toast("Has fallado el reto")
            }

        }
        if (requestCode == mathRequest){
            if(resultCode == Activity.RESULT_OK){
                boton3.setBackgroundColor(Color.parseColor("#01DF01"))
                boton3.setEnabled(false)
                toast("Has ganado el reto de matematicas")
            }
            else{
                toast("Has fallado el reto")
            }

        }
        if (requestCode == languageRequest){
            if(resultCode == Activity.RESULT_OK){
                boton1.setBackgroundColor(Color.parseColor("#01DF01"))
                boton1.setEnabled(false)
                toast("Has ganado el reto de historia")
            }
            else{
                toast("Has fallado el reto")
            }

        }
    }


}
