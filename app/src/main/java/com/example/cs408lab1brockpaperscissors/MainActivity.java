package com.example.cs408lab1brockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cs408lab1brockpaperscissors.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView t = binding.output;
                t.setText("test1");
            }
        });

        binding.paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView t = binding.output;
                t.setText("test2");
            }
        });

        binding.scissorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView t = binding.output;
                t.setText("test4");
            }
        });
    }

}