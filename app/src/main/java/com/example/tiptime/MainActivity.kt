package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    private lateinit var calcBut : Button
    private lateinit var serviceCost : EditText
    private lateinit var serviceValue : RadioGroup
    private lateinit var roundUp : Switch
    private lateinit var tipAmount : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calcBut = findViewById(R.id.calculate_button)
        calcBut.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        serviceCost = findViewById(R.id.cost_of_service)
        serviceValue = findViewById(R.id.tip_options)
        roundUp = findViewById(R.id.round_up_switch)
        tipAmount = findViewById(R.id.tip_result)
        var cost = serviceCost.text.toString().toDouble()
        val tipPercent = if(serviceValue.checkedRadioButtonId == R.id.option_twenty_percent) 0.2 else if(serviceValue.checkedRadioButtonId == R.id.option_eighteen_percent) 0.18 else 0.15
        cost *= tipPercent
        val tip = if(roundUp.isChecked) ceil(cost) else cost
        tipAmount.text = "Tip Amount: " + tip.toString()
    }
}