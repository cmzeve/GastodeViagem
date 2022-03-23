package com.aula.gv

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val etxDistancia = findViewById<EditText>(R.id.etx_distancia)
        val etxPreco =     findViewById<EditText>(R.id.etx_preco)
        val etxAutonomia = findViewById<EditText>(R.id.etx_autonomia)
        val txtValorTotal =findViewById<TextView>(R.id.txt_totalValor)
        val btnCalcular =  findViewById<Button>(R.id.btn_calcular)

        btnCalcular.setOnClickListener {
            if (etxDistancia.text.toString().isEmpty()){
                etxDistancia.error = "Preencha um valor"
            }else if(etxPreco.text.toString().isEmpty()) {
                etxPreco.error = "Preencha um valor"
            }else if(etxAutonomia.text.toString().isEmpty()){
                etxAutonomia.error = "Preencha um valor"
            }else{
                val distancia = etxDistancia.text.toString().toDouble()
                val preco = etxPreco.text.toString().toDouble()
                val autonomia = etxAutonomia.text.toString().toDouble()

                if (autonomia == 0.0){
                    Toast.makeText(
                        this, "Informe Valores Válidos!",
                        Toast.LENGTH_LONG
                    ).show()
                }else {

                    val totalValor = (distancia * preco) / autonomia
                    txtValorTotal.text = String.format("R$ %.2f", totalValor)
                }
            }
        }
    }
}