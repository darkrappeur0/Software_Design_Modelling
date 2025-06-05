package org.put.common.events;

import org.put.common.Contest;
import org.put.common.contestant.Contestant;
import org.put.common.match.Result;

import java.security.Timestamp;

public class ScoringEvent extends Event {
    private Result result;
    
    public ScoringEvent(Timestamp timestamp, String matchpart, Contestant contestant, int typeEvent, Contest contest) {
        super(timestamp, matchpart, contestant, typeEvent, contest);
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

}