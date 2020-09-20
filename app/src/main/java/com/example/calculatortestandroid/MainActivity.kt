package com.example.calculatortestandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

const val CALCULATE_EXPRESSION_FOR_SAVE = "clickCount";
const val RESULT_FOR_SAVE = "result";

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        creating buttons
        btn0.setOnClickListener() {
            changeText("0")
        }
        btn1.setOnClickListener() {
            changeText("1")
        }
        btn2.setOnClickListener() {
            changeText("2")
        }
        btn3.setOnClickListener() {
            changeText("3")
        }
        btn4.setOnClickListener() {
            changeText("4")
        }
        btn5.setOnClickListener() {
            changeText("5")
        }
        btn6.setOnClickListener() {
            changeText("6")
        }
        btn7.setOnClickListener() {
            changeText("7")
        }
        btn8.setOnClickListener() {
            changeText("8")
        }
        btn9.setOnClickListener() {
            changeText("9")
        }
        btnMinus.setOnClickListener() {
            changeText("-")
        }
        btnPlus.setOnClickListener(){
            changeText("+")
        }
        btnMult.setOnClickListener(){
            changeText("*")
        }
        btnDiv.setOnClickListener(){
            changeText("/")
        }
        btnLb.setOnClickListener() {
            changeText("(")
        }
        btnRb.setOnClickListener() {
            changeText(")")
        }



    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState);
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    fun changeText (input:String) {
        toCalculate.append(input.toString())
    }
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//
//        val expressionToCalcRestored = savedInstanceState.getString(EXPRESSION_TO_CALC_TAG)
//        if (expressionToCalcRestored != null)
//            updateCalcExpression(expressionToCalcRestored)
//
//        val resultRestored = savedInstanceState.getString(RESULT_TAG)
//        if (resultRestored != null)
//            updateResult(resultRestored)
//    }
}