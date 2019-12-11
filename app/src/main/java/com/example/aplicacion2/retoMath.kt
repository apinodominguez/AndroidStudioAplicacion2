package com.example.aplicacion2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reto_math.*

class retoMath : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto_math)

        comprobar.setOnClickListener {
            var valor = Integer.parseInt(respuesta.text.toString())
            if (valor.equals(4)) {
                val data = Intent()
                setResult(Activity.RESULT_OK, data)
                finish()
            } else {
                finish()
            }
        }

    }
}
