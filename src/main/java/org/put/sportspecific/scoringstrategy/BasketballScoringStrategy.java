package org.put.sportspecific.scoringstrategy;

import org.put.common.events.Event;
import org.put.common.match.SportScoringStrategy;

public class BasketballScoringStrategy implements SportScoringStrategy {

    public BasketballScoringStrategy() {
    }

    /**
     * Increases the score based on the event type and other parameters.
     *
     * @param baseScore The base score to be increased.
     * @param event The event that triggered the score increase.
     * @return The new score after applying the scoring strategy.
     */
    @Override
    public int increaseScore(int baseScore, Event event) {
        return 0;
    }

}
