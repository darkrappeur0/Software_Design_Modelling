package org.put.common.events;
import org.put.common.Contest;
import org.put.common.contestant.Contestant;
import org.put.common.match.Result;

import java.security.Timestamp;

public abstract class Event {
    private final Timestamp timestamp;
    private final String matchpart;
    private final Contestant contestant;
    private final int typeEvent;
    private final Contest contest;
    

    public Event(Timestamp timestamp, String matchpart, Contestant contestant, int typeEvent, Contest contest) {
        this.timestamp = timestamp;
        this.matchpart = matchpart;
        this.contestant = contestant;
        this.typeEvent = typeEvent;
        this.contest = contest;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getMatchpart() {
        return matchpart;
    }

    public int getTypeEvent() {
        return typeEvent;
    }

    public Contestant getContestant() {
        return contestant;
    }

    public Contest getContest() {
        return contest;
    }

    
     @Override
    public String toString() {
        return "Event{"+
                    " Timestamp: '" +getTimestamp() +'\'' +
                    "Match Part: '" +getMatchpart() +'\'' +
                    "Responsible '" +getContestant()+'\'' +
                    "}";

    }
}