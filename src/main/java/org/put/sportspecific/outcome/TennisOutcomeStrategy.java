package org.put.sportspecific.outcome;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.put.common.contestant.Contestant;
import org.put.common.match.OutcomeStrategy;
import org.put.common.match.Result;

/**
 * In tennis, the player with more sets won is the winner.
 * A tie in sets would mean incomplete or invalid score—return null.
 */
public class TennisOutcomeStrategy implements OutcomeStrategy {

    @Override
    public Contestant decideOutcome(Result result) {
        Map<Contestant, Integer> scoreMap = result.getScores();
        if (scoreMap.size() != 2) {
            throw new IllegalStateException(
                "TennisOutcome requires exactly 2 contestants in the result."
            );
        }

        // First key = home, second key = away
        List<Contestant> contestants = new ArrayList<>(scoreMap.keySet());
        Contestant home = contestants.get(0);
        Contestant away = contestants.get(1);

        int homeSets = scoreMap.getOrDefault(home, 0);
        int awaySets = scoreMap.getOrDefault(away, 0);

        if (homeSets > awaySets) {
            return home;
        } else if (awaySets > homeSets) {
            return away;
        } else {
            return null; // tie - means match not finished)
        }
    }
}
