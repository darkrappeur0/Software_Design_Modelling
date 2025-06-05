package org.put.sportspecific.outcome;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import org.put.common.contestant.Contestant;
import org.put.common.match.OutcomeStrategy;
import org.put.common.match.Result;

/**
 * In basketball, the team with more points wins.
 * If tied, return null (which leads to overtime).
 */
public class BasketballOutcomeStrategy implements OutcomeStrategy {

    @Override
    public Contestant decideOutcome(Result result) {
        Map<Contestant, Integer> scoreMap = result.getScores();
        if (scoreMap.size() != 2) {
            throw new IllegalStateException(
                "BasketballOutcome requires exactly 2 contestants in the result."
            );
        }

        // Pull out home and away by insertion order:
        List<Contestant> contestants = new ArrayList<>(scoreMap.keySet());
        Contestant home = contestants.get(0);
        Contestant away = contestants.get(1);

        int homePoints = scoreMap.getOrDefault(home, 0);
        int awayPoints = scoreMap.getOrDefault(away, 0);

        if (homePoints > awayPoints) {
            return home;
        } else if (awayPoints > homePoints) {
            return away;
        } else {
            return null;  // draw or go to overtime externally
        }
    }
}

