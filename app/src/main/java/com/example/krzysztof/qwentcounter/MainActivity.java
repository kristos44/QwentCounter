package com.example.krzysztof.qwentcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fight(View v) {
        int pointsValue = 0;

        EditText firstUnitEditText = findViewById(R.id.first_unit);
        EditText secondUnitEditText = findViewById(R.id.second_unit);
        LinearLayout roundScoresLinearLayout = findViewById(R.id.roundScores);

        int firstUnitPower = Integer.parseInt(firstUnitEditText.getText().toString());
        int secondUnitPower = Integer.parseInt(secondUnitEditText.getText().toString());

        int counter = 1;

        roundScoresLinearLayout.removeAllViews();

        while(firstUnitPower > 0 && secondUnitPower > 0) {
            if(counter % 2 != 0) {
                if(firstUnitPower < secondUnitPower) {
                    pointsValue += firstUnitPower;
                } else {
                    pointsValue += secondUnitPower;
                }
                secondUnitPower -= firstUnitPower;
            } else {
                if(secondUnitPower < firstUnitPower) {
                    pointsValue += secondUnitPower;
                } else {
                    pointsValue += firstUnitPower;
                }
                firstUnitPower -= secondUnitPower;
            }

            TextView roundScore = new TextView(this);
            roundScore.setText("" + (firstUnitPower < 0 ? 0 : firstUnitPower) + " - " + (secondUnitPower < 0 ? 0 : secondUnitPower));
            roundScoresLinearLayout.addView(roundScore);

            counter++;
        }

        TextView scoreTextView = findViewById(R.id.score);
        scoreTextView.setText("" + pointsValue);
    }
}
