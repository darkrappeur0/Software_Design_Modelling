package org.put.common.match;

import org.put.common.contestant.Contestant;
import org.put.common.events.Event;

import java.util.LinkedHashMap;
import java.util.List;

public class Result {

    private final SportScoringStrategy scoringStrategy;

    /**
     * The ordered list of contestants in the match.
     * The first contestant is always the home team, and the second is the away team.
     */
    private final LinkedHashMap<Contestant, Integer> scores;

    public Result(SportScoringStrategy scoringStrategy, List<Contestant> contestants) {
        if (contestants == null || contestants.size() != 2) {
            throw new IllegalArgumentException("Exactly two contestants (home and away) are required");
        }
        this.scoringStrategy = scoringStrategy;
        this.scores = new LinkedHashMap<>();
        for (var contestant : contestants) {
            scores.put(contestant, 0);
        }
    }

    public void update(Event event) {
        var contestant = event.getContestant();
        var baseScore = scores.get(contestant);
        var updatedScore = scoringStrategy.increaseScore(baseScore, event);
        scores.put(contestant, updatedScore);
    }

    public LinkedHashMap<Contestant, Integer> getScores() {
        return scores;
    }

}