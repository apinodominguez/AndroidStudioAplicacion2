package com.example.aplicacion2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reto_historia.*

class retoHistoria : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto_historia)


        submit.setOnClickListener {
            var valor = respuesta.text.toString()
            if(valor.equals("hola")){
                val data = Intent()
                setResult(Activity.RESULT_OK,data)
                finish()
            }
            else{
                finish()
            }
        }


    }
}
