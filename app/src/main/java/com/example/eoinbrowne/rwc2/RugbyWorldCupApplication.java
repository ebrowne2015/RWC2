package com.example.eoinbrowne.rwc2;

/**
 * Created by Eoin Browne on 10/22/15.
 * Comp8021 Mobile App development
 * Student ID: R00064165
 * Assignment 1
 */


//IMPORT STATEMENTS
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;




// Rugby world cup application that extends Textwatcher

public class RugbyWorldCupApplication extends AppCompatActivity implements TextWatcher {

    private ArrayList<TextView> qrtCupTeams;
    private ArrayList<EditText> semiCupTeams;
    private ArrayList<EditText> finalCupTeams;
    private long getSystemTimeMillisStart = 0;
    private long getSystemTimeMillisEnd = 0;
    private Activity activity;
    EditText myText;


    // onCreate(bundle savedinstanceState) is used to preserve state
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Arraylsit declaration
        qrtCupTeams = new ArrayList<TextView>();
        semiCupTeams = new ArrayList<EditText>();
        finalCupTeams = new ArrayList<EditText>();


        // methods to the reference of teh editText
        qtrcupTeamEdittextReference();
        semicupTeamEdittextReference();
        finalcupTeamEdittextReference();

        // Looking up and referencing the EditTextFields in Android Studio
        EditText s1 = (EditText) findViewById(R.id.Semi1);
        EditText s2 = (EditText) findViewById(R.id.Semi2);
        EditText s3 = (EditText) findViewById(R.id.Semi3);
        EditText s4 = (EditText) findViewById(R.id.Semi4);

        EditText f1 = (EditText) findViewById(R.id.Final1);
        EditText f2 = (EditText) findViewById(R.id.Final2);


        // Adding a text change listener to the editviews
        s1.addTextChangedListener(this);
        s2.addTextChangedListener(this);
        s3.addTextChangedListener(this);
        s4.addTextChangedListener(this);

        f1.addTextChangedListener(this);
        f2.addTextChangedListener(this);


        Button luckyDipButton = (Button) super.findViewById(R.id.LuckyDipButton);
        Button resetButton = (Button) super.findViewById(R.id.ResetButton);

        // Setting teh onclick listener to the Buttons
        luckyDipButton.setOnClickListener(new ButtonListener(this));
        resetButton.setOnClickListener(new ButtonListener(this));

        // Setting up the quarters final to start on application start up
        TextView quart1 = (TextView) findViewById(R.id.qtr1);
        TextView quart2 = (TextView) findViewById(R.id.qtr2);
        TextView quart3 = (TextView) findViewById(R.id.qtr3);
        TextView quart4 = (TextView) findViewById(R.id.qtr4);
        TextView quart5 = (TextView) findViewById(R.id.qtr5);
        TextView quart6 = (TextView) findViewById(R.id.qtr6);
        TextView quart7 = (TextView) findViewById(R.id.qtr7);
        TextView quart8 = (TextView) findViewById(R.id.qtr8);

        //setting teh teamName
        quart1.setText(Team.SOUTH_AFRICA.getTeamName());
        quart2.setText(Team.WALES.getTeamName());
        quart3.setText(Team.NEW_ZEALAND.getTeamName());
        quart4.setText(Team.FRANCE.getTeamName());
        quart5.setText(Team.IRELAND.getTeamName());
        quart6.setText(Team.ARGENTINA.getTeamName());
        quart7.setText(Team.SCOTLAND.getTeamName());
        quart8.setText(Team.AUSTRALIA.getTeamName());

