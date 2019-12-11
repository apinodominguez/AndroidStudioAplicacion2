package com.example.aplicacion2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_reto_historia.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.db.INTEGER

class retoHistoria : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto_historia)
        submit.setOnClickListener {
            var valor = respuesta.text.toString()
            if (valor.equals("1942")) {
                val data = Intent()
                setResult(Activity.RESULT_OK, data)
                finish()
            } else {
                finish()
            }
        }
    }

}
