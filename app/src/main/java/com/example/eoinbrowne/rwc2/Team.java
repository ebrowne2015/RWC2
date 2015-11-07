package com.example.eoinbrowne.rwc2;

/**
 * Created by EoinBrowne on 07/11/15.
 */
public enum Team {


    IRELAND("IRE", -16711936),
    SCOTLAND("SCO", -7829368),
    AUSTRALIA("AUS", -256),
    NEW_ZEALAND("NZL", -16777216),
    WALES("WAL", -65536),
    SOUTH_AFRICA("ZAF", -65281),
    ARGENTINA("ARG", -16711681),
    FRANCE("FRA", -16776961);

    private String teamName;
    private int teamColor;

    private Team(String teamName, int teamColor) {
        this.teamName = teamName;
        this.teamColor = teamColor;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {

        this.teamName = teamName;
    }

    public int getTeamColor() {
        return teamColor;
    }
}
