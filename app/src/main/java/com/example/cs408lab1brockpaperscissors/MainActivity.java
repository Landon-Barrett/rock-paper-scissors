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
    private int playerScore = 0;
    private int computerScore = 0;
    private String winMessage = " ";

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
                runGame(playerWeapon);
            }
        });

        binding.paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerWeapon = Weapon.PAPER;
                runGame(playerWeapon);
            }
        });

        binding.scissorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerWeapon = Weapon.SCISSORS;
                runGame(playerWeapon);
            }
        });

    }

    public void runGame(Weapon playerWeapon) {

        String playerWeaponString = " ";
        String computerWeaponString = " ";
        String playerWins = getResources().getString(R.string.player_win);
        String computerWins = getResources().getString(R.string.computer_win);

        Random rand = new Random();
        int randInt = rand.nextInt(Weapon.values().length);
        Weapon computerWeapon = Weapon.values()[randInt];

        if((playerWeapon.equals(Weapon.ROCK)) && (computerWeapon.equals(Weapon.SCISSORS))) {

            playerWeaponString = getPlayerWeaponResource(playerWeapon);
            computerWeaponString = getComputerWeaponResource(computerWeapon);
            playerScore += 1;
            winMessage = (playerWins + " " + getResources().getString(R.string.rock_win_message));
        }

        else if((playerWeapon.equals(Weapon.SCISSORS)) && (computerWeapon.equals(Weapon.ROCK))) {

            playerWeaponString = getPlayerWeaponResource(playerWeapon);
            computerWeaponString = getComputerWeaponResource(computerWeapon);
            computerScore += 1;
            winMessage = (computerWins + " " + getResources().getString(R.string.rock_win_message));
        }
        else if((playerWeapon.equals(Weapon.PAPER)) && (computerWeapon.equals(Weapon.ROCK))) {

            playerWeaponString = getPlayerWeaponResource(playerWeapon);
            computerWeaponString = getComputerWeaponResource(computerWeapon);
            playerScore +=1;
            winMessage = (playerWins + " " + getResources().getString(R.string.paper_win_message));
        }
        else if((playerWeapon.equals(Weapon.ROCK)) && (computerWeapon.equals(Weapon.PAPER))) {

            playerWeaponString = getPlayerWeaponResource(playerWeapon);
            computerWeaponString = getComputerWeaponResource(computerWeapon);
            computerScore += 1;
            winMessage = (computerWins + " " + getResources().getString(R.string.paper_win_message));
        }
        else if((playerWeapon.equals(Weapon.SCISSORS)) && (computerWeapon.equals(Weapon.PAPER))) {

            playerWeaponString = getPlayerWeaponResource(playerWeapon);
            computerWeaponString = getComputerWeaponResource(computerWeapon);
            playerScore += 1;
            winMessage = (playerWins + " " + getResources().getString(R.string.scissor_win_message));
        }
        else if((playerWeapon.equals(Weapon.PAPER)) && (computerWeapon.equals(Weapon.SCISSORS))) {

            playerWeaponString = getPlayerWeaponResource(playerWeapon);
            computerWeaponString = getComputerWeaponResource(computerWeapon);
            computerScore += 1;
            winMessage = (computerWins + " " + getResources().getString(R.string.scissor_win_message));
        }
        else if(playerWeapon.equals(computerWeapon)){

            playerWeaponString = getPlayerWeaponResource(playerWeapon);
            computerWeaponString = getComputerWeaponResource(computerWeapon);
            winMessage = getResources().getString(R.string.tie);
        }

        StringBuilder s = new StringBuilder();
        s.append(getResources().getString(R.string.player_id)).append(" ").append(playerScore).append(" ")
                .append(getResources().getString(R.string.computer_id)).append(" ").append(computerScore)
                .append("\n")
                .append(getResources().getString(R.string.player_weapon)).append(" ").append(playerWeaponString)
                .append("\n")
                .append(getResources().getString(R.string.computer_weapon)).append(" ").append(computerWeaponString)
                .append("\n").append(winMessage);

        TextView t = binding.output;
        t.setText(s.toString());

    }
    public String getPlayerWeaponResource(Weapon p) {

        String playerWeaponString = " ";

        if(p.equals(Weapon.ROCK)) {
            playerWeaponString = getResources().getString(R.string.rock);
        }
        else if(p.equals(Weapon.PAPER)) {
            playerWeaponString = getResources().getString(R.string.paper);
        }
        else if(p.equals(Weapon.SCISSORS)) {
            playerWeaponString = getResources().getString(R.string.scissors);
        }

        return playerWeaponString;
    }

    public String getComputerWeaponResource(Weapon c) {

        String computerWeaponString = " ";

        if(c.equals(Weapon.ROCK)) {
            computerWeaponString = getResources().getString(R.string.rock);
        }
        else if(c.equals(Weapon.PAPER)) {
            computerWeaponString = getResources().getString(R.string.paper);
        }
        else if(c.equals(Weapon.SCISSORS)) {
            computerWeaponString = getResources().getString(R.string.scissors);
        }

        return computerWeaponString;
    }

}