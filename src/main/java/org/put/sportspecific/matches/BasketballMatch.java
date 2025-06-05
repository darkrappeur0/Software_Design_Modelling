package org.put.sportspecific.matches;

import java.util.List;

import org.put.common.contestant.Contestant;
import org.put.common.events.Event;
import org.put.common.match.Match;
import org.put.common.match.Result;
import org.put.sportspecific.outcome.BasketballOutcomeStrategy;
import org.put.sportspecific.scoringstrategy.BasketballScoringStrategy;

/**
 * A concrete Match for basketball.
 * Delegates point‐counting to BasketballScoringStrategy.
 */
public class BasketballMatch extends Match {

    public BasketballMatch(Contestant home, Contestant away) {
        super(home, away, new BasketballOutcomeStrategy());
    }

    @Override
    protected void start() {
        System.out.println("Basketball: Tip‐off! Game clock starts.");
        // Any sport‐specific “start” logic goes here.
    }

    @Override
    protected void trackEvents() {
        // Optional polling/subscription logic. 
        // Typically you’ll just addEvent(...) externally, so no-op is fine.
    }

    @Override
    protected void stop() {
        System.out.println("Basketball: Halftime / quarter break.");
        // Any sport‐specific “pause” logic goes here.
    }

    @Override
    protected void finish() {
        System.out.println("Basketball: Final buzzer. Tallying all points.");

        // Building a new Result, passing in the basketball strategy and [home, away]
        List<Contestant> contestants = List.of(getHomeContestant(), getAwayContestant());
        Result r = new Result(new BasketballScoringStrategy(), contestants);

        // For every Event, letting the strategy decide how the score changes
        for (Event e : getEvents()) {
            r.update(e);
        }

        // Storing the final Result so evaluateOutcome() can run
        setResult(r);
    }
}

