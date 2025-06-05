package org.put.common.match;

import java.util.ArrayList;
import java.util.List;

import org.put.common.contestant.Contestant;
import org.put.common.events.Event;
import org.put.common.events.ScoringEvent;

public abstract class Match {
    private final Contestant homeContestant;
    private final Contestant awayContestant;
    private final List<Event> events = new ArrayList<>();
    private Result result;
    private OutcomeType outcomeType;

    /**
     * Each Match carries its own OutcomeStrategy. Subclasses
     * must supply the correct strategy at construction time.
     */
    private final OutcomeStrategy outcomeStrategy;

    /**
     * @param homeContestant   the “home” side
     * @param awayContestant   the “away” side
     * @param outcomeStrategy  sport‐specific logic for deciding winner vs draw
     */
    public Match(Contestant homeContestant,
                 Contestant awayContestant,
                 OutcomeStrategy outcomeStrategy) {
        this.homeContestant = homeContestant;
        this.awayContestant = awayContestant;
        this.outcomeStrategy = outcomeStrategy;
    }

    public Contestant getHomeContestant() {
        return homeContestant;
    }

    public Contestant getAwayContestant() {
        return awayContestant;
    }

    public List<Event> getEvents() {
        return events;
    }

    /** Add a new Event (e.g. basket, goal, point) to this match’s timeline. */
    public void addEvent(Event event) {
        events.add(event);
        if (event instanceof ScoringEvent) {
            result.update(event);
        }
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public OutcomeType getOutcomeType() {
        return outcomeType;
    }

    private void setOutcomeType(OutcomeType outcomeType) {
        this.outcomeType = outcomeType;
    }

    /**
     * The template method: defines the fixed steps for playing any Match.
     * Subclasses supply sport‐specific behavior for start/stop/finish.
     */
    public final void playMatch() {
        initializeMatch();
        start();           // SPORT‐SPECIFIC: tip‐off / kickoff / coin toss
        trackEvents();     // Optional hook: override if you want to poll events
        stop();            // SPORT‐SPECIFIC: halftime / set‐end / quarter‐break
        finish();          // SPORT‐SPECIFIC: finalize scores into Result
        evaluateOutcome(); // COMMON: use injected OutcomeStrategy
    }

    /** SPORT‐SPECIFIC: start the clock, notify any services, etc. */
    public abstract void start();

    /** SPORT‐SPECIFIC: a “pause” in play (e.g. halftime, set changeover). */
    public abstract void stop();

    /** SPORT‐SPECIFIC: end of match—tally events → populate Result. */
    public abstract void finish();

    /**
     * Hook: by default, does nothing. Overrided in subclass to
     * poll/subscription‐loop for real‐time Event objects.
     */
    public void trackEvents() {
        // Default: no continuous polling. Subclasses override if needed.
    }

    /** Common initialization before “start”. */
    private void initializeMatch() {
        System.out.println("Initializing match: "
            + homeContestant.getName() + " vs. " + awayContestant.getName());
    }

    /** Uses the injected OutcomeStrategy to compute DRAW / WINNER_1 / WINNER_2. */
    public void evaluateOutcome() {
        if (this.result == null) {
            throw new IllegalStateException("Result must be set before evaluating outcome.");
        }

        Outcome outcome = new Outcome(this.result, this.outcomeStrategy);
        setOutcomeType(outcome.getOutcomeType());
        System.out.println("Computed outcome: " + getOutcomeType());
    }
}
