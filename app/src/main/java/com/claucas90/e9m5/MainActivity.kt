package com.claucas90.e9m5

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputTemperature: EditText
    private lateinit var convertButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputTemperature = findViewById(R.id.editTextTemperature)
        convertButton = findViewById(R.id.buttonConvert)
        resultTextView = findViewById(R.id.textViewResult)

        convertButton.setOnClickListener {
            convertTemperature()
        }
    }

    private fun convertTemperature() {
        try {
            val temperature = inputTemperature.text.toString().toDouble()

            // Convertir a  Fahrenheit
            val fahrenheit = (9.0 / 5.0) * temperature + 32

            // Convertir a Celsius
            val celsius = temperature - 273.15

            // Convertir a  Kelvin
            val kelvin = (5.0 / 9.0) * (temperature - 32) + 273.15

            // Format the results with 2 decimal places
            val result = "%.2f grados Celsius son %.2f grados Fahrenheit.\n%.2f grados Kelvin son %.2f grados Celsius.\n%.2f grados Fahrenheit son %.2f grados Kelvin.".format(
                temperature, fahrenheit, temperature, celsius, temperature, kelvin
            )

            resultTextView.text = result

        } catch (e: NumberFormatException) {
            resultTextView.text = "Ingrese una temperatura válida."
        }
    }
}
