package org.put.sportspecific.outcome;

import org.put.common.contestant.Contestant;
import org.put.common.match.OutcomeStrategy;
import org.put.common.match.Result;

public class FootballOutcomeStrategy implements OutcomeStrategy {

    @Override
    public Contestant decideOutcome(Result result) {
        var scores = result.getScores();
        if (scores.size() != 2) {
            throw new RuntimeException("FootballOutcomeStrategy can only be used for 2 contestants");
        }

        var it = scores.entrySet().iterator();
        var entry1 = it.next();
        var entry2 = it.next();

        var score1 = entry1.getValue();
        var score2 = entry2.getValue();

        if (score1 > score2) {
            return entry1.getKey();
        } else if (score2 > score1) {
            return entry2.getKey();
        } else {
            return null; // Draw
        }
    }
}