        //Setting teh Team Colour
        quart1.setTextColor(Team.SOUTH_AFRICA.getTeamColor());
        quart2.setTextColor(Team.WALES.getTeamColor());
        quart3.setTextColor(Team.NEW_ZEALAND.getTeamColor());
        quart4.setTextColor(Team.FRANCE.getTeamColor());
        quart5.setTextColor(Team.IRELAND.getTeamColor());
        quart6.setTextColor(Team.ARGENTINA.getTeamColor());
        quart7.setTextColor(Team.SCOTLAND.getTeamColor());
        quart8.setTextColor(Team.AUSTRALIA.getTeamColor());


    }

    // saving the application State when put in the background
    @Override
    public void onSaveInstanceState(Bundle b) {

        getSystemTimeMillisStart = System.currentTimeMillis();
        String sleep_Start_Time = Long.toString(getSystemTimeMillisStart);

        b.putCharSequence(sleep_Start_Time, "Start Sleep Time");
        super.onSaveInstanceState(b);

    }

    // Restoring the application state
    @Override
    protected void onRestoreInstanceState(Bundle b) {

        getSystemTimeMillisEnd = System.currentTimeMillis();

        String difference = Long.toString((getSystemTimeMillisEnd - getSystemTimeMillisStart) / 1000 % 60);
        b.putCharSequence(difference, "Sleep Time Duration");
        Toast.makeText(this, "Sleep Time Duration " + difference + "seconds", Toast.LENGTH_LONG).show();


        super.onSaveInstanceState(b);


    }


    // storing a reference to the quarter final textviews
    private void qtrcupTeamEdittextReference() {
        qrtCupTeams.add((TextView) findViewById(R.id.qtr1));
        qrtCupTeams.add((TextView) findViewById(R.id.qtr2));
        qrtCupTeams.add((TextView) findViewById(R.id.qtr3));
        qrtCupTeams.add((TextView) findViewById(R.id.qtr4));
        qrtCupTeams.add((TextView) findViewById(R.id.qtr5));
        qrtCupTeams.add((TextView) findViewById(R.id.qtr6));
        qrtCupTeams.add((TextView) findViewById(R.id.qtr7));
        qrtCupTeams.add((TextView) findViewById(R.id.qtr8));


    }

    // storing a reference to the semi final Edittext
    private void semicupTeamEdittextReference() {

        semiCupTeams.add((EditText) findViewById(R.id.Semi1));
        semiCupTeams.add((EditText) findViewById(R.id.Semi2));
        semiCupTeams.add((EditText) findViewById(R.id.Semi3));
        semiCupTeams.add((EditText) findViewById(R.id.Semi4));

    }


    // storing a reference to the final Edittext
    private void finalcupTeamEdittextReference() {

        finalCupTeams.add((EditText) findViewById(R.id.Final1));
        finalCupTeams.add((EditText) findViewById(R.id.Final2));

    }


    // On Text Change Methods when textwatcher is implemented
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        //arraylist of strings storing data for duplication check
        ArrayList<String> rawStringfromSemi = new ArrayList<String>();
        ArrayList<String> rawStringfromFinal = new ArrayList<String>();

        TextView qrt1 = (TextView) findViewById(R.id.qtr1);
        TextView qrt2 = (TextView) findViewById(R.id.qtr2);
        TextView qrt3 = (TextView) findViewById(R.id.qtr3);
        TextView qrt4 = (TextView) findViewById(R.id.qtr4);
        TextView qrt5 = (TextView) findViewById(R.id.qtr5);
        TextView qrt6 = (TextView) findViewById(R.id.qtr6);
        TextView qrt7 = (TextView) findViewById(R.id.qtr7);
        TextView qrt8 = (TextView) findViewById(R.id.qtr8);

        EditText e1 = (EditText) this.findViewById(R.id.Semi1);
        EditText e2 = (EditText) this.findViewById(R.id.Semi2);
        EditText e3 = (EditText) this.findViewById(R.id.Semi3);
        EditText e4 = (EditText) this.findViewById(R.id.Semi4);

        EditText ff1 = (EditText) this.findViewById(R.id.Final1);
        EditText ff2 = (EditText) this.findViewById(R.id.Final2);

        EditText WC1 = (EditText) this.findViewById(R.id.Winner1);


        rawStringfromSemi.add(e1.getText().toString());
        rawStringfromSemi.add(e2.getText().toString());
        rawStringfromSemi.add(e3.getText().toString());
        rawStringfromSemi.add(e4.getText().toString());

        rawStringfromFinal.add(ff1.getText().toString());
        rawStringfromFinal.add(ff2.getText().toString());


        // try Catch statment to run the textwatcher
        try {

                if (e1.getText().toString().equals(qrt1.getText().toString()))
                {

                    e1.setTextColor(Team.SOUTH_AFRICA.getTeamColor());

                }
                else if (e1.getText().toString().equals(qrt2.getText().toString())) {
                    e1.setTextColor(Team.WALES.getTeamColor());
                }

                if (e2.getText().toString().equals(qrt3.getText().toString())) {
                    e2.setTextColor(Team.NEW_ZEALAND.getTeamColor());

                }
                else if (e2.getText().toString().equals(qrt4.getText().toString()))
                {
                    e2.setTextColor(Team.FRANCE.getTeamColor());
                }

                if (e3.getText().toString().equals(qrt5.getText().toString())) {
                    e3.setTextColor(Team.IRELAND.getTeamColor());

                }
                else if (e3.getText().toString().equals(qrt6.getText().toString()))
                {
                    e3.setTextColor(Team.ARGENTINA.getTeamColor());
                }
                if (e4.getText().toString().equals(qrt7.getText().toString()))
                {
                    e4.setTextColor(Team.SCOTLAND.getTeamColor());

                }
                else if (e4.getText().toString().equals(qrt8.getText().toString()))
                {
                    e4.setTextColor(Team.AUSTRALIA.getTeamColor());
                }


            if(ff1.getText().toString().equals(rawStringfromSemi.get(0).toString()))
                {
                    ff1.setTextColor(Team.SOUTH_AFRICA.getTeamColor());
                } else if(ff1.getText().toString().equals(rawStringfromSemi.get(0).toString()))
                {
                    ff1.setTextColor(Team.WALES.getTeamColor());
                }
                if(ff1.getText().toString().equals(rawStringfromSemi.get(1).toString()))
                {
                    ff1.setTextColor(Team.NEW_ZEALAND.getTeamColor());
                }
                else if(ff1.getText().toString().equals(rawStringfromSemi.get(1).toString()))
                {
                    ff1.setTextColor(Team.FRANCE.getTeamColor());
                }

                if(ff2.getText().toString().equals(rawStringfromSemi.get(2).toString()))
                {
                    ff2.setTextColor(Team.IRELAND.getTeamColor());
                }
                else if(ff2.getText().toString().equals(rawStringfromSemi.get(2).toString()))
                {
                    ff2.setTextColor(Team.ARGENTINA.getTeamColor());
                }
                if(ff2.getText().toString().equals(rawStringfromSemi.get(3).toString()))
                {
                    ff2.setTextColor(Team.SCOTLAND.getTeamColor());
                }
                else if(ff2.getText().toString().equals(rawStringfromSemi.get(3).toString()))
                {
                    ff2.setTextColor(Team.AUSTRALIA.getTeamColor());
                }

                if(WC1.getText().toString().equals(rawStringfromFinal.get(0)))
                {
                    WC1.setTextColor(Team.SOUTH_AFRICA.getTeamColor());
                }
                else if(WC1.getText().toString().equals(rawStringfromFinal.get(0).toString()))
                {
                    WC1.setTextColor(Team.WALES.getTeamColor());
                }
                if(WC1.getText().toString().equals(rawStringfromFinal.get(0).toString()))
                {
                    WC1.setTextColor(Team.NEW_ZEALAND.getTeamColor());
                }
                else if(WC1.getText().toString().equals(rawStringfromFinal.get(0).toString()))
                {
                    WC1.setTextColor(Team.FRANCE.getTeamColor());
                }

                else
                {
                    Toast.makeText(this, "Error: Please choose from preceeding game", Toast.LENGTH_LONG).show();
                }




        }
        catch (Exception e){}



    }
}










