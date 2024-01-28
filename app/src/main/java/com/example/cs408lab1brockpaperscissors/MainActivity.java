package com.example.cs408lab1brockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cs408lab1brockpaperscissors.databinding.ActivityMainBinding;

import java.util.Enumeration;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Weapon playerWeapon;
    private Weapon computerWeapon;
    private int playerScore;
    private int computerScore = 0;
    private boolean playerWins = false;
    private boolean computerWins = false;
    private Random rand = new Random();
    private int randInt;
    private String winMessage;
    private String score;
    private StringBuilder s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerWeapon = Weapon.ROCK;
                randInt = rand.nextInt(Weapon.values().length);
                computerWeapon = Weapon.values()[randInt];

                if(computerWeapon.equals(Weapon.SCISSORS)) {
                    playerScore += 1;
                    playerWins = true;
                    computerWins = false;
                    winMessage = "Rock crushes scissors!";

                }
                else if(computerWeapon.equals(Weapon.PAPER)) {
                    computerScore += 1;
                    computerWins = true;
                    playerWins = false;
                    winMessage = "Paper covers rock!";
                }
                else {
                    computerWins = false;
                    playerWins = false;
                    winMessage = "It's a tie!";
                }

                if(playerWins){
                    winMessage = ("Player wins: " + winMessage);
                }
                else if(computerWins){
                    winMessage = ("Computer wins: " + winMessage);
                }

                score = ("Player: " + playerScore + ", Computer: " + computerScore);
                s = new StringBuilder();
                s.append("Player: ").append(playerScore).append(", Computer: ").append(computerScore)
                        .append("\n").append("Player's Weapon: ").append(playerWeapon.toString())
                        .append("\n").append("Computer's Weapon: ").append(computerWeapon.toString())
                        .append("\n").append(winMessage);
                TextView t = binding.output;
                t.setText(s.toString());

            }
        });

        binding.paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerWeapon = Weapon.PAPER;
                randInt = rand.nextInt(Weapon.values().length);
                computerWeapon = Weapon.values()[randInt];

                if(computerWeapon.equals(Weapon.ROCK)) {
                    playerScore += 1;
                    playerWins = true;
                    computerWins = false;
                    winMessage = "Paper covers rock!";
                }
                else if (computerWeapon.equals(Weapon.SCISSORS)) {
                    computerScore += 1;
                    computerWins = true;
                    playerWins = false;
                    winMessage = "Scissors cut paper!";
                }
                else {
                    computerWins = false;
                    playerWins = false;
                    winMessage = "It's a tie!";

                }
                if(playerWins){
                    winMessage = ("Player wins: " + winMessage);
                }
                else if(computerWins){
                    winMessage = ("Computer wins: " + winMessage);
                }
                s = new StringBuilder();
                s.append("Player: ").append(playerScore).append(", Computer: ").append(computerScore)
                        .append("\n").append("Player's Weapon: ").append(playerWeapon.toString())
                        .append("\n").append("Computer's Weapon: ").append(computerWeapon.toString())
                        .append("\n").append(winMessage);
                TextView t = binding.output;
                t.setText(s.toString());
            }
        });

        binding.scissorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerWeapon = Weapon.SCISSORS;
                randInt = rand.nextInt(Weapon.values().length);
                computerWeapon = Weapon.values()[randInt];

                if(computerWeapon.equals(Weapon.PAPER)) {
                    playerScore += 1;
                    playerWins = true;
                    computerWins = false;
                    winMessage = "Scissors cut paper!";
                }
                else if(computerWeapon.equals(Weapon.ROCK)) {
                    computerScore += 1;
                    computerWins = true;
                    playerWins = false;
                    winMessage = "Rock crushes scissors!";
                }
                else {
                    computerWins = false;
                    playerWins = false;
                    winMessage = "It's a tie!";
                }
                if(playerWins){
                    winMessage = ("Player wins: " + winMessage);
                }
                else if(computerWins){
                    winMessage = ("Computer wins: " + winMessage);
                }
                s = new StringBuilder();
                s.append("Player: ").append(playerScore).append(", Computer: ").append(computerScore)
                        .append("\n").append("Player's Weapon: ").append(playerWeapon.toString())
                        .append("\n").append("Computer's Weapon: ").append(computerWeapon.toString())
                        .append("\n").append(winMessage);
                TextView t = binding.output;
                t.setText(s.toString());
            }
        });

    }

}