package org.put.sportspecific.matches;

import java.util.List;

import org.put.common.contestant.Contestant;
import org.put.common.events.Event;
import org.put.common.match.Match;
import org.put.common.match.Result;
import org.put.sportspecific.outcome.FootballOutcomeStrategy;
import org.put.sportspecific.scoringstrategy.FootballScoringStrategy;

/**
 * A concrete Match for soccer/football.
 * Delegates goal‐counting to FootballScoringStrategy.
 */
public class FootballMatch extends Match {

    public FootballMatch(Contestant home, Contestant away) {
        super(home, away, new FootballOutcomeStrategy());
    }

    @Override
    protected void start() {
        System.out.println("Football: Kickoff! 45‐minute half begins.");
        // Sport‐specific “start” logic here.
    }

    @Override
    protected void trackEvents() {
        // Optional polling;
    }

    @Override
    protected void stop() {
        System.out.println("Football: Halftime whistle. 15‐minute break.");
        // Sport‐specific “pause” logic here.
    }

    @Override
    protected void finish() {
        System.out.println("Football: Full‐time whistle. 90 minutes complete.");

        List<Contestant> contestants = List.of(getHomeContestant(), getAwayContestant());
        Result r = new Result(new FootballScoringStrategy(), contestants);

        for (Event e : getEvents()) {
            r.update(e);
        }

        setResult(r);
    }
}

