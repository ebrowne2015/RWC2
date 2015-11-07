package com.example.eoinbrowne.rwc2;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by EoinBrowne on 07/11/15.
 */
public class WorldCupTextWatcher implements TextWatcher {

    private EditText text;
    private Activity activity;


    private ArrayList<TextView> qrtCupTeams;
    private ArrayList<EditText> semiCupTeams;
    private ArrayList<EditText> finalCupTeams;


    public WorldCupTextWatcher(EditText text)

    {
        this.text = text;
    }

    private void qtrcupTeamEdittextReference() {

        qrtCupTeams.add((TextView) this.activity.findViewById(R.id.qtr1));
        qrtCupTeams.add((TextView) this.activity.findViewById(R.id.qtr2));
        qrtCupTeams.add((TextView) this.activity.findViewById(R.id.qtr3));
        qrtCupTeams.add((TextView) this.activity.findViewById(R.id.qtr4));
        qrtCupTeams.add((TextView) this.activity.findViewById(R.id.qtr5));
        qrtCupTeams.add((TextView) this.activity.findViewById(R.id.qtr6));
        qrtCupTeams.add((TextView) this.activity.findViewById(R.id.qtr7));
        qrtCupTeams.add((TextView) this.activity.findViewById(R.id.qtr8));


    }

    private void semicupTeamEdittextReference() {

        semiCupTeams.add((EditText) this.activity.findViewById(R.id.Semi1));
        semiCupTeams.add((EditText) this.activity.findViewById(R.id.Semi2));
        semiCupTeams.add((EditText) this.activity.findViewById(R.id.Semi3));
        semiCupTeams.add((EditText) this.activity.findViewById(R.id.Semi4));

    }

    private void finalcupTeamEdittextReference() {

        finalCupTeams.add((EditText) this.activity.findViewById(R.id.Final1));
        finalCupTeams.add((EditText) this.activity.findViewById(R.id.Final2));

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable e) {


        ArrayList<String> rawStringValueFromEditTexts = new ArrayList<String>();

//        for (EditText currfield : semiCupTeams) {
//
    }

}


