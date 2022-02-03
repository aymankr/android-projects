package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onStart() {
        super.onStart()

    }

    fun onClickMultiply(view: View) {
        var v1 = findViewById<EditText>(R.id.editTextNumber)
        var v2 = findViewById<EditText>(R.id.editTextNumber2)
        if (v1.text.isNotEmpty() && v2.text.isNotEmpty()) {
            var result = findViewById<TextView>(R.id.tViewResult)
            result.setText("Result : " + (v1.text.toString().toInt()) * (v2.text.toString().toInt()))
        }
    }


    fun onClickAddition(view: View) {
        var v1 = findViewById<EditText>(R.id.editTextNumber)
        var v2 = findViewById<EditText>(R.id.editTextNumber2)
        if (v1.text.isNotEmpty() && v2.text.isNotEmpty()) {
            var result = findViewById<TextView>(R.id.tViewResult)
            result.setText("Result : " + (v1.text.toString().toInt()) + (v2.text.toString().toInt()))
        }
    }
    fun onClickSubstract(view: View) {
        var v1 = findViewById<EditText>(R.id.editTextNumber)
        var v2 = findViewById<EditText>(R.id.editTextNumber2)
        if (v1.text.isNotEmpty() && v2.text.isNotEmpty()) {
            var result = findViewById<TextView>(R.id.tViewResult)
            result.setText("Result : " + ((v1.text.toString().toInt()) - (v2.text.toString().toInt())))
        }
    }
    fun onClickDivide(view: View) {
        var v1 = findViewById<EditText>(R.id.editTextNumber)
        var v2 = findViewById<EditText>(R.id.editTextNumber2)
        if (v1.text.isNotEmpty() && v2.text.isNotEmpty()) {
            var result = findViewById<TextView>(R.id.tViewResult)
            result.setText("Result : " + (v1.text.toString().toInt()) / (v2.text.toString().toInt()))
        }
    }
}