package org.put.sportspecific.scoringstrategy;

import org.put.common.events.Event;
import org.put.common.events.ScoringEvent;
import org.put.common.match.SportScoringStrategy;

/**
 * In basketball, each ScoringEvent already carries the updated Result (with cumulative points).
 * We simply extract the home/away point-total from that Result for the given contestant.
 */
public class BasketballScoringStrategy implements SportScoringStrategy {

    @Override
    public int increaseScore(int baseScore, Event event) {
        if (event instanceof ScoringEvent) {
            ScoringEvent scoring = (ScoringEvent) event;
            // Get the map of scores from the embedded Result:
            Integer updated = scoring.getResult()
                                     .getScores()
                                     .get(scoring.getContestant());
            // If for some reason the map has no entry, fall back to baseScore:
            return (updated != null) ? updated : baseScore;
        }
        // If it’s not a ScoringEvent, don’t change anything:
        return baseScore;
    }
}
