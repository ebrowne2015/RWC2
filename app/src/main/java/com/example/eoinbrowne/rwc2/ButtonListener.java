package com.example.eoinbrowne.rwc2;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by EoinBrowne on 07/11/15.
 */
public class ButtonListener implements View.OnClickListener {

    private Activity activity;

    public ButtonListener(Activity activity) {
        this.activity = activity;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {


            case R.id.LuckyDipButton:

                Round winner = new Round();


                Round quarterFinals = new Round();

                Match m1 = new Match(Team.SOUTH_AFRICA, Team.WALES);
                Match m2 = new Match(Team.NEW_ZEALAND, Team.FRANCE);
                Match m3 = new Match(Team.IRELAND, Team.ARGENTINA);
                Match m4 = new Match(Team.SCOTLAND, Team.AUSTRALIA);


                quarterFinals.addMatch(m1);
                quarterFinals.addMatch(m2);
                quarterFinals.addMatch(m3);
                quarterFinals.addMatch(m4);

                ArrayList<Team> winners = quarterFinals.playMatchesForRound();

                EditText s1 = (EditText) this.activity.findViewById(R.id.Semi1);
                EditText s2 = (EditText) this.activity.findViewById(R.id.Semi2);
                EditText s3 = (EditText) this.activity.findViewById(R.id.Semi3);
                EditText s4 = (EditText) this.activity.findViewById(R.id.Semi4);

                s1.setText(winners.get(0).getTeamName());
                s2.setText(winners.get(1).getTeamName());
                s3.setText(winners.get(2).getTeamName());
                s4.setText(winners.get(3).getTeamName());

                s1.setTextColor(winners.get(0).getTeamColor());
                s2.setTextColor(winners.get(1).getTeamColor());
                s3.setTextColor(winners.get(2).getTeamColor());
                s4.setTextColor(winners.get(3).getTeamColor());

                Round semis = new Round();

                Match semi1 = new Match(winners.get(0), winners.get(1));
                Match semi2 = new Match(winners.get(2), winners.get(3));

                semis.addMatch(semi1);
                semis.addMatch(semi2);

                ArrayList<Team> semiWinners = semis.playMatchesForRound();

                EditText f1 = (EditText) this.activity.findViewById(R.id.Final1);
                EditText f2 = (EditText) this.activity.findViewById(R.id.Final2);

                f1.setText(semiWinners.get(0).getTeamName());
                f2.setText(semiWinners.get(1).getTeamName());


                f1.setTextColor(semiWinners.get(0).getTeamColor());
                f2.setTextColor(semiWinners.get(1).getTeamColor());

                Round wcc = new Round();

                Match wcc1 = new Match(semiWinners.get(0), semiWinners.get(1));

                wcc.addMatch(wcc1);

                ArrayList<Team> TheFinal = wcc.playMatchesForRound();

                EditText w1 = (EditText) this.activity.findViewById(R.id.Winner1);

                w1.setText(TheFinal.get(0).getTeamName());
                w1.setTextColor(TheFinal.get(0).getTeamColor());

                break;

            case R.id.ResetButton:

                //clear all fields
                EditText cf1 = (EditText) this.activity.findViewById(R.id.Semi1);
                EditText cf2 = (EditText) this.activity.findViewById(R.id.Semi2);
                EditText cf3 = (EditText) this.activity.findViewById(R.id.Semi3);
                EditText cf4 = (EditText) this.activity.findViewById(R.id.Semi4);
                EditText cf5 = (EditText) this.activity.findViewById(R.id.Final1);
                EditText cf6 = (EditText) this.activity.findViewById(R.id.Final2);
                EditText cf7 = (EditText) this.activity.findViewById(R.id.Winner1);

                cf1.setText("");
                cf2.setText("");
                cf3.setText("");
                cf4.setText("");
                cf5.setText("");
                cf6.setText("");
                cf7.setText("");

                break;

            default:
                break;


        }
    }
}
