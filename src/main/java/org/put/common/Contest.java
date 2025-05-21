package org.put.common;

import org.put.common.match.Match;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contest {

    private final String name;
    private final List<Match> matches;

    public Contest(String name) {
        this.name = name;
        this.matches = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Match> getMatches() {
        return Collections.unmodifiableList(matches);
    }


    public void addMatch(Match match) {
        matches.add(match);
    }
}