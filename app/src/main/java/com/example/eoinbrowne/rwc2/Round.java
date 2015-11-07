package com.example.eoinbrowne.rwc2;

import java.util.ArrayList;

/**
 * Created by EoinBrowne on 07/11/15.
 */
public class Round {

    private ArrayList<Match> theMatches;

    public Round() {
        this.theMatches = new ArrayList<>();
    }

    public void addMatch(Match aMatch) {
        this.theMatches.add(aMatch);
    }

    public ArrayList<Team> playMatchesForRound() {
        ArrayList<Team> winners = new ArrayList<Team>();

        for (Match aMatch : theMatches) {
            winners.add(aMatch.chooseAWinner());
        }
        return winners;

    }
}
