package com.adjarabet.myapplication

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var button1 : Button
    lateinit var button2 : Button
    lateinit var button3 : Button
    lateinit var button4 : Button
    lateinit var button5 : Button
    lateinit var button6 : Button
    lateinit var button7 : Button
    lateinit var button8 : Button
    lateinit var button9 : Button

    lateinit var resetButton: Button

    var firstPlayer = ArrayList<Int>()
    var secondPlayer = ArrayList<Int>()

    var activePlayer = 1

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun init(){
        resetButton = findViewById(R.id.resetButton)
        resetButton.setOnClickListener {
            restartGame()
        }



        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)

//        resetButton = findViewById(R.id.resetButton)
//        resetButton.setOnClickListener {
//            val resActivity = Intent(this, MainActivity::class.java)
//            onRestart()
//            startActivity(resActivity)
//        }





        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)


    }

    private fun check(){
        var winner = 0
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3) || firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6) ||
            firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9) || firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7) ||
            firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8) || firstPlayer.contains(3)&& firstPlayer.contains(6) && firstPlayer.contains(9) ||
            firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9) || firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)){
            winner = 1
        }else if(secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3) || secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6) ||
                 secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9) || secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7) ||
                 secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8) || secondPlayer.contains(3)&& secondPlayer.contains(6) && secondPlayer.contains(9) ||
                 secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9) || secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)){
            winner = 2
        }else{
            winner = 3
        }


        if (winner == 1) {
            Toast.makeText(this, "first player won", Toast.LENGTH_SHORT).show()
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false

        } else if (winner == 2){
            Toast.makeText(this, "second player won", Toast.LENGTH_SHORT).show()
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        } else if(winner == 3 && firstPlayer.size > 3 && secondPlayer.size > 3 ){
            Toast.makeText(this, "Draw", Toast.LENGTH_LONG).show()
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
        }
    }



    fun playGame(view: Button, buttonNumber: Int){
        if (activePlayer == 1){
            view.text = "X"
            view.setBackgroundColor(Color.RED)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
        } else if (activePlayer == 2){
            view.text = "O"
            view.setBackgroundColor(Color.GRAY)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
        }
        view.isEnabled = false
        check()
    }



    @RequiresApi(Build.VERSION_CODES.M)
    fun restartGame(){
        button1.text = "Button"
        button2.text = "Button"
        button3.text = "Button"
        button4.text = "Button"
        button5.text = "Button"
        button6.text = "Button"
        button7.text = "Button"
        button8.text = "Button"
        button9.text = "Button"


        button1.setBackgroundColor(Color.BLUE)
        button2.setBackgroundColor(Color.BLUE)
        button3.setBackgroundColor(Color.BLUE)
        button4.setBackgroundColor(Color.BLUE)
        button5.setBackgroundColor(Color.BLUE)
        button6.setBackgroundColor(Color.BLUE)
        button7.setBackgroundColor(Color.BLUE)
        button8.setBackgroundColor(Color.BLUE)
        button9.setBackgroundColor(Color.BLUE)


        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true

        firstPlayer.clear()
        secondPlayer.clear()



    }




    override fun onClick(clickedView: View?) {
        if (clickedView is Button){
            var buttonNumber = 0
            when(clickedView.id){
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }
            if (buttonNumber != 0){
                playGame(clickedView, buttonNumber)
            }

        }
    }


}