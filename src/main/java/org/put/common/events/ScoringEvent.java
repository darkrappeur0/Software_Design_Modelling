package org.put.common.events;

import org.put.common.Contest;
import org.put.common.contestant.Contestant;
import org.put.common.match.Result;

import java.security.Timestamp;

public class ScoringEvent extends Event {
    private Result result;

    public ScoringEvent(Timestamp timestamp, String matchpart, Contestant contestant,  Contest contest) {
        super(timestamp, matchpart, contestant, 1, contest);
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Event{"+
                    " Timestamp: '" +getTimestamp() +'\'' +
                    "Match Part: '" +getMatchpart() +'\'' +
                    "Responsible '" +getContestant()+'\'' +
                    "Result '"+result.getScores()+'\'' +
                    "}";
    }

}