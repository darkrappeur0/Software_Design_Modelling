package org.put.sportspecific.matches;

import java.util.List;

import org.put.common.contestant.Contestant;
import org.put.common.events.Event;
import org.put.common.match.Match;
import org.put.common.match.Result;
import org.put.sportspecific.outcome.TennisOutcomeStrategy;
import org.put.sportspecific.scoringstrategy.TennisScoringStrategy;

/**
 * A concrete Match for tennis.
 * Delegates set‐counting to TennisScoringStrategy.
 */
public class TennisMatch extends Match {

    public TennisMatch(Contestant home, Contestant away) {
        super(home, away, new TennisOutcomeStrategy());
    }

    @Override
    protected void start() {
        System.out.println("Tennis: Coin toss, first serve. Begin set 1.");
        // Sport‐specific “start” logic here.
    }

    @Override
    protected void trackEvents() {
        // Optional polling; 
    }

    @Override
    protected void stop() {
        System.out.println("Tennis: End of set. Change‐over.");
        // Sport‐specific “pause” logic here.
    }

    @Override
    protected void finish() {
        System.out.println("Tennis: Match over. Final set complete.");

        List<Contestant> contestants = List.of(getHomeContestant(), getAwayContestant());
        Result r = new Result(new TennisScoringStrategy(), contestants);

        for (Event e : getEvents()) {
            r.update(e);
        }

        setResult(r);
    }
}

