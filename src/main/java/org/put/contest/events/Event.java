package org.put.contest.events;
import org.put.contest.contestant;
import  org.put.contest.Contest.java;
import org.put.contest.contestant.Contestant;

import java.security.Timestamp;


public abstract class Event{
    private Timestamp timestamp;
    private String matchpart;
    private Contestant contestant;
    private int typeEvent;
    private Contest contest;

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

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getMatchpart() {
        return matchpart;
    }

    public void setMatchpart(String matchpart) {
        this.matchpart = matchpart;
    }

    public int getTypeEvent() {
        return typeEvent;
    }

    public void setTypeEvent(int typeEvent) {
        this.typeEvent = typeEvent;
    }

    public Contestant getContestant() {
        return contestant;
    }

    public void setContestant(Contestant contestant) {
        this.contestant = contestant;
    }

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }
}