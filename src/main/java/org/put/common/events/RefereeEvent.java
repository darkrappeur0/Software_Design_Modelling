package org.put.common.events;

import org.put.common.Contest;
import org.put.common.contestant.Contestant;
import org.put.common.match.Result;

import java.security.Timestamp;

public class RefereeEvent extends Event{
    private Event TriggerEvent;
    private Event FollowingEvent;

    public RefereeEvent(Timestamp timestamp, String matchpart, Contestant contestant, Contest contest,Event Trigger) {
        super(timestamp, matchpart, contestant, 0, contest);
        TriggerEvent = Trigger;
        if (Trigger.getTypeEvent()==0){
            Trigger.setFollowingEvent(this);
        }
    }
    public Event getTriggerEvent(){
        return TriggerEvent;
    }
    public Event getFollowingEvent(){
        return FollowingEvent;
    }
    public void setFollowingEvent(Event Following){
        FollowingEvent = Following;
    }

    @Override
    public String toString() {
        return "Event{"+
                    " Timestamp: '" +getTimestamp() +'\'' +
                    "Match Part: '" +getMatchpart() +'\'' +
                    "Responsible '" +getContestant()+'\'' +
                    "What trigger him'"+GetTriggerEvent()+'\'' +
                    "What he triggered'"+GetFollowingEvent()+'\'' +
                    "}";
    }

}