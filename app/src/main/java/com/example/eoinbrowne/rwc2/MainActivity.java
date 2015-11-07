package com.example.eoinbrowne.rwc2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private long getSystemTimeMillisStart = 0;
    private long getSystemTimeMillisEnd = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button luckyDipButton = (Button) super.findViewById(R.id.LuckyDipButton);
        Button resetButton = (Button) super.findViewById(R.id.ResetButton);


        luckyDipButton.setOnClickListener(new ButtonListener(this));
        resetButton.setOnClickListener(new ButtonListener(this));


        TextView quart1 = (TextView) findViewById(R.id.qtr1);
        TextView quart2 = (TextView) findViewById(R.id.qtr2);
        TextView quart3 = (TextView) findViewById(R.id.qtr3);
        TextView quart4 = (TextView) findViewById(R.id.qtr4);
        TextView quart5 = (TextView) findViewById(R.id.qtr5);
        TextView quart6 = (TextView) findViewById(R.id.qtr6);
        TextView quart7 = (TextView) findViewById(R.id.qtr7);
        TextView quart8 = (TextView) findViewById(R.id.qtr8);

        quart1.setText(Team.SOUTH_AFRICA.getTeamName());
        quart2.setText(Team.WALES.getTeamName());
        quart3.setText(Team.NEW_ZEALAND.getTeamName());
        quart4.setText(Team.FRANCE.getTeamName());
        quart5.setText(Team.IRELAND.getTeamName());
        quart6.setText(Team.ARGENTINA.getTeamName());
        quart7.setText(Team.SCOTLAND.getTeamName());
        quart8.setText(Team.AUSTRALIA.getTeamName());

        quart1.setTextColor(Team.SOUTH_AFRICA.getTeamColor());
        quart2.setTextColor(Team.WALES.getTeamColor());
        quart3.setTextColor(Team.NEW_ZEALAND.getTeamColor());
        quart4.setTextColor(Team.FRANCE.getTeamColor());
        quart5.setTextColor(Team.IRELAND.getTeamColor());
        quart6.setTextColor(Team.ARGENTINA.getTeamColor());
        quart7.setTextColor(Team.SCOTLAND.getTeamColor());
        quart8.setTextColor(Team.AUSTRALIA.getTeamColor());


    }


    @Override
    public void onSaveInstanceState(Bundle b) {

        getSystemTimeMillisStart = System.currentTimeMillis();
        String sleep_Start_Time = Long.toString(getSystemTimeMillisStart);

        b.putCharSequence(sleep_Start_Time, "Start Sleep Time");
        super.onSaveInstanceState(b);

    }

    @Override
    protected void onRestoreInstanceState(Bundle b) {

        getSystemTimeMillisEnd = System.currentTimeMillis();

        String difference = Long.toString((getSystemTimeMillisEnd - getSystemTimeMillisStart) / 1000 % 60);
        b.putCharSequence(difference, "Sleep Time Duration");
        Toast.makeText(this, "Sleep Time Duration " + difference + "seconds", Toast.LENGTH_LONG).show();


        super.onSaveInstanceState(b);








    }
}
