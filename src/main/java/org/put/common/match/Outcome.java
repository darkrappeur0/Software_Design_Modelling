package org.put.common.match;

import org.put.common.contestant.Contestant;

import java.util.ArrayList;
import java.util.List;

public class Outcome {
    private final Result result;
    private final OutcomeStrategy strategy;

    public Outcome(Result result, OutcomeStrategy strategy) {
        this.result = result;
        this.strategy = strategy;
    }

    private List<Contestant> getContestants() {
        return new ArrayList<>(result.getScores().keySet());
    }

    public OutcomeType getOutcomeType() {
        var contestants = getContestants();
        if (contestants.size() != 2) {
            throw new IllegalStateException("Outcome requires exactly 2 contestants");
        }
        var contestant1 = contestants.get(0);
        var contestant2 = contestants.get(1);
        var winner = strategy.decideOutcome(result);
        if (winner == null) {
            return OutcomeType.DRAW;
        } else if (winner.equals(contestant1)) {
            return OutcomeType.WINNER_CONTESTANT_1;
        } else if (winner.equals(contestant2)) {
            return OutcomeType.WINNER_CONTESTANT_2;
        } else {
            throw new IllegalStateException("Winner is not one of the contestants");
        }
    }
}