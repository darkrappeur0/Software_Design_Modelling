package org.put.common.contestant;

import java.util.ArrayList;
import java.util.List;

public class Team extends Contestant {
    private final List<TeamPlayer> teamPlayers;

    public Team(String name, String sportType, String country) {
        super(name, sportType, country);
        this.teamPlayers = new ArrayList<>();
    }

    public List<TeamPlayer> getTeamPlayers() {
        return teamPlayers;
    }

    public void addTeamPlayer(TeamPlayer player) {
        teamPlayers.add(player);
    }

    public boolean removeTeamPlayer(TeamPlayer player) {
        return teamPlayers.remove(player);
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + getName() + '\'' +
                ", sportType='" + getSportType() + '\'' +
                ", country='" + getCountry() + '\'' +
                ", teamPlayers=" + teamPlayers +
                '}';
    }
}