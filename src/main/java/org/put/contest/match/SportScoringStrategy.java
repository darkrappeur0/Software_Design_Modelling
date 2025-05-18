package org.put.contest.match;

import org.put.contest.events.Event;

public interface SportScoringStrategy {

    /**
     * Increases the score based on the event type and other parameters.
     *
     * @param baseScore The base score to be increased.
     * @param event The event that triggered the score increase.
     * @return The new score after applying the scoring strategy.
     */
    int increaseScore(int baseScore, Event event);

}
