package com.example.meuprimeiroprojeto

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /*
        TABELA IMC
        MENOR QUE 18.5          ABAIXO DO PESO
        ENTRE 18.5 E 24.9       NORMAL
        ENTRE 25.0 E 29.9       SOBREPESO
        ENTRE 30.0 E 39.9       OBESIDADE
        MAIOR QUE 40.00         OBESIDADE GRAVE
        */

        var classificacao = ""

        if(result < 18.5f){
            classificacao += "ABAIXO DO PESO"
            tvClassificacao.setTextColor(Color.parseColor("#FF0000"))
        }else if (result in 18.5f..24.9f){
            classificacao += "NORMAL"
            tvClassificacao.setTextColor(Color.parseColor("#008000"))

        }else if (result in 25.0f..29.9f){
            classificacao += "SOBREPESO"
            tvClassificacao.setTextColor(Color.parseColor("#EDA55E"))
        }else if (result in 30.0f..39.9f){
            classificacao += "OBESIDADE"
            tvClassificacao.setTextColor(Color.parseColor("#FF0000"))
        }else {
            classificacao += "OBESIDADE GRAVE"
            tvClassificacao.setTextColor(Color.parseColor("#FF0000"))
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        finish()
        return super.onOptionsItemSelected(item)



    }
}