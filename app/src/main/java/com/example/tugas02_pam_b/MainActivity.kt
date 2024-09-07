package com.example.tugas02_pam_b

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNumber1 = findViewById<EditText>(R.id.etNumber1)
        val etNumber2 = findViewById<EditText>(R.id.etNumber2)
        val rgOperation = findViewById<RadioGroup>(R.id.rgOperation)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)

        btnCalculate.setOnClickListener {
            val num1 = etNumber1.text.toString().toDouble()
            val num2 = etNumber2.text.toString().toDouble()
            val selectedOperation = rgOperation.checkedRadioButtonId

            val result = when (selectedOperation) {
                R.id.rbTambah -> num1 + num2
                R.id.rbKurang -> num1 - num2
                R.id.rbKali -> num1 * num2
                R.id.rbBagi -> num1 / num2
                else -> 0.0
            }

            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("result", result)
                putExtra("nim", "12345678")
                putExtra("nama", "Nama Anda")
            }
            startActivity(intent)
        }
    }
}