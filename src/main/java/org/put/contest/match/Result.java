package org.put.contest.match;

import org.put.contest.contestant.Contestant;
import org.put.contest.events.Event;

import java.util.HashMap;

public class Result {

    private final SportScoringStrategy scoringStrategy;
    private HashMap<Contestant, Integer> scores;

    public Result(SportScoringStrategy scoringStrategy) {
        this.scoringStrategy = scoringStrategy;
        this.scores = new HashMap<>();
    }

    // Here we will have and observer that will be notified about the scoring event and increase score

    public void update(Event event) {
        var contestant = event.getContestant();
        var baseScore = scores.get(contestant);
        var updatedScore = scoringStrategy.increaseScore(baseScore, event);
        scores.put(contestant, updatedScore);
    }



}