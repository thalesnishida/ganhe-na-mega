package br.com.thalesnishida.ganhenamega

import android.content.Context
import android.content.SharedPreferences
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {


    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById<EditText>(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.text_result)
        val btnGenerate: Button = findViewById(R.id.btn_generator)

        prefs = getSharedPreferences("db", Context.MODE_PRIVATE )
        val result = prefs.getString("result", null)
        result?.let {
            txtResult.text = "Ultima aposta: $it"
        }

        btnGenerate.setOnClickListener {

            val text = editText.text.toString()
            numberGenerator(text, txtResult)

        }
    }

    private fun numberGenerator(text: String, txtResult: TextView){
        if(text.isEmpty()){
            Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
            return
        }

        val amount = text.toInt()

        if(amount < 6 || amount > 15){
            Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
            return
        }

        val numbers = mutableSetOf<Int>()
        val random = Random()

        while (true){
            val number = random.nextInt(60)
            numbers.add(number + 1)

            if(numbers.size == amount){
                break
            }
        }

        txtResult.text = numbers.joinToString("-")
        prefs.edit().apply {
            putString("result", txtResult.text.toString())
            apply()
        }

    }
}