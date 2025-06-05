package org.put.sportspecific.scoringstrategy;

import org.put.common.match.SportScoringStrategy;
import org.put.common.events.Event;
import org.put.common.events.ScoringEvent;

/**
 * In (soccer) football, each ScoringEvent carries a new Result (with cumulative goals for each side).
 * We simply pick out the updated goal‐count for the event’s contestant.
 */
public class FootballScoringStrategy implements SportScoringStrategy {

    @Override
    public int increaseScore(int baseScore, Event event) {
        if (event instanceof ScoringEvent) {
            ScoringEvent scoring = (ScoringEvent) event;
            Integer updatedGoals = scoring.getResult()
                                          .getScores()
                                          .get(scoring.getContestant());
            return (updatedGoals != null) ? updatedGoals : baseScore;
        }
        return baseScore;
    }
}
