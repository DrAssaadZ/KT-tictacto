package com.assaad.tictactoekt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buSelect(view:View){
        val btnChoice = view as Button
        var celId = 0
        when(btnChoice.id) {
            R.id.bu1 -> celId = 1
            R.id.bu2 -> celId = 2
            R.id.bu3 -> celId = 3
            R.id.bu4 -> celId = 4
            R.id.bu5 -> celId = 5
            R.id.bu6 -> celId = 6
            R.id.bu7 -> celId = 7
            R.id.bu8 -> celId = 8
            R.id.bu9 -> celId = 9
        }
        playGame(celId,btnChoice)

    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun playGame(celId: Int, buChoice: Button){

        if(activePlayer == 1){
            buChoice.text = "X"
            buChoice.setBackgroundResource(R.color.blue)
            player1.add(celId)
            activePlayer = 2
            autoPlay()
        }else{
            buChoice.text = "O"
            buChoice.setBackgroundResource(R.color.green)
            player2.add(celId)
            activePlayer = 1
        }
        buChoice.isEnabled = false
        checkWinner()
    }

    fun checkWinner(){
        var winner = -1

        //row1
        if(player1.contains(1)&& player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1)&& player2.contains(2) && player2.contains(3)){
            winner = 2
        }

        //row2
        if(player1.contains(4)&& player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4)&& player2.contains(5) && player2.contains(6)){
            winner = 2
        }

        //row1
        if(player1.contains(7)&& player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7)&& player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        //col1
        if(player1.contains(1)&& player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1)&& player2.contains(4) && player2.contains(7)){
            winner = 2
        }

        //col2
        if(player1.contains(2)&& player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2)&& player2.contains(5) && player2.contains(8)){
            winner = 2
        }

        //col3
        if(player1.contains(3)&& player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3)&& player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        //rec1
        if(player1.contains(1)&& player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(1)&& player2.contains(5) && player2.contains(9)){
            winner = 2
        }

        //rec 2
        if(player1.contains(3)&& player1.contains(5) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(3)&& player2.contains(5) && player2.contains(7)){
            winner = 2
        }

        if( winner != -1){
            if(winner == 1){
                Toast.makeText(this,"Player 1 Wins!!",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Player 2 Wins!!",Toast.LENGTH_LONG).show()
            }
        }

    }

    fun autoPlay(){
        var emptyCells = ArrayList <Int>()
        for (celId in 1.. 9){
            if(!(player1.contains(celId) || player2.contains(celId))){
                emptyCells.add(celId)
            }
        }
        val ranIndex = Random().nextInt(emptyCells.size-0)+0
        val celId = emptyCells[ranIndex]
        var buSelect : Button
        when(celId){
            1 -> buSelect = bu1
            2 -> buSelect = bu2
            3 -> buSelect = bu3
            4 -> buSelect = bu4
            5 -> buSelect = bu5
            6 -> buSelect = bu6
            7 -> buSelect = bu7
            8 -> buSelect = bu8
            9 -> buSelect = bu9
            else ->{
                buSelect = bu1
            }
        }

        playGame(celId,buSelect)
    }

}
