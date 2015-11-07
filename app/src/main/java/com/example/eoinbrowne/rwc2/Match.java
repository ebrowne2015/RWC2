package com.example.eoinbrowne.rwc2;

/**
 * Created by EoinBrowne on 07/11/15.
 */
public class Match {

    private Team teamOne;
    private Team teamTwo;

    private Match preceedingMatch;

    public Match(Team teamOne, Team teamTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
    }

    public Team chooseAWinner() {
        double randomNum = Math.random();
        if (randomNum <= .5) {
            return teamTwo;
        } else {
            return teamOne;
        }
    }

    public boolean isWinnerValid(String name) {
        if (name.equals(teamOne.getTeamName()) || name.equals(teamTwo.getTeamName())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isMatchReaadyToPlay() {
        if (teamOne != null && teamTwo != null) {
            return true;
        } else {
            return false;
        }
    }

}
