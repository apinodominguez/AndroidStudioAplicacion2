package com.example.aplicacion2

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_reto_language.*

class retoLanguage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto_language)

        // comprobacion
        submit.setOnClickListener {
            var valor = respuesta.text.toString()
            if (valor.equals("japones")) {
                val data = Intent()
                setResult(Activity.RESULT_OK, data)
                finish()
            } else {
                finish()
            }
        }
        // boton para llamar al metodo para reproducir audio
        cancion.setOnClickListener{
            (audio(it))
        }
    }
    // Reproducir el audio
    private fun audio(v: View) {
        val mp = MediaPlayer.create(this, R.raw.audio)
        mp.start()
    }
    }
