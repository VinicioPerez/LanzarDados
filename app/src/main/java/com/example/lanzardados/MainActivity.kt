package com.example.lanzardados

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLanzar: Button = findViewById(R.id.btnLanzar)

        btnLanzar.setOnClickListener{
            tiempo()

        }
        rollDice()
    }

    private fun rollDice(){
        //val numero = lanzar(6)
        var numero: Int = lanzar(6)
        val txtResult: TextView = findViewById(R.id.txtResultado)
        txtResult.text = numero.toString()



        val drawableResource = when(numero){
            1 -> R.drawable.dado1
            2 -> R.drawable.dado2
            3 -> R.drawable.dado3
            4 -> R.drawable.dado4
            5 -> R.drawable.dado5
            else -> R.drawable.dado6
        }

        val imgDado: ImageView = findViewById(R.id.imgDado)
        imgDado.setImageResource(drawableResource)



        //Toast.makeText(this, numero.toString(), Toast.LENGTH_LONG).show()

    }

    private fun lanzar(max: Int): Int{
        return (1..max).random()
    }

    private fun tiempo(){
        object: CountDownTimer(3000, 150){
            override fun onTick(millisUntilFinished: Long) {
                rollDice()
            }

            override fun onFinish() {

            }

        }.start()
    }
}