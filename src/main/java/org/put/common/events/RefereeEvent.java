package org.put.common.events;

import org.put.common.Contest;
import org.put.common.contestant.Contestant;
import org.put.common.match.Result;

import java.security.Timestamp;

public class RefereeEvent extends Event{
    private Event TriggerEvent;
    private Event FollowingEvent;

    public RefereeEvent(Timestamp timestamp, String matchpart, Contestant contestant, int typeEvent, Contest contest, Result result,Event Trigger) {
        super(timestamp, matchpart, contestant, typeEvent, contest, result);
        TriggerEvent = Trigger;
    }
    public Event GetTriggerEvent(){
        return TriggerEvent;
    }
    public Event GetFollowingEvent(){
        return FollowingEvent;
    }
    public void SetFollowingEvent(Event Following){
        FollowingEvent = Following;
    }
    
}