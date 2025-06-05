import org.junit.jupiter.api.Test;
import org.put.common.Contest;
import org.put.common.contestant.Player;
import org.put.common.events.ScoringEvent;
import org.put.common.match.Outcome;
import org.put.common.match.Result;
import org.put.sportspecific.matches.TennisMatch;
import org.put.sportspecific.outcome.TennisOutcomeStrategy;
import org.put.sportspecific.scoringstrategy.TennisScoringStrategy;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

class MatchFlowTest {

    @Test
    void testTennisMatchFlowAndGameEnd() {
        var player1 = new Player("Player 1", "Tennis", "UK", 202f, 100f);
        var player2 = new Player("Player 1", "Tennis", "USA", 202f, 100f);
        Result result = new Result(new TennisScoringStrategy(), List.of(player1, player2));

        // Simulate a tennis match
        var contest = new Contest("Tennis contest");
        var match = new TennisMatch(player1, player2);
        match.setResult(result);
        contest.addMatch(match);

        match.start();
        match.addEvent(new ScoringEvent(Timestamp.from(Instant.now()), "Set 1", player1, result, contest));
        match.addEvent(new ScoringEvent(Timestamp.from(Instant.now()), "Set 1", player2, result, contest));
        match.addEvent(new ScoringEvent(Timestamp.from(Instant.now()), "Set 1", player1, result, contest));
        match.addEvent(new ScoringEvent(Timestamp.from(Instant.now()), "Set 1", player1, result, contest));
        match.addEvent(new ScoringEvent(Timestamp.from(Instant.now()), "Set 1", player1, result, contest));
        match.finish();

        match.evaluateOutcome();
    }
}