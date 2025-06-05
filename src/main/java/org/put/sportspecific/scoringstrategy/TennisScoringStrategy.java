package org.put.sportspecific.scoringstrategy;

import org.put.common.match.SportScoringStrategy;
import org.put.common.events.Event;
import org.put.common.events.ScoringEvent;

/**
 * In tennis, we assume each ScoringEvent represents the end of a set and carries
 * a fully up-to-date Result (with “sets won” for each player).
 * We simply return whatever set‐count is in the embedded Result.
 */
public class TennisScoringStrategy implements SportScoringStrategy {

    @Override
    public int increaseScore(int baseScore, Event event) {
        if (event instanceof ScoringEvent) {
            ScoringEvent scoring = (ScoringEvent) event;
            Integer updatedSets = scoring.getResult()
                                         .getScores()
                                         .get(scoring.getContestant());
            return (updatedSets != null) ? updatedSets : baseScore;
        }
        return baseScore;
    }
}
