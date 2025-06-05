import org.junit.jupiter.api.Test;
import org.put.common.Contest;
import org.put.common.contestant.Player;
import org.put.common.contestant.Team;
import org.put.common.events.ScoringEvent;
import org.put.common.match.Outcome;
import org.put.common.match.Result;
import org.put.common.match.OutcomeType;
import org.put.sportspecific.matches.BasketballMatch;
import org.put.sportspecific.matches.FootballMatch;
import org.put.sportspecific.matches.TennisMatch;
import org.put.sportspecific.outcome.TennisOutcomeStrategy;
import org.put.sportspecific.outcome.BasketballOutcomeStrategy;
import org.put.sportspecific.outcome.FootballOutcomeStrategy;
import org.put.sportspecific.scoringstrategy.BasketballScoringStrategy;
import org.put.sportspecific.scoringstrategy.FootballScoringStrategy;   
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
        match.addEvent(new ScoringEvent(Timestamp.from(Instant.now()), "Set 1", player2, result, contest));
        match.addEvent(new ScoringEvent(Timestamp.from(Instant.now()), "Set 1", player2, result, contest));
        match.addEvent(new ScoringEvent(Timestamp.from(Instant.now()), "Set 1", player1, result, contest));
        match.finish();

        match.evaluateOutcome();
        assert match.getOutcomeType() == OutcomeType.WINNER_CONTESTANT_2;
    }

    @Test
    void testBasketballMatchFlow() {
        var team1 = new Team("Team 1", "Basketball", "Spain");
        var team2 = new Team("Team 2", "Basketball", "France");
        Result result = new Result(new BasketballScoringStrategy(), List.of(team1, team2));

        var contest = new Contest("Basketball Contest");
        var match = new BasketballMatch(team1, team2);
        match.setResult(result);
        contest.addMatch(match);

        match.start();
        match.addEvent(new ScoringEvent(Timestamp.from(Instant.now()), "Quarter 1", team1, result, contest));
        match.addEvent(new ScoringEvent(Timestamp.from(Instant.now()), "Quarter 2", team1, result, contest));
        match.addEvent(new ScoringEvent(Timestamp.from(Instant.now()), "Quarter 3", team2, result, contest));
        match.addEvent(new ScoringEvent(Timestamp.from(Instant.now()), "Quarter 4", team2, result, contest));
        match.finish();

        match.evaluateOutcome();
        assert match.getOutcomeType() == OutcomeType.DRAW;
    }

    @Test
    void testFootballMatchFlow() {
        var team1 = new Team("Team 1", "Football", "Germany");
        var team2 = new Team("Team 2", "Football", "Italy");
        Result result = new Result(new FootballScoringStrategy(), List.of(team1, team2));

        var contest = new Contest("Football Contest");
        var match = new FootballMatch(team1, team2);
        match.setResult(result);
        contest.addMatch(match);

        match.start();
        match.addEvent(new ScoringEvent(Timestamp.from(Instant.now()), "First Half", team1, result, contest));
        match.addEvent(new ScoringEvent(Timestamp.from(Instant.now()), "Second Half", team2, result, contest));
        match.finish();

        match.evaluateOutcome();
        assert match.getOutcomeType() == OutcomeType.DRAW;
    }

}