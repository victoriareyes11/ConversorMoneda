package com.example.conversormoneda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.conversormoneda.constantes.constantes.Companion.INTERLIN
import com.example.conversormoneda.constantes.constantes.Companion.SPACE
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerone: Spinner = findViewById(R.id.sp_moneyone)

        ArrayAdapter.createFromResource(this, R.array.moneyone_list, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerone.adapter = adapter
        }

        val spinnertwo: Spinner = findViewById(R.id.sp_moneytwo)

        ArrayAdapter.createFromResource(this, R.array.moneytwo_list, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnertwo.adapter = adapter
        }

        img_conver.setOnClickListener {

            val valor = et_valor.text.toString().toFloat()

            val money_one = spinnerone.selectedItem.toString()
            val money_two = spinnertwo.selectedItem.toString()
            if(valor.equals(null)){
                Toast.makeText(this, "Opcion invalida", Toast.LENGTH_SHORT).show()
            }

            when (money_one) {
                "Pesos" -> when(money_two){
                            "Pesos" -> tv_resultado.text=INTERLIN+valor.toString()+getString(R.string.pesosigual)+SPACE+valor.toString()+getString(
                                                            R.string.pesos)
                            "Dolares" ->tv_resultado.text=INTERLIN+valor.toString()+getString(R.string.pesosigual)+SPACE+(valor*0.0003084).toString()+getString(
                                                            R.string.dolares)
                            "Euros" ->tv_resultado.text=INTERLIN+valor.toString()+getString(R.string.pesosigual)+SPACE+(valor*0.0002778).toString()+getString(
                                                            R.string.euros)
                             }
                "Dolares"-> when(money_two){
                            "Pesos" ->tv_resultado.text=INTERLIN+valor.toString()+getString(R.string.dolaresigual)+SPACE+(valor*3.242).toString()+getString(
                                                            R.string.pesos)
                            "Dolares" ->tv_resultado.text=INTERLIN+valor.toString()+getString(R.string.dolaresigual)+ SPACE+valor.toString()+getString(
                                                            R.string.dolares)
                            "Euros" ->tv_resultado.text=INTERLIN+valor.toString()+getString(R.string.dolaresigual)+SPACE+(valor*0.90060).toString()+getString(
                                                            R.string.euros)
                            }
                "Euros"-> when(money_two){
                            "Pesos" ->tv_resultado.text=INTERLIN+valor.toString()+getString(R.string.eurosigual)+SPACE+(valor*3.600).toString()+getString(
                                                             R.string.pesos)
                            "Dolares" ->tv_resultado.text=INTERLIN+valor.toString()+getString(R.string.eurosigual)+SPACE+(valor*1.1104).toString()+getString(
                                                             R.string.dolares)
                            "Euros" ->tv_resultado.text=INTERLIN+valor.toString()+getString(R.string.eurosigual)+SPACE+valor.toString()+getString(
                                                             R.string.euros)
                            }
                else -> {
                    Toast.makeText(this, "Opcion invalida", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}
