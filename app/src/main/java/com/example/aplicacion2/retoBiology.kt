package com.example.aplicacion2

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_reto_math.*
import kotlinx.android.synthetic.main.activity_reto_biology.*
import org.jetbrains.anko.backgroundDrawable
import org.jetbrains.anko.toast

const val CAMERA_REQUEST = 5

class Reto2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto_biology)
        toast("¿Podrás conseguirlo?")
        imagebutton.setOnClickListener { (camera(it)) }
        okbutton.setOnClickListener { volver(it) }
    }



    //Pedimos permisos y guardamos imagen
    private fun camera(v:View){
        //Chequea si tiene permisos
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED
        ) {

            //Se comprueba el estado actual de los permisos, y se actua en consecuencia
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.CAMERA
                )
            ) {

                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA),
                    1
                )
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, CAMERA_REQUEST)
                cameraIntent.putExtra("foto",cameraIntent)
                setResult(Activity.RESULT_OK, cameraIntent)
            } else {
                toast("RECHAZADO POR SIEMPRE")

            }
        } else {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, CAMERA_REQUEST)
            cameraIntent.putExtra("foto",cameraIntent)
            setResult(Activity.RESULT_OK, cameraIntent)
        }
    }

    //metodo que vuelve a la main activity terminando esta
    private fun volver(v:View){
        finish()
    }
    // esto recoge el resultado de la foto en un boton y volvemos al main donde se hacen comprobaciones
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {


            val imageBitmap = data?.extras?.get("data") as Bitmap
            imagebutton.setBackgroundResource(0)
            imagebutton.setImageBitmap(imageBitmap)
            val intent = Intent()
            intent.putExtra("foto", imageBitmap)
            setResult(Activity.RESULT_OK, intent)

        }
    }



}
