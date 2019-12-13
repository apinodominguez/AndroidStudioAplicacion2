package com.example.aplicacion2

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.toast

const val historiaRequest = 1;
const val biologyRequest = 2;
const val mathRequest = 3;
const val languageRequest = 4;

class MainActivity : AppCompatActivity() {

    var retoscompletados = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Los botones que inician las activities
        boton1.setOnClickListener { abrirRetos(it,1) }
        boton2.setOnClickListener { abrirRetos(it,2) }
        boton3.setOnClickListener { abrirRetos(it,3) }
        boton4.setOnClickListener { abrirRetos(it,4) }
    }

    // El metodo para iniciar las activities
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

    private fun completo(){
        toast("enhorabuena, has ganado")
    }

    // Este metedo es el que recoge los resultados de las activities
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == historiaRequest){
            if(resultCode == Activity.RESULT_OK){
                boton1.setBackgroundColor(Color.parseColor("#01DF01"))
                boton1.setEnabled(false) // En este punto el boton es desactivado
                toast("Has ganado el reto de historia")
                // recogemos que el reto se completo y lo añadimos al total de retos completados
                retoscompletados += 1
                // Si se ganan todos los retos se ejecuta un metodo para felicitar
                if (retoscompletados == 4) {
                    completo()
            }
            else{
                toast("Has fallado el reto")
            }

        }
        if (requestCode == biologyRequest) {
            if (resultCode == Activity.RESULT_OK) {

                //Recogemos la foto, accedemos al pixel 0,0,recogemos los colores y comprobamos si es azul
                //hacemos 3 comprobaciones para cerciorarnos.
                val imageBitmap = data?.extras?.get("foto") as Bitmap
                var pixel1 = imageBitmap.getPixel(0, 0)
                var redValue = Color.red(pixel1)
                var blueValue = Color.blue(pixel1)
                var greenValue = Color.green(pixel1)

                if (blueValue > greenValue && blueValue > redValue) {
                    var pixel2 = imageBitmap.getPixel(3, 0)
                    var redValue = Color.red(pixel2)
                    var blueValue = Color.blue(pixel2)
                    var greenValue = Color.green(pixel2)
                    if (blueValue > greenValue && blueValue > redValue) {
                        var pixel3 = imageBitmap.getPixel(6, 0)
                        var redValue = Color.red(pixel3)
                        var blueValue = Color.blue(pixel3)
                        var greenValue = Color.green(pixel3)
                        if (blueValue > greenValue && blueValue > redValue) {
                            boton2.setBackgroundColor(Color.parseColor("#01DF01"))
                            boton2.setEnabled(false) // En este punto el boton es desactivado
                            toast("Has ganado el reto de biologia")
                            // recogemos que el reto se completo y lo añadimos al total de retos completados
                            retoscompletados += 1
                            // Si se ganan todos los retos se ejecuta un metodo para felicitar
                            if (retoscompletados == 4) {
                                completo()
                        } else {
                            toast("Has fallado el reto")
                        }
                    } else {
                        toast("Has fallado el reto")
                    }
                } else {
                    toast("Has fallado el reto")
                }
            }
        }
        if (requestCode == mathRequest) {
            if (resultCode == Activity.RESULT_OK) {
                boton3.setBackgroundColor(Color.parseColor("#01DF01"))
                boton3.setEnabled(false) // En este punto el boton es desactivado
                toast("Has ganado el reto de matemáticas")
                // recogemos que el reto se completo y lo añadimos al total de retos completados
                retoscompletados += 1
                // Si se ganan todos los retos se ejecuta un metodo para felicitar
                if (retoscompletados == 4) {
                    completo()
                } else {
                    toast("Has fallado el reto")
                }

            }
            if (requestCode == languageRequest) {
                if (resultCode == Activity.RESULT_OK) {
                    boton4.setBackgroundColor(Color.parseColor("#01DF01"))
                    boton4.setEnabled(false) // En este punto el boton es desactivado
                    toast("Has ganado el reto de lengua")
                    // recogemos que el reto se completo y lo añadimos al total de retos completados
                    retoscompletados += 1
                    // Si se ganan todos los retos se ejecuta un metodo para felicitar
                    if (retoscompletados == 4) {
                        completo()
                    } else {
                        toast("Has fallado el reto")
                    }

                }
            }
        }}}}}


