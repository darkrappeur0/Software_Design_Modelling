package org.put.common.match;

import java.util.List;
import org.put.common.events.Event;
import org.put.common.contestant.Contestant;

public class Match {

    private final Contestant homeContestant;
    private final Contestant awayContestant;
    private List<Event> events;
    private Result result;
    private Outcome outcome;

    public Match(Contestant homeContestant, Contestant awayContestant) {
        this.homeContestant = homeContestant;
        this.awayContestant = awayContestant;
    }

    public Contestant getHomeContestant() {
        return homeContestant;
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public Contestant getAwayContestant() {
        return awayContestant;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    // Template method
    // public abstract void start();
    // public abstract void stop();
    // public abstract void finish();
}