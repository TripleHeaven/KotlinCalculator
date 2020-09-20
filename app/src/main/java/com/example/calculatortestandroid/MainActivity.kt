package com.example.calculatortestandroid

import android.R.attr.button
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


const val TO_CALC_SAVE = "toCalc.text"
const val TO_RES_SAVE = "result.text"

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
        btnClear.setOnClickListener() {
            toCalculate.text=""
            result.text=""
        }
        btnDot.setOnClickListener() {
            changeText(".")
        }
        btnBack.setOnClickListener(){
            val test = toCalculate.text
            if (test.isNotEmpty()){
                toCalculate.text = test.substring(0, test.length-1)
            }
            result.text=""
        }
        result.setOnClickListener(View.OnClickListener {

            var clipboardd = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            var clip = ClipData.newPlainText("label", result.text.toString())
            clipboardd.setPrimaryClip(clip)
        })




        btnEvaluate.setOnClickListener(){
            try{
                val expression = ExpressionBuilder(toCalculate.text.toString()).build()
                val total = expression.evaluate()

                val forCheck1 = total.toLong()
                val forCheck2 = total.toDouble()
                if (total == forCheck1.toDouble()){
                    result.text =forCheck1.toString()
                }
                else{
                    result.text = total.toString()
                }
            }
            catch (e:Exception) {
                result.text="Invalid Expression"
            }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(TO_CALC_SAVE, toCalculate.text.toString())
        outState.putString(TO_RES_SAVE, result.text.toString())
        super.onSaveInstanceState(outState);
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        val toCalculateT = savedInstanceState.getString(TO_CALC_SAVE)
        val resultT = savedInstanceState.getString(TO_RES_SAVE)
        toCalculate.text = toCalculateT
        result.text = resultT
        super.onRestoreInstanceState(savedInstanceState)
    }

    fun changeText (input:String) {
        if (result.text=="Invalid Expression"){
            result.text=""
            toCalculate.text=""
        }
        if (result.text!=""){
            toCalculate.text=result.text
            result.text=""
        }
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