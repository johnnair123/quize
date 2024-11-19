package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView resultTextView;
    private Button backButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Initialize views
        resultTextView = findViewById(R.id.resultTextView);
        backButton = findViewById(R.id.backButton);

        // Get the result from the intent
        Intent intent = getIntent();
        boolean isCorrect = intent.getBooleanExtra("isCorrect", false);

        // Set the result message
        if (isCorrect) {
            resultTextView.setText("Correct! Paris is the capital of France.");
        } else {
            resultTextView.setText("Incorrect! Try again.");
        }

        // Go back to MainActivity when "Back to Quiz" is clicked
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(backIntent);
                finish();
            }
        });
    }
}
